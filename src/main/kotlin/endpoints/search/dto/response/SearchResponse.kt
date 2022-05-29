package endpoints.search.dto.response

import endpoints.common.EmptyObject
import endpoints.common.FileResponse
import endpoints.common.IconObject
import endpoints.common.RichTextObject
import endpoints.databases.dto.response.DatabaseParent
import endpoints.databases.dto.response.DatabasePropertyResponse
import endpoints.pages.dto.response.PageParent
import endpoints.pages.dto.response.PagePropertyResponse
import endpoints.users.dto.response.PartialUserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
data class SearchResponse(
	@SerialName("object")
	val objects: String = "list",

	val results: List<SearchListResponse>,

	@SerialName("next_cursor")
	val nextCursor: String? = null,

	@SerialName("has_more")
	val hasMore: Boolean,

	val type: String = "page_or_database",

	@SerialName("page_or_database")
	val pageOrDatabase: EmptyObject
)

@Serializable
@JsonClassDiscriminator("object")
sealed class SearchListResponse {

	@Serializable
	@SerialName("database")
	data class Database(
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

		val title: List<RichTextObject.Text>,

		val icon: IconObject?,

		val cover: FileResponse.External?,

		val properties: Map<String, DatabasePropertyResponse>,

		val parent: DatabaseParent,

		val url: String,

		val archived: Boolean
	) : SearchListResponse()

	@Serializable
	@SerialName("page")
	data class Page(
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
	) : SearchListResponse()
}
