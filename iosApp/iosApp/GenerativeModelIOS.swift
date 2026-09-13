import ComposeApp
import FirebaseAI
import Foundation

final class GenerativeModelIOS: ComposeApp.SwiftBase, ComposeApp.GenerativeModel {
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

    func generateTextContent(prompt: String) async throws -> String? {
        let model = ai.generativeModel(
            modelName: util.GEMINI_MODEL
        )

        return try await model.generateContent(prompt).text
    }

    func generateJsonContent(prompt: String) async throws -> String? {
        let model = ai.generativeModel(
            modelName: util.GEMINI_MODEL,
            generationConfig: GenerationConfig(
                responseMIMEType: "application/json",
                responseSchema: jsonSchema
            )
        )

        return try await model.generateContent(prompt).text
    }

    func generateImage(prompt: String) async throws -> ExportedKotlinPackages.kotlin.ByteArray? {
        let model = ai.imagenModel(modelName: util.IMAGE_MODEL)

        let response = try await model.generateImages(prompt: prompt)

        guard let image = response.images.first else {
          return nil
        }

        return utils.toByteArray(image.data as NSData)
    }
}
