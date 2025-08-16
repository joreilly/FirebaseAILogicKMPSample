package dev.johnoreilly.vertexai.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.johnoreilly.vertexai.GenerativeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Serializable
data class Entity(
    val name: String,
    val country: String
)

sealed class GenerativeModelUIState {
    data object Initial : GenerativeModelUIState()
    data object Loading : GenerativeModelUIState()
    data class Success(
        val textContent: String? = null,
        val entityContent: List<Entity>? = null,
        val imageData: ByteArray? = null
    ) : GenerativeModelUIState()

    data class Error(val message: String) : GenerativeModelUIState()
}


class GenerativeModelViewModel(private val generativeModel: GenerativeModel) : ViewModel() {
    val uiState = MutableStateFlow<GenerativeModelUIState>(GenerativeModelUIState.Initial)

    fun generateContent(prompt: String, generateJson: Boolean) {
        uiState.update {
            GenerativeModelUIState.Loading
        }
        viewModelScope.launch {
            try {
                if (generateJson) {
                    val response = generativeModel.generateJsonContent(prompt)
                    if (response != null) {
                        val entities = Json.decodeFromString<List<Entity>>(response)
                        uiState.update { GenerativeModelUIState.Success(entityContent = entities) }
                    } else {
                        uiState.update {
                            GenerativeModelUIState.Error("Error generating content")
                        }
                    }
                } else {
                    val response = generativeModel.generateTextContent(prompt)
                    uiState.update { GenerativeModelUIState.Success(textContent = response) }
                }
            } catch (e: Exception) {
                uiState.update {
                    GenerativeModelUIState.Error(
                        e.message ?: "Error generating content"
                    )
                }
            }
        }
    }

    fun generateImage(prompt: String) {
        uiState.update {
            GenerativeModelUIState.Loading
        }
        viewModelScope.launch {
            try {
                val imageData = generativeModel.generateImage(prompt)
                uiState.update {
                    GenerativeModelUIState.Success(imageData = imageData)
                }
            } catch (e: Exception) {
                uiState.update {
                    GenerativeModelUIState.Error(
                        e.message ?: "Error generating content"
                    )
                }
            }
        }
    }
}

