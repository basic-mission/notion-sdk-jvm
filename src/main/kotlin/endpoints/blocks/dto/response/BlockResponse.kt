package endpoints.blocks.dto.response

import endpoints.users.dto.resposne.PartialUserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class BlockResponse {
	@SerialName("object")
	val objects: String = "block"

	abstract val id: String
	
	abstract val type: String

	@SerialName("created_time")
	abstract val createdTime: String

	@SerialName("createdBy")
	abstract val createdBy: PartialUserResponse

	@SerialName("last_edited_time")
	abstract val lastEditedTime: String

	@SerialName("last_edited_by")
	abstract val lastEditedBy: PartialUserResponse

	abstract val archived: Boolean

	@SerialName("has_children")
	abstract val hasChildren: Boolean
}