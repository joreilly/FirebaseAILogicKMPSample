![kotlin-version](https://img.shields.io/badge/kotlin-2.2.0-blue?logo=kotlin)

# Firebase AI Logic Compose/Kotlin Multiplatform Sample

Compose/Kotlin Multiplatform sample that makes use of the [Firebase AI Logic SDK](https://firebase.google.com/products/firebase-ai-logic).
The iOS and Android clients share the same Compose UI code but delegate to platform specific Swift and Kotlin code
to invoke the respective SDKs.  Currently generates markdown text, configured json or images (using Imagegen 3)


The project uses the following multiplatform dependencies 

- [Compose Multiplatform](https://jb.gg/compose)
- [Jetpack ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Koin](https://github.com/InsertKoinIO/koin) 
- [Markdown Renderer](https://github.com/mikepenz/multiplatform-markdown-renderer)
- [Coil](https://github.com/coil-kt/coil)


### Related posts

* [Using Vertex AI in a Compose/Kotlin Multiplatform project](https://johnoreilly.dev/posts/vertex-ai-kmp/)


## Screenshots
<img width="749" height="490" alt="Screenshot 2025-08-09 at 15 49 21" src="https://github.com/user-attachments/assets/866c6bc1-91a9-49cf-aaf3-e7921217216f" />



## Full set of Kotlin Multiplatform/Compose/SwiftUI samples

*  PeopleInSpace (https://github.com/joreilly/PeopleInSpace)
*  GalwayBus (https://github.com/joreilly/GalwayBus)
*  Confetti (https://github.com/joreilly/Confetti)
*  BikeShare (https://github.com/joreilly/BikeShare)
*  FantasyPremierLeague (https://github.com/joreilly/FantasyPremierLeague)
*  ClimateTrace (https://github.com/joreilly/ClimateTraceKMP)
*  GeminiKMP (https://github.com/joreilly/GeminiKMP)
*  MortyComposeKMM (https://github.com/joreilly/MortyComposeKMM)
*  StarWars (https://github.com/joreilly/StarWars)
*  WordMasterKMP (https://github.com/joreilly/WordMasterKMP)
*  Chip-8 (https://github.com/joreilly/chip-8)
*  FirebaseAILogicKMPSample (https://github.com/joreilly/FirebaseAILogicKMPSample)
