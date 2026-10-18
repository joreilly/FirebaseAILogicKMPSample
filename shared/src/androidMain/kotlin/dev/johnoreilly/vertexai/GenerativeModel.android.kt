package dev.johnoreilly.vertexai

import com.google.firebase.Firebase
import com.google.firebase.ai.type.Schema
import com.google.firebase.ai.type.generationConfig
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.ResponseModality
import dev.johnoreilly.vertexai.util.GEMINI_MODEL
import dev.johnoreilly.vertexai.util.IMAGE_MODEL


public class GenerativeModelAndroid : GenerativeModel {
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
            modelName = GEMINI_MODEL
        )

        return generativeModel.generateContent(prompt).text
    }

    override suspend fun generateJsonContent(prompt: String): String? {
        val generativeModel = Firebase.ai.generativeModel(
            modelName = GEMINI_MODEL,
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = jsonSchema
            }
        )

        return generativeModel.generateContent(prompt).text
    }

    // Imagen was removed from firebase-ai (17.17.0+), so images come from a Gemini image model asked
    // for image output; the picture arrives as an inline-data part alongside any text.
    override suspend fun generateImage(prompt: String): ByteArray? {
        val imageModel = Firebase.ai.generativeModel(
            modelName = IMAGE_MODEL,
            generationConfig = generationConfig {
                responseModalities = listOf(ResponseModality.TEXT, ResponseModality.IMAGE)
            }
        )
        return imageModel.generateContent(prompt).inlineDataParts
            .firstOrNull { it.mimeType.startsWith("image/") }
            ?.inlineData
    }
}

