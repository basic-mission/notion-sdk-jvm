package endpoints.users.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserListResponse(
    @SerialName("object")
    val objects: String = "list",
    val results: List<UserResponse>
)