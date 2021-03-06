package endpoints.search

import Config
import common.DirectionType
import common.SortObject
import common.TimestampType
import endpoints.search.dto.request.SearchRequest
import endpoints.search.dto.response.SearchResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

class SearchTest : AnnotationSpec() {
	private val search: Search = Search(
		getKtorClient((System.getenv("notionApiKey") ?: Config.notionApiKey))
	)

	init {
		(System.getenv("notionApiKey") ?: Config.notionApiKey) shouldNotBe null
		(System.getenv("notionApiKey") ?: Config.notionApiKey) shouldNotBe ""
	}

	@Test
	@DisplayName("[Search] Search Database or Page")
	fun search() {
		val result = runBlocking {
			search.search(
				SearchRequest(
					query = "External tasks",
					sort = SortObject.EntryTimestampSort(
						direction = DirectionType.ASCENDING,
						timestamp = TimestampType.LAST_EDITED_TIME
					)
				)
			)
		}

		result shouldNotBe null
		result is SearchResponse
	}
}