package abcdatoz.code.daggerhiltshippuden.data.model

data class VillagesModel(
    val currentPage: Int,
    val pageSize: Int,
    val total: Int,
    val villages: List<Village>
)