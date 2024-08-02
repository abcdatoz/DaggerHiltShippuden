package abcdatoz.code.daggerhiltshippuden.firestore

import abcdatoz.code.daggerhiltshippuden.firestore.models.Categoria
import abcdatoz.code.daggerhiltshippuden.firestore.models.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirestoreManagerX {
    private val firestore = FirebaseFirestore.getInstance()

    var userId = "elid"


    //restaurants
    fun getRestaurants(): Flow<List<Restaurant>> = callbackFlow {

        val ref = firestore.collection("restaurant").orderBy("nombre")

        val subscription = ref.addSnapshotListener { snapshot, _ ->

            snapshot?.let { querySnapshot ->
                val restaurantes = mutableListOf<Restaurant>()

                for (document in querySnapshot) {
                    val registro = document.toObject(Restaurant::class.java)
                    registro?.id = document.id
                    registro?.let { restaurantes.add(it) }
                }

                trySend(restaurantes).isSuccess
            }
        }
        awaitClose { subscription.remove() }
    }


    suspend fun addRestaurant(restaurant: Restaurant) {
        restaurant.userId = userId
        firestore.collection("restaurant").add(restaurant).await()
    }

    suspend fun updateRestaurant(restaurant: Restaurant){
        val registro = restaurant.id?.let {
            firestore.collection("restaurant").document(it)
        }
        registro?.set(restaurant)?.await()
    }

    suspend fun deleteRestaurant(id: String){
        val registro = firestore.collection("restaurant").document(id)
        registro.delete().await()
    }
    //end restaurant operations

    //




}