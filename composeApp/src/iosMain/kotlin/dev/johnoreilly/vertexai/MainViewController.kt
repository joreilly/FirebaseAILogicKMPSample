package dev.johnoreilly.vertexai

import androidx.compose.ui.window.ComposeUIViewController
import dev.johnoreilly.vertexai.di.initKoin
import dev.johnoreilly.vertexai.ui.App
import org.koin.dsl.module

fun MainViewController(
    generativeModel: GenerativeModel,
) = ComposeUIViewController(
    configure = {
        initKoin(
            platformModule =  module { single<GenerativeModel> { generativeModel } }
        )
    }
) {
    App()
}