package endpoints.users.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class UserResponse {
    @SerialName("object")
    val objects: String = "user"
    abstract val id: String
    abstract val type: String?
    abstract val name: String?

    @SerialName("avatar_url")
    abstract val avatarUrl: String?

    @Serializable
    @SerialName("person")
    data class People(
        override val id: String,
        override val type: String? = null,
        override val name: String? = null,
        override val avatarUrl: String? = null,
        val person: Person
    ) : UserResponse()

    @Serializable
    @SerialName("bot")
    data class Bots(
        override val id: String,
        override val type: String? = null,
        override val name: String? = null,
        override val avatarUrl: String? = null,
        val bot: Bot
    ) : UserResponse()
}

@Serializable
data class Person(
    val email: String,
)

@Serializable
data class Bot(
    val owner: Owner
)

@Serializable
data class Owner(
    val type: String,
    val workspace: Boolean = true,
    val user: UserResponse? = null,
)
