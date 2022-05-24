package endpoints.blocks.dto.request

import endpoints.common.PaginationRequest

data class BlockRetrieveChildRequest(
	val blockId: String
) : PaginationRequest()