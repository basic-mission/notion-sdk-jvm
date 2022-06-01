package endpoints.databases.serialization

import endpoints.databases.dto.request.DatabaseCreateProperties
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object DatabaseCreatePropertySerializer : JsonContentPolymorphicSerializer<DatabaseCreateProperties>(DatabaseCreateProperties::class) {
	override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out DatabaseCreateProperties> = when {
		"title" in element.jsonObject -> DatabaseCreateProperties.Title.serializer()
		"rich_text" in element.jsonObject -> DatabaseCreateProperties.Text.serializer()
		"number" in element.jsonObject -> DatabaseCreateProperties.Number.serializer()
		"select" in element.jsonObject -> DatabaseCreateProperties.Select.serializer()
		"multi_select" in element.jsonObject -> DatabaseCreateProperties.MultiSelect.serializer()
		"people" in element.jsonObject -> DatabaseCreateProperties.People.serializer()
		"files" in element.jsonObject -> DatabaseCreateProperties.Files.serializer()
		"checkbox" in element.jsonObject -> DatabaseCreateProperties.Checkbox.serializer()
		"url" in element.jsonObject -> DatabaseCreateProperties.Url.serializer()
		"email" in element.jsonObject -> DatabaseCreateProperties.Email.serializer()
		"phone_number" in element.jsonObject -> DatabaseCreateProperties.PhoneNumber.serializer()
		"formula" in element.jsonObject -> DatabaseCreateProperties.Formula.serializer()
		"relation" in element.jsonObject -> DatabaseCreateProperties.Relation.serializer()
		"rollup" in element.jsonObject -> DatabaseCreateProperties.Rollup.serializer()
		"created_time" in element.jsonObject -> DatabaseCreateProperties.CreatedTime.serializer()
		"created_by" in element.jsonObject -> DatabaseCreateProperties.CreatedBy.serializer()
		"last_edited_time" in element.jsonObject -> DatabaseCreateProperties.LastEditedTime.serializer()
		"last_edited_by" in element.jsonObject -> DatabaseCreateProperties.LastEditedBy.serializer()
		else -> throw Error("[DatabaseCreatePropertySerializer]")
	}
}