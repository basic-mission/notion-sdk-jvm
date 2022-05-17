package endpoints.blocks.dto.request

import endpoints.common.PaginationRequest

data class BlockListRequest(
	val blockId: String
) : PaginationRequest()