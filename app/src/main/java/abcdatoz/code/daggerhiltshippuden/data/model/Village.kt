package abcdatoz.code.daggerhiltshippuden.data.model

import com.google.gson.annotations.SerializedName

data class Village(
    @SerializedName("characters") val characters: List<Int>,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val villita: String
)