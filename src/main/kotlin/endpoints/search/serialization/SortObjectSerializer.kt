package endpoints.search.serialization

import common.SortObject
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object SortObjectSerializer : JsonContentPolymorphicSerializer<SortObject>(SortObject::class) {
	override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out SortObject> = when {
		"property" in element.jsonObject -> SortObject.PropertyValueSort.serializer()
		"timestamp" in element.jsonObject -> SortObject.EntryTimestampSort.serializer()
		else -> throw Error("[SortObjectSerializer]")
	}
}
