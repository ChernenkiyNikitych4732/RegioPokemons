package cz.regiojet.regiopokemons.data.repository

import cz.regiojet.regiopokemons.data.network.PokeApiService;
import cz.regiojet.regiopokemons.data.network.model.PokemonResponse

// TODO 1.2 rename the file appropriately
// TODO 1.3 implement the repository

class PokemonRepository(private val pokeApiService: PokeApiService) {
    // Function to get a list of Pokemons
    suspend fun getPokemons(): PokemonResponse {
        return pokeApiService.getPokemons()
    }
}