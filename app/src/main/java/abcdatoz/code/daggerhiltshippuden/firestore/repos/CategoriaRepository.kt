package abcdatoz.code.daggerhiltshippuden.firestore.repos

import abcdatoz.code.daggerhiltshippuden.firestore.models.Categoria
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class CategoriaRepository {

    private val firestore = FirebaseFirestore.getInstance()
    var userid = "el_id"

    fun getCategorias(): Flow<List<Categoria>> = callbackFlow {

        val ref =  firestore.collection("categoria").orderBy("clave")
        val subscription = ref.addSnapshotListener { snapshot, _ ->

            snapshot?.let{querySnapshot ->
                val categorias = mutableListOf<Categoria>()

                for(document in querySnapshot){
                    val registro = document.toObject(Categoria::class.java)
                    registro?.id = document.id
                    registro?.let{ categorias.add(it)}
                }

                trySend(categorias).isSuccess
            }
        }

        awaitClose { subscription.remove()}
    }


    suspend fun addCategoria(categoria: Categoria){
        firestore.collection("categoria").add(categoria).await()
    }

    suspend fun updateCategoria(categoria: Categoria){
        val registro = categoria.id?.let {
            firestore.collection("categoria").document(it)
        }

        registro?.set(categoria)?.await()
    }

    suspend fun deleteCategoria( id: String){
        val registro = firestore.collection("categoria").document(id)
        registro.delete().await()
    }

}