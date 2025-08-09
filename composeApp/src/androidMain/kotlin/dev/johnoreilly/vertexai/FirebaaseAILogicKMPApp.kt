package dev.johnoreilly.vertexai

import android.app.Application
import com.google.firebase.FirebaseApp
import dev.johnoreilly.vertexai.di.initialiseKoin


class FirebaaseAILogicKMPApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        initialiseKoin()
    }
}
