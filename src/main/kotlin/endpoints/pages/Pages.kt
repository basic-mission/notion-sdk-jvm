package endpoints.pages

import endpoints.pages.dto.request.PageRetrieveRequest
import endpoints.pages.dto.response.PageResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import mu.KotlinLogging

open class Pages(
	private val ktorClient: HttpClient,
) {
	private val logger = KotlinLogging.logger {}

	suspend fun retrieve(request: PageRetrieveRequest): PageResponse? = try {
		ktorClient.get("/v1/pages/${request.pageId}").body<PageResponse>()
	} catch (error: Exception) {
		logger.error { "[Pages.retrieve] ${error.message}" }
		null
	}
}
