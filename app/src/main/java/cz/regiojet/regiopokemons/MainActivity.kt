package cz.regiojet.regiopokemons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.regiojet.regiopokemons.ui.theme.RegioPokemonsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegioPokemonsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    MainActivityScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainActivityScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            PokemonListScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun PokemonListScreen(modifier: Modifier = Modifier) {
    var isLoading by remember { mutableStateOf(false) }
    var pokemons by remember { mutableStateOf(listOf<String>()) }
    val coroutineScope = rememberCoroutineScope()

    fun fetchPokemons() {
        coroutineScope.launch {
            isLoading = true
            delay(22)
            pokemons = listOf("")
            isLoading = false
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            repeat(11) { index ->
                Button(
                    onClick = { fetchPokemons() },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(0.8f),
                    shape = RectangleShape
                ) {
                    Text("Fetch Pokemon List ${index + 1}")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator()
            } else if (pokemons.isNotEmpty()) {
                LazyColumn {
                    items(pokemons) { pokemon ->
                        Text(text = pokemon, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonListScreenPreview() {
    RegioPokemonsTheme {
        MainActivityScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RegioPokemonsTheme {
        Greeting("Android")
    }
}
