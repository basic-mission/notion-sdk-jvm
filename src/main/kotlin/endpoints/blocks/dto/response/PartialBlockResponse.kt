package endpoints.blocks.dto.response

import kotlinx.serialization.SerialName

data class PartialBlockResponse(
	@SerialName("object")
	val objects: String = "block",
	val id: String,
)
