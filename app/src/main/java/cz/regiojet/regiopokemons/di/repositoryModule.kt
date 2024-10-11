package cz.regiojet.regiopokemons.di

import cz.regiojet.regiopokemons.data.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {

    // TODO 1.4 Uncomment repository dependency injection when class is done
    single { PokemonRepository(get()) }
}