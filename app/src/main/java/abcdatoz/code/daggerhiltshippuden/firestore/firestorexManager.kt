package abcdatoz.code.daggerhiltshippuden.firestore

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class firestorexManager {

    private val firestore = FirebaseFirestore.getInstance()


    suspend fun <T> addCollection(collectionName: String, data: T){
        firestore.collection(collectionName).add(data!!).await()
    }

    suspend fun <T> updateDocument(collectionName: String, documentId:String, data: T){
        firestore.collection(collectionName).document(documentId).set(data!!).await()
    }

    suspend fun deleteDocument(collectionName: String, documentId: String){
        firestore.collection(collectionName).document(documentId).delete().await()
    }

    inline fun <reified T> getDocumentsFromCollection(collectionName: String): Flow<List<T>> = callbackFlow {

        val firestoreInstance = FirebaseFirestore.getInstance()

        val collectionRef = firestoreInstance.collection(collectionName)

        val subscription = collectionRef.addSnapshotListener { snapshot, _ ->

            snapshot?.let { querySnapshot ->
                val items = mutableListOf<T>()

                for(document in querySnapshot){
                        val item = document.toObject(T::class.java)
                    items.add(item)
                }

                trySend(items.toList()).isSuccess
            }

        }

        awaitClose { subscription.remove()}


    }



}