package endpoints.blocks.dto.request

import kotlinx.serialization.Serializable

data class BlockUpdateRequest(
	val blockId: String,
	@Serializable
	val body: BlockBodyRequest
)
