package endpoints.users

import Config
import endpoints.users.dto.resposne.UserListResponse
import endpoints.users.dto.resposne.UserResponse
import http.getKtorClient
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class UsersTest {
	private val users: Users = Users(getKtorClient(Config.notionApiKey))

	@Test
	@DisplayName("[Users] List all users")
	fun getUserList() {
		val result = runBlocking {
			users.list()
		}

		result shouldNotBe null
		result is UserListResponse
	}

	@Test
	@DisplayName("[Users] Retrieve your token's bot user")
	fun getUserMe() {
		val result = runBlocking {
			users.me()
		}

		result shouldNotBe null
		result is UserResponse
	}
}