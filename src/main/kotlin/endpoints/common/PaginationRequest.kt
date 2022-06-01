package endpoints.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class PaginationRequest(
	@SerialName("start_cursor")
	val startCursor: String? = null,
	@SerialName("page_size")
	val pageSize: Int? = null,
)