package endpoints.users

import Config
import endpoints.users.dto.response.UserListResponse
import endpoints.users.dto.response.UserResponse
import http.getKtorClient
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.DisplayName

internal class UsersTest : AnnotationSpec() {
	private val users: Users = Users(getKtorClient(Config.notionApiKey))

	init {
		System.getenv("notionApiKey") shouldNotBe null
		System.getenv("notionApiKey") is String
	}

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