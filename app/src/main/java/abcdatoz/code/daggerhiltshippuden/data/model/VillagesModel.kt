package abcdatoz.code.daggerhiltshippuden.data.model

import com.google.gson.annotations.SerializedName

data class VillagesModel(
    val currentPage: Int,
    val pageSize: Int,
    val total: Int,
    val villages: List<Village>
)