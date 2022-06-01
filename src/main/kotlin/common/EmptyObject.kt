package common

import kotlinx.serialization.Serializable

typealias EmptyObject = Map<String, String>

@Serializable
val Empty: Map<String, String> = mapOf()