import ComposeApp
import FirebaseAI
import Foundation

class GenerativeModelIOS: ComposeApp.GenerativeModel {
    static let shared = GenerativeModelIOS()
    
    let ai = FirebaseAI.firebaseAI(backend: .googleAI())
    
    let jsonSchema = Schema.array(
      items: .object(
        properties: [
          "name": .string(),
          "country": .string()
        ]
      )
    )
    
    func __generateTextContent(prompt: String) async throws -> String? {
        let model = ai.generativeModel(
            modelName: "gemini-2.5-flash"
        )

        return try await model.generateContent(prompt).text
    }
    
    
    func __generateJsonContent(prompt: String) async throws -> String? {
        let model = ai.generativeModel(
            modelName: "gemini-2.5-flash",
            generationConfig: GenerationConfig(
                responseMIMEType: "application/json",
                responseSchema: jsonSchema
            )
        )
        
        return try await model.generateContent(prompt).text
    }

    
    func __generateImage(prompt: String) async throws -> KotlinByteArray? {
        let model = ai.imagenModel(modelName: "imagen-4.0-fast-generate-001")
        
        let response = try await model.generateImages(prompt: prompt)
        
        guard let image = response.images.first else {
          return nil
        }
                
        let imageData = image.data
        return imageData.toByteArray()
    }
}
