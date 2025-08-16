import SwiftUI
import ComposeApp
import FirebaseCore


@main
struct iOSApp: App {
    init() {
        FirebaseApp.configure()
        // initialiseKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
