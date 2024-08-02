package abcdatoz.code.daggerhiltshippuden.firebase

import abcdatoz.code.daggerhiltshippuden.firebase.model.Note
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirestoreManager() {
    private val firestore = FirebaseFirestore.getInstance()

    var userId = "peter" //auth.getCurrentUser()?.uid


    suspend fun addNote(note: Note) {

        note.userId = userId

        firestore.collection("notes").add(note).await()
    }

    suspend fun updateNote(note: Note) {

        val noteRef = note.id?.let { firestore.collection("notes").document(it) }

        noteRef?.set(note)?.await()
    }

    suspend fun deleteNote(noteId: String){
        val noteRef = firestore.collection("notes").document(noteId)

        noteRef.delete().await()
    }


    fun getNotesFlow(): Flow<List<Note>> = callbackFlow {

        val noteRef = firestore
            .collection("notes")
            .whereEqualTo("userId", userId)
            .orderBy("titulo")

        val subscription =  noteRef.addSnapshotListener { snapshot, _ ->

            snapshot?.let{  querySnapshot ->
                val notes = mutableListOf<Note>()

                for (document in querySnapshot){
                    val note = document.toObject(Note::class.java)
                    note?.id = document.id
                    note?.let{notes.add(it)}
                }
                trySend(notes).isSuccess
            }
        }

        awaitClose{ subscription.remove()}
    }


}