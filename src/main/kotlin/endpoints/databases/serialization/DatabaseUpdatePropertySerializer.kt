package endpoints.databases.serialization

import endpoints.databases.dto.request.DatabaseUpdateBodyProperty
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object DatabaseUpdatePropertySerializer : JsonContentPolymorphicSerializer<DatabaseUpdateBodyProperty>(DatabaseUpdateBodyProperty::class) {
	override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out DatabaseUpdateBodyProperty> = when {
		"name" in element.jsonObject -> DatabaseUpdateBodyProperty.Name.serializer()
		"title" in element.jsonObject -> DatabaseUpdateBodyProperty.Title.serializer()
		"rich_text" in element.jsonObject -> DatabaseUpdateBodyProperty.Text.serializer()
		"number" in element.jsonObject -> DatabaseUpdateBodyProperty.Number.serializer()
		"select" in element.jsonObject -> DatabaseUpdateBodyProperty.Select.serializer()
		"multi_select" in element.jsonObject -> DatabaseUpdateBodyProperty.MultiSelect.serializer()
		"people" in element.jsonObject -> DatabaseUpdateBodyProperty.People.serializer()
		"files" in element.jsonObject -> DatabaseUpdateBodyProperty.Files.serializer()
		"checkbox" in element.jsonObject -> DatabaseUpdateBodyProperty.Checkbox.serializer()
		"url" in element.jsonObject -> DatabaseUpdateBodyProperty.Url.serializer()
		"email" in element.jsonObject -> DatabaseUpdateBodyProperty.Email.serializer()
		"phone_number" in element.jsonObject -> DatabaseUpdateBodyProperty.PhoneNumber.serializer()
		"formula" in element.jsonObject -> DatabaseUpdateBodyProperty.Formula.serializer()
		"relation" in element.jsonObject -> DatabaseUpdateBodyProperty.Relation.serializer()
		"rollup" in element.jsonObject -> DatabaseUpdateBodyProperty.Rollup.serializer()
		"created_time" in element.jsonObject -> DatabaseUpdateBodyProperty.CreatedTime.serializer()
		"created_by" in element.jsonObject -> DatabaseUpdateBodyProperty.CreatedBy.serializer()
		"last_edited_time" in element.jsonObject -> DatabaseUpdateBodyProperty.LastEditedTime.serializer()
		"last_edited_by" in element.jsonObject -> DatabaseUpdateBodyProperty.LastEditedBy.serializer()
		else -> throw Error("[DatabaseUpdateBodyPropertySerializer]")
	}
}