package endpoints.databases

import endpoints.databases.dto.request.DatabaseRetrieveRequest
import endpoints.databases.dto.response.DatabaseResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import mu.KotlinLogging

open class Databases(
	private val ktorClient: HttpClient,
) {
	private val logger = KotlinLogging.logger {}

	suspend fun query() {}

	suspend fun create() {}

	suspend fun update() {}

	suspend fun retrieve(
		request: DatabaseRetrieveRequest
	): DatabaseResponse? = try {
		ktorClient.get("/v1/databases/${request.databaseId}").body<DatabaseResponse>()
	} catch (error: Exception) {
		logger.error { "[Databases.retrieve] ${error.message}" }
		null
	}
}
