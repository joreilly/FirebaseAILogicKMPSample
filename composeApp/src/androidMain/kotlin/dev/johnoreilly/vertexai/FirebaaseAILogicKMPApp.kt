package dev.johnoreilly.vertexai

import android.app.Application
import com.google.firebase.FirebaseApp
import dev.johnoreilly.vertexai.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


class FirebaaseAILogicKMPApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        initKoin(
            appDeclaration = {
                androidContext(this@FirebaaseAILogicKMPApp)
            },
            platformModule = module { single<GenerativeModel> { GenerativeModelAndroid() } }
        )
    }
}
