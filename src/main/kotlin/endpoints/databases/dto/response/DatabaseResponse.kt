package endpoints.databases.dto.response

import endpoints.common.FileResponse
import endpoints.common.IconObejct
import endpoints.common.RichTextObjectResponse
import endpoints.users.dto.resposne.PartialUserResponse
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

	val title: Array<RichTextObjectResponse>,

	val icon: IconObejct,

	val cover: FileResponse.External,

	val properties: Map<String, DatabasePropertyResponse>,

	val parent: Parent,

	val url: String,

	val archived: Boolean
) {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as DatabaseResponse

		if (objects != other.objects) return false
		if (id != other.id) return false
		if (createdTime != other.createdTime) return false
		if (createdBy != other.createdBy) return false
		if (lastEditedTime != other.lastEditedTime) return false
		if (lastEditedBy != other.lastEditedBy) return false
		if (!title.contentEquals(other.title)) return false
		if (icon != other.icon) return false
		if (cover != other.cover) return false
		if (properties != other.properties) return false
		if (parent != other.parent) return false
		if (url != other.url) return false
		if (archived != other.archived) return false

		return true
	}

	override fun hashCode(): Int {
		var result = objects.hashCode()
		result = 31 * result + id.hashCode()
		result = 31 * result + createdTime.hashCode()
		result = 31 * result + createdBy.hashCode()
		result = 31 * result + lastEditedTime.hashCode()
		result = 31 * result + lastEditedBy.hashCode()
		result = 31 * result + title.contentHashCode()
		result = 31 * result + icon.hashCode()
		result = 31 * result + cover.hashCode()
		result = 31 * result + properties.hashCode()
		result = 31 * result + parent.hashCode()
		result = 31 * result + url.hashCode()
		result = 31 * result + archived.hashCode()
		return result
	}
}

@Serializable
data class Parent(
	val type: String = "page_id",

	@SerialName("page_id")
	val pageId: String,
)