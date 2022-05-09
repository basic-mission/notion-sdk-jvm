package endpoints.users.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PartialUserResponse(
    @SerialName("object")
    val objects: String,
    val id: String
)
