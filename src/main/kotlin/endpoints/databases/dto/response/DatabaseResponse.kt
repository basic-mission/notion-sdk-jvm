package endpoints.databases.dto.response

import endpoints.common.FileResponse
import endpoints.common.IconObject
import endpoints.common.RichTextObjectResponse
import endpoints.users.dto.response.PartialUserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DatabaseResponse(
	@SerialName("object")
	var objects: String = "database",

	val id: String,

	@SerialName("created_time")
	val createdTime: String,

	@SerialName("created_by")
	val createdBy: PartialUserResponse,

	@SerialName("last_edited_time")
	val lastEditedTime: String,

	@SerialName("last_edited_by")
	val lastEditedBy: PartialUserResponse,

	val title: List<RichTextObjectResponse>,

	val icon: IconObject?,

	val cover: FileResponse.External?,

	val properties: Map<String, DatabasePropertyResponse>,

	val parent: Parent,

	val url: String,

	val archived: Boolean
)

@Serializable
sealed class Parent {
	abstract val type: String

	@Serializable
	@SerialName("page")
	data class Page(
		override val type: String = "page_id",

		@SerialName("page_id")
		val pageId: String,
	) : Parent()

	@Serializable
	@SerialName("workspace")
	data class Workspace(
		override val type: String = "workspace",

		@SerialName("workspace")
		val workspace: Boolean = true,
	) : Parent()
}
