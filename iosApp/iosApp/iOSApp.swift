import SwiftUI
import Instabug

@main
struct iOSApp: App {

  init() {
//    Instabug.disableMethodSwizzling() // Everything works fine when this is uncommented
    Instabug.start(withToken: "dac439f0528a9b846955749816bce619", invocationEvents: .shake)
    Instabug.welcomeMessageMode = .disabled
  }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
