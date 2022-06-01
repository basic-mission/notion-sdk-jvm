package endpoints.blocks.dto.request

import common.PaginationRequest

data class BlockRetrieveChildRequest(
	val blockId: String
) : PaginationRequest()