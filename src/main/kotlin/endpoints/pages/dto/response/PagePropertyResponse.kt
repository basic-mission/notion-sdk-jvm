package endpoints.pages.dto.response

import common.ExternalType
import common.RichTextObject
import endpoints.databases.dto.response.PropertyType
import endpoints.databases.dto.response.SelectObject
import endpoints.databases.dto.response.SelectOptionsObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class PagePropertyResponse {

	abstract val id: String

	abstract val type: PropertyType

	@Serializable
	@SerialName("title")
	data class Title(
		override val id: String,
		override val type: PropertyType = PropertyType.TITLE,

		val title: List<RichTextObject.Text>
	) : PagePropertyResponse()

	@Serializable
	@SerialName("rich_text")
	data class RichText(
		override val id: String,
		override val type: PropertyType = PropertyType.RICH_TEXT,

		@SerialName("rich_text")
		val richText: List<RichTextObject>
	) : PagePropertyResponse()

	@Serializable
	@SerialName("number")
	data class Number(
		override val id: String,
		override val type: PropertyType = PropertyType.NUMBER,

		val number: Int
	) : PagePropertyResponse()

	@Serializable
	@SerialName("select")
	data class Select(
		override val id: String,
		override val type: PropertyType = PropertyType.SELECT,

		val select: SelectOptionsObject
	) : PagePropertyResponse()

	@Serializable
	@SerialName("multi_select")
	data class MultiSelect(
		override val id: String,
		override val type: PropertyType = PropertyType.MULTI_SELECT,

		@SerialName("multi_select")
		val multiSelect: SelectObject
	) : PagePropertyResponse()

	@Serializable
	@SerialName("date")
	data class Date(
		override val id: String,
		override val type: PropertyType = PropertyType.DATE,

		val date: DateType
	) : PagePropertyResponse()

	@Serializable
	@SerialName("formula")
	data class Formula(
		override val id: String,
		override val type: PropertyType = PropertyType.FORMULA,

		val formula: FormulaType
	) : PagePropertyResponse()

	@Serializable
	@SerialName("relation")
	data class Relation(
		override val id: String,
		override val type: PropertyType = PropertyType.RELATION,

		val relation: RelationType
	) : PagePropertyResponse()

	@Serializable
	@SerialName("Rollup")
	data class Rollup(
		override val id: String,
		override val type: PropertyType = PropertyType.ROLLUP,

		@SerialName("Rollup")
		val rollUp: RollUpType
	) : PagePropertyResponse()

	@Serializable
	@SerialName("people")
	data class People(
		override val id: String,
		override val type: PropertyType = PropertyType.PEOPLE,

		val people: List<PeopleType>
	) : PagePropertyResponse()

	@Serializable
	@SerialName("files")
	data class Files(
		override val id: String,
		override val type: PropertyType = PropertyType.FILES,

		val files: List<FileType>
	) : PagePropertyResponse()

	@Serializable
	@SerialName("checkbox")
	data class Checkbox(
		override val id: String,
		override val type: PropertyType = PropertyType.CHECKBOX,

		@SerialName("checkbox")
		val checkBox: Boolean
	) : PagePropertyResponse()

	@Serializable
	@SerialName("url")
	data class Url(
		override val id: String,
		override val type: PropertyType = PropertyType.URL,
		val url: String
	) : PagePropertyResponse()

	@Serializable
	@SerialName("email")
	data class Email(
		override val id: String,
		override val type: PropertyType = PropertyType.EMAIL,
		val email: String
	) : PagePropertyResponse()

	@Serializable
	@SerialName("phone_number")
	data class PhoneNumber(
		override val id: String,
		override val type: PropertyType = PropertyType.PHONE_NUMBER,
		@SerialName("phone_number")
		val phoneNumber: String,
	) : PagePropertyResponse()
}

@Serializable
data class DateType(
	val start: String,
	val end: String? = null,
	val timeZone: String? = null
)

@Serializable
sealed class FormulaType {
	abstract val type: String

	@Serializable
	@SerialName("string")
	data class FormulaString(
		override val type: String = "string",
		val string: String
	) : FormulaType()

	@Serializable
	@SerialName("number")
	data class FormulaNumber(
		override val type: String = "number",
		val number: Int
	) : FormulaType()

	@Serializable
	@SerialName("boolean")
	data class FormulaBoolean(
		override val type: String = "boolean",
		val boolean: Boolean
	) : FormulaType()

	@Serializable
	@SerialName("date")
	data class FormulaDate(
		override val type: String = "date",
		val date: DateType
	) : FormulaType()
}

@Serializable
data class RelationType(
	val id: String
)

@Serializable
sealed class RollUpType {
	abstract val type: String

	@Serializable
	@SerialName("string")
	data class RollUpString(
		override val type: String = "string",
		val string: String,
		val function: String
	) : FormulaType()

	@Serializable
	@SerialName("number")
	data class RollUpNumber(
		override val type: String = "number",
		val number: Int,
		val function: String
	) : FormulaType()

	@Serializable
	@SerialName("date")
	data class FormulaDate(
		override val type: String = "date",
		val date: DateType,
		val function: String
	) : FormulaType()
}

@Serializable
data class PeopleType(
	@SerialName("object")
	val objects: String = "user",
	val id: String
)

@Serializable
data class FileType(
	val type: String = "external",
	val name: String,
	val external: ExternalType
)