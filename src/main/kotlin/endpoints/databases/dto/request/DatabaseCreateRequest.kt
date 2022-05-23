package endpoints.databases.dto.request

import endpoints.common.Color
import endpoints.common.Empty
import endpoints.common.EmptyObject
import endpoints.common.RichTextObject
import endpoints.databases.dto.response.Parent
import endpoints.databases.serialization.DatabaseCreatePropertySerializer
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DatabaseCreateRequest(
	val parent: Parent.Page,
	val title: List<RichTextObject>,
	val properties: Map<String, DatabaseCreateProperties>,
)


@Serializable(with = DatabaseCreatePropertySerializer::class)
sealed class DatabaseCreateProperties {

	@Serializable
	@SerialName("title")
	data class Title(
		@EncodeDefault val title: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("text")
	data class Text(
		@EncodeDefault @SerialName("rich_text") val richText: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("number")
	data class Number(
		val number: NumberObject,
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("select")
	data class Select(
		val select: SelectObject,
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("multi_select")
	data class MultiSelect(
		val type: String = "multi_select",
		@SerialName("multi_select") val multiSelect: SelectObject,
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("date")
	data class Date(
		@EncodeDefault val date: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("people")
	data class People(
		@EncodeDefault val people: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("files")
	data class Files(
		@EncodeDefault val files: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("checkbox")
	data class Checkbox(
		@EncodeDefault val checkbox: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("url")
	data class Url(
		@EncodeDefault val url: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("email")
	data class Email(
		@EncodeDefault val email: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("phone_number")
	data class PhoneNumber(
		@EncodeDefault @SerialName("phone_number") val phoneNumber: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("formula")
	data class Formula(
		val formula: FormulaObject
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("relation")
	data class Relation(
		val relation: RelationObject
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("rollup")
	data class Rollup(
		val rollup: RollupObject
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("created_time")
	data class CreatedTime(
		@EncodeDefault @SerialName("created_time") val createdTime: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("created_by")
	data class CreatedBy(
		@EncodeDefault @SerialName("created_by") val createdBy: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("last_edited_time")
	data class LastEditedTime(
		@EncodeDefault @SerialName("last_edited_time") val lastEditedTime: EmptyObject = Empty
	) : DatabaseCreateProperties()

	@Serializable
	@SerialName("last_edited_by")
	data class LastEditedBy(
		@EncodeDefault @SerialName("last_edited_by") val lastEditedBy: EmptyObject = Empty
	) : DatabaseCreateProperties()
}

@Serializable
data class NumberObject(
	val format: String,
)

@Serializable
data class SelectObject(
	val options: List<SelectOptionsObject>?
)

@Serializable
data class SelectOptionsObject(
	val name: String,
	val color: Color?
)

@Serializable
data class FormulaObject(
	val expression: String,
)

@Serializable
data class RelationObject(
	@SerialName("database_id") val databaseId: String,
)

@Serializable
data class RollupObject(
	@SerialName("relation_property_name") val relationPropertyName: String? = null,
	@SerialName("relation_property_id") val relationPropertyId: String? = null,
	@SerialName("rollup_property_name") val rollupPropertyName: String? = null,
	@SerialName("rollup_property_id") val rollupPropertyId: String? = null,
	val function: String,
)