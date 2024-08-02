package abcdatoz.code.daggerhiltshippuden.firestore.repos

import abcdatoz.code.daggerhiltshippuden.firestore.firestorexManager
import abcdatoz.code.daggerhiltshippuden.firestore.models.Restaurant
import kotlinx.coroutines.flow.Flow

class RestaurantRepository(private val firestorexManager: firestorexManager) {

    val coleccion: String = "restaurant"

    suspend fun addRestaurant(restaurant: Restaurant) {

        restaurant.urlLogo = "https.pics...."

        firestorexManager.addCollection(coleccion, restaurant)
    }


    suspend fun updateRestaurant(restaurant: Restaurant) {

        restaurant.id?.let {
            firestorexManager.updateDocument(coleccion, it, restaurant)
        }
    }


    suspend fun deleteRestaurant(restaurantId: String){
        firestorexManager.deleteDocument(coleccion,  restaurantId)
    }

    suspend fun getRestaurantFlow(): Flow<List<Restaurant>> {
        return firestorexManager.getDocumentsFromCollection(coleccion)
    }

}