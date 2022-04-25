package endpoints.common

import kotlinx.serialization.Serializable

@Serializable
sealed class IconObejct {
	abstract class File : FileResponse()
	abstract class Emoji(override val emoji: String) : EmojiObject(emoji)
}
