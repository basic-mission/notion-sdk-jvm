package endpoints.blocks.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class BlockListChildRequest(
	@Serializable
	val children: List<BlockListBodyRequest>
)