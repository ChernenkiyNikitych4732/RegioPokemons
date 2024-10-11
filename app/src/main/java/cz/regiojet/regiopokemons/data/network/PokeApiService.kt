package cz.regiojet.regiopokemons.data.network

import cz.regiojet.regiopokemons.data.network.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService {

    // TODO: 1.1 Define GET endpoint "pokemon" that returns PokemonResponse object
    //  - Limit max results using query key `limit` and value `20`

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int = 20
    ): PokemonResponse
}