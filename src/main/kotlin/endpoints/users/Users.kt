package endpoints.users

import io.ktor.client.*

open class Users(
	private val ktorClient: HttpClient,
) {
	
	suspend fun retrieve() {}

	suspend fun list() {}

	suspend fun me() {}
}
