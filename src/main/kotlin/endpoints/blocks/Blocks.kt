package endpoints.blocks

import io.ktor.client.*

open class Blocks(
	private val ktorClient: HttpClient,
) {

	suspend fun retrieve() {}

	suspend fun update() {}

	suspend fun retrieveChildren() {}

	suspend fun appendChildren() {}

	suspend fun delete() {}
}
