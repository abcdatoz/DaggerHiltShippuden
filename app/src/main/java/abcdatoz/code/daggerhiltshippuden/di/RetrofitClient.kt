package abcdatoz.code.daggerhiltshippuden.di

import abcdatoz.code.daggerhiltshippuden.data.services.CharacterService
import abcdatoz.code.daggerhiltshippuden.data.services.ClanService
import abcdatoz.code.daggerhiltshippuden.data.services.VillageService
import abcdatoz.code.daggerhiltshippuden.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val clanService: ClanService by lazy { retrofit.create(ClanService::class.java)}
    val villageService: VillageService by lazy { retrofit.create(VillageService::class.java) }
    val characterService: CharacterService by lazy { retrofit.create(CharacterService::class.java) }


}