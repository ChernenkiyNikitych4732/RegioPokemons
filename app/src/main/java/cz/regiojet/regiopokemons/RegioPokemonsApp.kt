package cz.regiojet.regiopokemons

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import cz.regiojet.regiopokemons.di.repositoryModule
import cz.regiojet.regiopokemons.di.retrofitModule
import cz.regiojet.regiopokemons.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class RegioPokemonsApp : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var appContext: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidLogger(Level.ERROR)

            appContext = applicationContext!!
            androidContext(this@RegioPokemonsApp)
            androidContext(appContext)

            modules(
                retrofitModule,
                repositoryModule,
                viewModelModule,
            )
        }
    }
}