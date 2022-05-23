package endpoints.databases

import endpoints.databases.dto.request.DatabaseCreateRequest
import endpoints.databases.dto.request.DatabaseRetrieveRequest
import endpoints.databases.dto.response.DatabaseResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import mu.KotlinLogging

open class Databases(
	private val ktorClient: HttpClient,
) {
	private val logger = KotlinLogging.logger {}

	suspend fun query() {}

	suspend fun create(request: DatabaseCreateRequest): DatabaseResponse? = try {
		ktorClient.post("/v1/databases") {
			setBody(request)
			contentType(ContentType.Application.Json)
		}.body<DatabaseResponse>()
	} catch (error: Exception) {
		logger.error { "[Database.create] ${error.message}" }
		null
	}

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
