package endpoints.databases.dto.request

import common.Color
import common.Empty
import common.EmptyObject
import common.RichTextObject
import endpoints.databases.serialization.DatabaseUpdatePropertySerializer
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DatabaseUpdateRequest(
	val databaseId: String,
	val body: DatabaseUpdateBodyObject,
)

@Serializable
data class DatabaseUpdateBodyObject(
	val title: List<RichTextObject>,
	val properties: Map<String, DatabaseUpdateBodyProperty?>
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable(with = DatabaseUpdatePropertySerializer::class)
sealed class DatabaseUpdateBodyProperty {

	@Serializable
	@SerialName("name")
	data class Name(
		val name: String,
	) : DatabaseUpdateBodyProperty()


	@Serializable
	@SerialName("title")
	data class Title(
		@EncodeDefault val title: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("rich_text")
	data class Text(
		@EncodeDefault @SerialName("rich_text") val richText: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("number")
	data class Number(
		@EncodeDefault val number: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("select")
	data class Select(
		val select: UpdateSelectObject,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("multi_select")
	data class MultiSelect(
		@SerialName("multi_select") val multiSelect: UpdateSelectObject,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("date")
	data class Date(
		@EncodeDefault val date: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("people")
	data class People(
		@EncodeDefault val people: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("files")
	data class Files(
		@EncodeDefault val files: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("checkbox")
	data class Checkbox(
		@EncodeDefault val checkbox: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("url")
	data class Url(
		@EncodeDefault val url: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("email")
	data class Email(
		@EncodeDefault val email: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("phone_number")
	data class PhoneNumber(
		@EncodeDefault @SerialName("phone_number") val phoneNumber: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("formula")
	data class Formula(
		@EncodeDefault val formula: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("relation")
	data class Relation(
		@EncodeDefault val relation: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("rollup")
	data class Rollup(
		@EncodeDefault val rollup: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("created_time")
	data class CreatedTime(
		@EncodeDefault @SerialName("created_time") val createdTime: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("created_by")
	data class CreatedBy(
		@EncodeDefault @SerialName("created_by") val createdBy: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("last_edited_time")
	data class LastEditedTime(
		@EncodeDefault @SerialName("last_edited_time") val lastEditedTime: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()

	@Serializable
	@SerialName("last_edited_by")
	data class LastEditedBy(
		@EncodeDefault @SerialName("last_edited_by") val lastEditedBy: EmptyObject = Empty,
	) : DatabaseUpdateBodyProperty()
}

@Serializable
data class UpdateSelectObject(
	val options: List<UpdateSelectOptionsObject>,
)

@Serializable
data class UpdateSelectOptionsObject(
	val id: String? = null,
	val name: String? = null,
	val color: Color? = null,
)