package endpoints.databases

import io.ktor.client.*

open class Databases(
	private val ktorClient: HttpClient,

	) {

	suspend fun query() {}

	suspend fun create() {}

	suspend fun update() {}

	suspend fun retrieve() {}
}
