package endpoints.common

import endpoints.users.dto.response.UserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class RichTextObjectResponse {
	@SerialName("plain_text")
	abstract val plainText: String

	abstract val href: String?

	abstract val annotations: Annotations

	abstract val type: RichTextObjectType

	@Serializable
	@SerialName("text")
	data class Text(
		@SerialName("plain_text")
		override val plainText: String,
		override val href: String?,
		override val annotations: Annotations,
		override val type: RichTextObjectType = RichTextObjectType.TEXT,

		val text: TextObject
	) : RichTextObjectResponse()

	@Serializable
	@SerialName("mention")
	data class Mention(
		@SerialName("plain_text")
		override val plainText: String,
		override val href: String?,
		override val annotations: Annotations,
		override val type: RichTextObjectType = RichTextObjectType.TEXT,

		val mention: MentionObject
	) : RichTextObjectResponse()

	@Serializable
	@SerialName("equation")
	data class Equation(
		@SerialName("plain_text")
		override val plainText: String,
		override val href: String?,
		override val annotations: Annotations,
		override val type: RichTextObjectType = RichTextObjectType.EQUATION,

		val expression: String
	) : RichTextObjectResponse()
}

@Serializable
enum class RichTextObjectType {
	@SerialName("text")
	TEXT,

	@SerialName("mention")
	MENTION,

	@SerialName("equation")
	EQUATION,
}

@Serializable
data class TextObject(
	val content: String,
	val link: Link?,
)

@Serializable
data class Link(
	val type: String = "url"
)

@Serializable
sealed class MentionObject {
	abstract val type: MentionObjectType

	@Serializable
	@SerialName("user")
	data class User(
		override val type: MentionObjectType = MentionObjectType.USER,

		val user: UserResponse
	) : MentionObject()

	@Serializable
	@SerialName("page")
	data class Page(
		override val type: MentionObjectType = MentionObjectType.PAGE,

		val page: MentionPageObject
	) : MentionObject()

	@Serializable
	@SerialName("database")
	data class Database(
		override val type: MentionObjectType = MentionObjectType.DATABASE,

		val database: MentionDatabaseObject
	) : MentionObject()

	@Serializable
	@SerialName("date")
	data class Date(
		override val type: MentionObjectType = MentionObjectType.DATE,

		val date: DateObject
	) : MentionObject()

	@Serializable
	@SerialName("link_preview")
	data class LinkPreview(
		override val type: MentionObjectType = MentionObjectType.LINK_PREVIEW,

		val url: String
	) : MentionObject()
}

@Serializable
enum class MentionObjectType {
	@SerialName("user")
	USER,

	@SerialName("page")
	PAGE,

	@SerialName("database")
	DATABASE,

	@SerialName("date")
	DATE,

	@SerialName("link_preview")
	LINK_PREVIEW
}

@Serializable
data class MentionPageObject(
	val id: String,
)

@Serializable
data class MentionDatabaseObject(
	val id: String,
)