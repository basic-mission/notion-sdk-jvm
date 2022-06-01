package endpoints.pages

import Config
import endpoints.pages.dto.request.PageRetrieveRequest
import endpoints.pages.dto.response.PageResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

internal class PagesTest : AnnotationSpec() {
	private val pages: Pages = Pages(
		getKtorClient((System.getenv("notionApiKey") ?: Config.notionApiKey))
	)

	private val pageId: String = (System.getenv("Pages_pageId") ?: Config.Page.pageId)

	init {
		(System.getenv("notionApiKey") ?: Config.notionApiKey) shouldNotBe null
		(System.getenv("notionApiKey") ?: Config.notionApiKey) shouldNotBe ""

		(System.getenv("Pages_pageId") ?: Config.Page.pageId) shouldNotBe null
		(System.getenv("Pages_pageId") ?: Config.Page.pageId) shouldNotBe ""
	}

	@Test
	@DisplayName("[Pages] Retrieve a page")
	fun retrievePage() {
		val result = runBlocking {
			pages.retrieve(
				request = PageRetrieveRequest(
					pageId = this.pageId
				)
			)
		}

		result shouldNotBe null
		result is PageResponse
	}
}