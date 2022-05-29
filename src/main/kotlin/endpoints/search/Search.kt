package endpoints.search

import endpoints.search.dto.request.SearchRequest
import endpoints.search.dto.response.SearchResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import mu.KotlinLogging

open class Search(
	private val ktorClient: HttpClient,
) {
	val logger = KotlinLogging.logger {}

	suspend fun search(
		request: SearchRequest
	): SearchResponse? = try {
		ktorClient.post("v1/search") {
			contentType(ContentType.Application.Json)
			setBody(request)
		}.body<SearchResponse>()
	} catch (error: Exception) {
		logger.error { "[Search] ${error.message}" }
		null
	}

}
