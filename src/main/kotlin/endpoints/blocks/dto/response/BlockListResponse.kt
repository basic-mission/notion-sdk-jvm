package endpoints.blocks.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlockListResponse(
	@SerialName("object")
	val objects: String = "list",
	val results: List<BlockResponse>
)