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
        // Gemini image model asked for image output (matches Android, where Imagen was removed from
        // firebase-ai); the picture arrives as an inline-data part alongside any text.
        let model = ai.generativeModel(
            modelName: util.IMAGE_MODEL,
            generationConfig: GenerationConfig(responseModalities: [.text, .image])
        )

        let response = try await model.generateContent(prompt)

        guard let image = response.inlineDataParts.first(where: { $0.mimeType.hasPrefix("image/") }) else {
          return nil
        }

        return utils.toByteArray(image.data as NSData)
    }
}
