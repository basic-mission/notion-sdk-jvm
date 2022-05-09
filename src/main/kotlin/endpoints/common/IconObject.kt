package endpoints.common

import kotlinx.serialization.Serializable

@Serializable
sealed class IconObject {
	abstract class File : FileResponse()
	abstract class Emoji(override val emoji: String) : EmojiObject(emoji)
}
