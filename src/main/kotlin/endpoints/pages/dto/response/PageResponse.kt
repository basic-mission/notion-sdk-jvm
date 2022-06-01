package endpoints.pages.dto.response


import endpoints.common.FileResponse
import endpoints.common.IconObject
import endpoints.databases.dto.response.ParentType
import endpoints.users.dto.response.PartialUserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageResponse(
	@SerialName("object")
	var objects: String = "page",

	val id: String,

	@SerialName("created_time")
	val createdTime: String,

	@SerialName("created_by")
	val createdBy: PartialUserResponse,

	@SerialName("last_edited_time")
	val lastEditedTime: String,

	@SerialName("last_edited_by")
	val lastEditedBy: PartialUserResponse,

	val cover: FileResponse.External?,

	val icon: IconObject?,

	val parent: PageParent,

	val archived: Boolean,

	val properties: Map<String, PagePropertyResponse>,

	val url: String

)

@Serializable
sealed class PageParent {
	abstract val type: ParentType

	@Serializable
	@SerialName("workspace")
	data class Workspace(
		override val type: ParentType = ParentType.WORKSPACE,
		@SerialName("workspace")
		val workspace: Boolean = true,
	) : PageParent()

	@Serializable
	@SerialName("page_id")
	data class Page(
		override val type: ParentType = ParentType.PAGE_ID,
		@SerialName("page_id")
		val pageId: String,
	) : PageParent()

	@Serializable
	@SerialName("database_id")
	data class Database(
		override val type: ParentType = ParentType.DATABASE_ID,
		@SerialName("database_id")
		val databaseId: String,
	) : PageParent()
}