package endpoints.users

import endpoints.users.dto.request.UserListRequest
import endpoints.users.dto.request.UserRetrieveRequest
import endpoints.users.dto.response.UserListResponse
import endpoints.users.dto.response.UserResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import mu.KotlinLogging

open class Users(
    private val ktorClient: HttpClient,
) {
    private val logger = KotlinLogging.logger {}

    suspend fun retrieve(
        request: UserRetrieveRequest
    ): UserResponse? = try {
        ktorClient.get("/v1/users/${request.userId}").body<UserResponse>()
    } catch (error: Exception) {
        logger.error { "[Users.retrieve] ${error.message}" }
        null
    }

    suspend fun list(
        request: UserListRequest? = null,
    ): UserListResponse? = try {
        ktorClient.get("/v1/users").body<UserListResponse>()
    } catch (error: Exception) {
        logger.error { "[Users.retrieve] ${error.message}" }
        null
    }

    suspend fun me(): UserResponse? = try {
        ktorClient.get("/v1/users/me").body<UserResponse>()
    } catch (error: Exception) {
        logger.error { "[Users.retrieve] ${error.message}" }
        null
    }
}
