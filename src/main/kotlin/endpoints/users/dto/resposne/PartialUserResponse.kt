package endpoints.users.dto.resposne

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PartialUserResponse(
	@SerialName("object")
	val objects: String,
	val id: String
)
