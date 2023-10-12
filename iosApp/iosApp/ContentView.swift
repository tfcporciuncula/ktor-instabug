import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()

	var body: some View {
    Button(action: {
      Task { try await KtorClient.shared.submitForm() }
    }, label: {
      Text("Trigger data form request")
    })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
