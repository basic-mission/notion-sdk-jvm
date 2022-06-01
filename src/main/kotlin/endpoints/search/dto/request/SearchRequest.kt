package endpoints.search.dto.request

import common.PaginationRequest
import common.SortObject
import kotlinx.serialization.Serializable

@Serializable
data class SearchRequest(
	val query: String,
	val sort: SortObject? = null,
	val filter: FilterSearchObject? = null
) : PaginationRequest()