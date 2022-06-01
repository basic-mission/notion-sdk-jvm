package endpoints.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DateObject(
	val start: String,

	val end: String,

	@SerialName("time_zone")
	val timeZone: String
)
