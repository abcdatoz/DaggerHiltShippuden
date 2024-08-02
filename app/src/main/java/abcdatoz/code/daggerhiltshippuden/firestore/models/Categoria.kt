package abcdatoz.code.daggerhiltshippuden.firestore.models

data class Categoria (
    var id: String? = null,
    var clave: String = "",
    var nombre: String = "",
    var imagen: String = "",
    var activo: Boolean = true,
    var idRestaurant: String = ""
)