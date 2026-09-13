import SwiftUI
import ComposeApp
import FirebaseCore


@main
struct iOSApp: App {
    init() {
        FirebaseApp.configure()
        di.initialiseKoin(generativeModel: GenerativeModelIOS.shared)
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
