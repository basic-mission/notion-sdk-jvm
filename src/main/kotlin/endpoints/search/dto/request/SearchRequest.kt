package endpoints.search.dto.request

import endpoints.common.PaginationRequest
import endpoints.common.SortObject
import kotlinx.serialization.Serializable

@Serializable
data class SearchRequest(
	val query: String,
	val sort: SortObject? = null,
	val filter: FilterSearchObject? = null
) : PaginationRequest()