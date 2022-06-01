package endpoints.search.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilterSearchObject(
	val value: ValueType,
	val property: String = "object"
)

@Serializable
enum class ValueType {
	@SerialName("page")
	PAGE,

	@SerialName("database")
	DATABASE
}