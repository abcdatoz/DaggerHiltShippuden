package abcdatoz.code.daggerhiltshippuden.data.model


data class Character(
    val id: Int,
    val images: List<String>,
    val jutsu: List<String>,
    val name: String,
    val natureType: List<String>,
    val tools: List<String>
)