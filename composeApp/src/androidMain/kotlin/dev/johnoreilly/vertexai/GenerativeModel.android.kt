package dev.johnoreilly.vertexai

import com.google.firebase.Firebase
import com.google.firebase.ai.type.PublicPreviewAPI
import com.google.firebase.ai.type.Schema
import com.google.firebase.ai.type.generationConfig
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend


class GenerativeModelAndroid : GenerativeModel {
    private val jsonSchema = Schema.array(
        Schema.obj(
            mapOf(
                "name" to Schema.string(),
                "country" to Schema.string()
            )
        )
    )

    override suspend fun generateTextContent(prompt: String): String? {
        val generativeModel = Firebase.ai(backend = GenerativeBackend.googleAI()).generativeModel(
            modelName = "gemini-2.5-flash"
        )

        return generativeModel.generateContent(prompt).text
    }

    override suspend fun generateJsonContent(prompt: String): String? {
        val generativeModel = Firebase.ai.generativeModel(
            modelName = "gemini-2.5-flash",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = jsonSchema
            }
        )

        return generativeModel.generateContent(prompt).text
    }

    @OptIn(PublicPreviewAPI::class)
    override suspend fun generateImage(prompt: String): ByteArray? {
        val imageModel = Firebase.ai.imagenModel(
            modelName = "imagen-4.0-fast-generate-001"
        )
        val imageResponse = imageModel.generateImages(prompt)
        return if (imageResponse.images.isNotEmpty()) {
            imageResponse.images.first().data
        } else {
            null
        }
    }
}

