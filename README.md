# RegioPokemons

A repository to test basic Android work. There is no project setup needed. You can navigate trough the project using TODOs or following checklist. 

### Set up and Git

1. Get yourself an up to date Android Studio (tested on Android Studio Koala)
2. Open TODOs in the left pane. Additional context is here, in README.
3. Clone the repository.
4. Check out to a custom branch.
5. After you finish all tasks, commit your changes.

### Tasks

1. **Fetch Pokemons - Retrofit**
   - 1.1 - Define GET endpoint `pokemon` inside `PokeApiService`. Limit max results using query `limit` with value `20`.
   - 1.2 - Rename `TemporaryDraftName` file.
   - 1.3 - Implement remote repository layer to process response from the API.
     - Add API service as a parameter of this class.
     - Add basic error handling. 
     - Repository will return `List<PokemonEntity>`.
   - 1.4 - Go to `repositoryModule.kt` and uncomment DI setup

2. **Show results on the screen**
   - 2.1 - Create an observable state holder in `MainActivityViewModel` to hold current UI State.
   - 2.2 - Create a function that will load pokemon list from the repository.
   - 2.3 - In `MainActivity`, collect UI State and implement the screen using Jetpack Compose.
     - The data will be fetched on demand using Button.
     - Nice to have: Show loader when data is being fetched.
     - Show the data to the user in an appropriate way and change color of the text.

3. **Run the app**
   - Run the application to see if your solution works. 

4. **Local data storage - Room**
   - What if we were to save the data to local database? What (3) components would we need?
   - Explain, how would you implement an interface that would communicate with the DB.