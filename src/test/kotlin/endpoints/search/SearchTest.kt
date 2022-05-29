package endpoints.search

import Config
import endpoints.common.DirectionType
import endpoints.common.SortObject
import endpoints.common.TimestampType
import endpoints.search.dto.request.SearchRequest
import endpoints.search.dto.response.SearchResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

class SearchTest : AnnotationSpec() {
	private val search: Search = Search(getKtorClient((Config.notionApiKey)))

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