package endpoints.databases.dto.response

import endpoints.common.Color
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class DatabasePropertyResponse {
	abstract val id: String

	abstract val type: DatabasePropertyType

	abstract val name: String

	@Serializable
	@SerialName("title")
	data class Title(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.TITLE,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("number")
	data class Number(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.NUMBER,
		override val name: String,

		val format: String
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("select")
	data class Select(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.SELECT,
		override val name: String,

		val options: List<SelectOptionsType>
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("multi_select")
	data class MultiSelect(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.MULTI_SELECT,
		override val name: String,

		@SerialName("multi_select")
		val multiSelect: MultiSelectOptionsType
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("date")
	data class Date(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.DATE,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("people")
	data class People(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.PEOPLE,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("files")
	data class Files(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.FILES,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("checkbox")
	data class Checkbox(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.CHECKBOX,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("url")
	data class Url(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.URL,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("email")
	data class Email(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.EMAIL,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("phone_number")
	data class PhoneNumber(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.PHONE_NUMBER,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("formula")
	data class Formula(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.FORMULA,
		override val name: String,

		val expression: String
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("relation")
	data class Relation(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.RELATION,
		override val name: String,

		@SerialName("database_id")
		val databaseId: String,

		@SerialName("synced_property_name")
		val syncedPropertyName: String?,

		@SerialName("synced_property_id")
		val syncedPropertyId: String?,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("rollup")
	data class Rollup(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.ROLLUP,
		override val name: String,

		@SerialName("relation_property_name")
		val relationPropertyName: String?,

		@SerialName("relation_property_id")
		val relationPropertyId: String?,

		@SerialName("rollup_property_name")
		val rollupPropertyName: String,

		@SerialName("rollup_property_id")
		val rollupPropertyId: String,

		val function: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("created_time")
	data class CreatedTime(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.CREATED_TIME,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("created_by")
	data class CreatedBy(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.CREATED_BY,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("last_edited_time")
	data class LastEditedTime(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.LAST_EDITED_TIME,
		override val name: String,
	) : DatabasePropertyResponse()

	@Serializable
	@SerialName("last_edited_by")
	data class LastEditedBy(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.LAST_EDITED_BY,
		override val name: String,
	) : DatabasePropertyResponse()
}

@Serializable
enum class DatabasePropertyType {
	@SerialName("title")
	TITLE,

	@SerialName("rich_text")
	RICH_TEXT,

	@SerialName("number")
	NUMBER,

	@SerialName("select")
	SELECT,

	@SerialName("multi_select")
	MULTI_SELECT,

	@SerialName("date")
	DATE,

	@SerialName("people")
	PEOPLE,

	@SerialName("files")
	FILES,

	@SerialName("checkbox")
	CHECKBOX,

	@SerialName("url")
	URL,

	@SerialName("email")
	EMAIL,

	@SerialName("phone_number")
	PHONE_NUMBER,

	@SerialName("formula")
	FORMULA,

	@SerialName("relation")
	RELATION,

	@SerialName("rollup")
	ROLLUP,

	@SerialName("created_time")
	CREATED_TIME,

	@SerialName("created_by")
	CREATED_BY,

	@SerialName("last_edited_time")
	LAST_EDITED_TIME,

	@SerialName("last_edited_by")
	LAST_EDITED_BY
}

@Serializable
data class SelectOptionsType(
	val name: String,
	val id: String,
	val color: Color
)

@Serializable
data class MultiSelectOptionsType(
	val options: List<SelectOptionsType>
)
