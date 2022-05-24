package endpoints.blocks.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class BlockAppendChildRequest(
	val blockId: String,
	@Serializable
	val body: BlockListChildRequest
)