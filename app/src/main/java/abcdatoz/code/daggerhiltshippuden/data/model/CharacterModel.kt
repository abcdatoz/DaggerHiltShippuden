package abcdatoz.code.daggerhiltshippuden.data.model

data class CharacterModel(
    val characters: List<Character>,
    val currentPage: Int,
    val pageSize: Int,
    val total: Int
)