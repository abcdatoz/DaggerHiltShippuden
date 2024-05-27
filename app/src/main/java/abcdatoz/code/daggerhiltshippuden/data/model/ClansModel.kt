package abcdatoz.code.daggerhiltshippuden.data.model

data class ClansModel(
    val clans: List<Clan>,
    val currentPage: Int,
    val pageSize: Int,
    val total: Int
)