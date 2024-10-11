# RegioPokemons new variant

A repository to test basic Android work. There is no project setup needed. You can navigate trough the project using TODOs or following checklist.

### Set up and Git

1. Get yourself an up to date Android Studio (tested on Android Studio Koala)
2. Open TODOs in the left pane. Additional context is here, in README.
3. Clone the repository or create a new repository.
4. Check out to a custom branch.
5. After you finish all tasks, commit your changes.

### Tasks

1. **Fetch Pokemons - Retrofit**

- 1.1 We create a define Get end point request throw endpoint 'pokemon' in the 'PokeApiService interface in the package package cz.regiojet.regiopokemons.data.network. The next step is to set up the limit for maximal results requests using query function 'limit' and set the value, what is equal to 20.
- 1.2 We rename the TemporaryDraftName.class to the PokemonRepository.class file in the package package cz.regiojet.regiojetpokemons.data.repository.
- 1.3 We implement remote repository layer to process response from the API
- 1.4 We add API service as a parameter of this class.
- 1.5 We add basic error handling.
- 1.6 We return the Repository in List<PokemonEntity>.
- 1.7 We go the Go to repositoryModule.kt and uncomment DI setup

2. **Show results on the screen**

- 2.1 We create an a new observable state in MainActivityViewModel class file in the package package cz.regiojet.regiojetpokemons to hold current UI State.
- 2.2 We Create a function to load PokemonEntity list from the repository
- 2.3 In MainActivity.kt file we collect collect UI State and implement the screen using Jetpack Compose, add buttons in the MainActivity.kt file. Set up the size for the buttons. Set up the location of button in MainActivity.kt file.

3. **Run the app**

- 3.1 Before to start our app we need to retype our code and apply changes to restart our app in android emulator.
- 3.2 If the changes what we have made in our code and retype our code, the app will starts in android emulator, showing the app logo and will switch to the main page of our app with greeting message and working buttons.
- 3.3 If the changes what we have made in our code and retype our code, and we try to restart our app in android emulator, and see the next message like: RegioJetPokemons keeps stopping, It means the our app in in android emulator has not build correct. In this case we need to look in our code, find the error in our code, resolve the error and retype or reformat our code.

4. **Local data storage - Room**
- 4.1 What if we were to save the data to local database? What (3) components would we need?
- 4.2 Explain, how would you implement an interface that would communicate with the DB.