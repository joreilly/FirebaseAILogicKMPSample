package dev.johnoreilly.vertexai

import androidx.compose.ui.window.ComposeUIViewController
import dev.johnoreilly.vertexai.ui.App
import platform.UIKit.UIViewController

public fun MainViewController(): UIViewController = ComposeUIViewController {
    App()
}