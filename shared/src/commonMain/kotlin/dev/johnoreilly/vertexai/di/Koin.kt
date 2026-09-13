package dev.johnoreilly.vertexai.di

import dev.johnoreilly.vertexai.ui.GenerativeModelViewModel
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC
import org.koin.core.context.startKoin
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


internal val commonModule = module {
    viewModelOf(::GenerativeModelViewModel)
}

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
public fun initKoin(
    appDeclaration: KoinAppDeclaration = {},
    platformModule: Module = module {},
): KoinApplication =
    startKoin {
        println("🔥 Initializing Koin")
        appDeclaration()
        modules(
            platformModule,
            commonModule,
        )
        println("🔥 Koin initialized")
    }