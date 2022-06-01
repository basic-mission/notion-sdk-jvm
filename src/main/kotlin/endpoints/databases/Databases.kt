package endpoints.databases

import endpoints.databases.dto.request.DatabaseCreateRequest
import endpoints.databases.dto.request.DatabaseRetrieveRequest
import endpoints.databases.dto.request.DatabaseUpdateRequest
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
		logger.error { "[Databases.create] ${error.message}" }
		null
	}

	suspend fun update(request: DatabaseUpdateRequest): DatabaseResponse? = try {
		ktorClient.patch("/v1/databases/${request.databaseId}") {
			setBody(request.body)
			contentType(ContentType.Application.Json)
		}.body<DatabaseResponse>()
	} catch (error: Exception) {
		logger.error { "[Databases.update] ${error.message}" }
		null
	}

	suspend fun retrieve(
		request: DatabaseRetrieveRequest
	): DatabaseResponse? = try {
		ktorClient.get("/v1/databases/${request.databaseId}").body<DatabaseResponse>()
	} catch (error: Exception) {
		logger.error { "[Databases.retrieve] ${error.message}" }
		null
	}
}
