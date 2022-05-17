package endpoints.databases

import Config
import endpoints.databases.dto.request.DatabaseRetrieveRequest
import endpoints.databases.dto.response.DatabaseResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

internal class DatabasesTest : AnnotationSpec() {
	private val databases: Databases = Databases(getKtorClient(Config.notionApiKey))

	@Test
	@DisplayName("[Databases] Retrieve a database")
	fun retrieveDatabase() {
		val result = runBlocking {
			databases.retrieve(DatabaseRetrieveRequest(Config.Database.databaseId))
		}

		result shouldNotBe null
		result is DatabaseResponse
	}
}
