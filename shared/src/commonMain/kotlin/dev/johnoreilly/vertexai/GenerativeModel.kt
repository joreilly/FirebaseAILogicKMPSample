package dev.johnoreilly.vertexai

public interface GenerativeModel {
    public suspend fun generateTextContent(prompt: String): String?
    public suspend fun generateJsonContent(prompt: String): String?
    public suspend fun generateImage(prompt: String): ByteArray?
}
