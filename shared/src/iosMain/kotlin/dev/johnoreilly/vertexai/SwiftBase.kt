package dev.johnoreilly.vertexai

/**
 * Base class for Swift types that implement Kotlin interfaces exported via Swift export.
 *
 * Swift export models Kotlin interfaces as protocols refining `KotlinRuntime.KotlinBase`,
 * so a Swift implementation has to inherit from a Kotlin `open class` to be passed back
 * into Kotlin. See `GenerativeModelIOS` in the iOS app.
 */
public open class SwiftBase
