package endpoints.databases.dto.response

import endpoints.common.FileResponse
import endpoints.common.IconObject
import endpoints.common.RichTextObject
import endpoints.users.dto.response.PartialUserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class DatabaseResponse(
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

	val title: List<RichTextObject>,

	val icon: IconObject?,

	val cover: FileResponse.External?,

	val properties: Map<String, DatabasePropertyResponse>,

	val parent: DatabaseParent,

	val url: String,

	val archived: Boolean
)

@Serializable
sealed class DatabaseParent {
	abstract val type: ParentType

	@Serializable
	@SerialName("page_id")
	data class Page(
		override val type: ParentType = ParentType.PAGE_ID,
		@SerialName("page_id") val pageId: String,
	) : DatabaseParent()

	@Serializable
	@SerialName("workspace")
	data class Workspace(
		override val type: ParentType = ParentType.WORKSPACE,
		@SerialName("workspace") val workspace: Boolean = true,
	) : DatabaseParent()
}

@Serializable
enum class ParentType {

	@SerialName("workspace")
	WORKSPACE,

	@SerialName("page_id")
	PAGE_ID,

	@SerialName("database_id")
	DATABASE_ID,
}

