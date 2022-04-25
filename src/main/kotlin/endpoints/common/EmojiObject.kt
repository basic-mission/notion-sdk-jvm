package endpoints.common

import kotlinx.serialization.Serializable

@Serializable
open class EmojiObject(
	open val emoji: String
) {
	val type: String = "emoji"
}
