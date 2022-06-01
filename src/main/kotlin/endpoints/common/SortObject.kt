package endpoints.common

import endpoints.search.serialization.SortObjectSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = SortObjectSerializer::class)
sealed class SortObject {
	abstract val direction: DirectionType

	@Serializable
	@SerialName("property_value")
	data class PropertyValueSort(
		val property: String,
		override val direction: DirectionType
	) : SortObject()

	@Serializable
	@SerialName("entry_timestamp")
	data class EntryTimestampSort(
		override val direction: DirectionType,
		val timestamp: TimestampType
	) : SortObject()

}

@Serializable
enum class DirectionType {
	@SerialName("ascending")
	ASCENDING,

	@SerialName("descending")
	DESCENDING
}

@Serializable
enum class TimestampType {
	@SerialName("created_time")
	CREATED_TIME,

	@SerialName("last_edited_time")
	LAST_EDITED_TIME
}
