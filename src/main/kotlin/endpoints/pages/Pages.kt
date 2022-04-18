package endpoints.pages

import io.ktor.client.*

open class Pages(
	private val ktorClient: HttpClient,
) {

	suspend fun retrieve() {}

	suspend fun create() {}

	suspend fun update() {}

	suspend fun archive() {}

	suspend fun retrievePropertyItem() {}
}
