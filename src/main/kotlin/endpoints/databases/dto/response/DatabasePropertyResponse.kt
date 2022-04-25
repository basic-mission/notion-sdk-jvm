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

		val options: Array<SelectOptionsType>
	) : DatabasePropertyResponse() {
		override fun equals(other: Any?): Boolean {
			if (this === other) return true
			if (javaClass != other?.javaClass) return false

			other as Select

			if (id != other.id) return false
			if (type != other.type) return false
			if (name != other.name) return false
			if (!options.contentEquals(other.options)) return false

			return true
		}

		override fun hashCode(): Int {
			var result = id.hashCode()
			result = 31 * result + type.hashCode()
			result = 31 * result + name.hashCode()
			result = 31 * result + options.contentHashCode()
			return result
		}
	}

	@Serializable
	@SerialName("multi_select")
	data class MultiSelect(
		override val id: String,
		override val type: DatabasePropertyType = DatabasePropertyType.MULTI_SELECT,
		override val name: String,

		val options: Array<SelectOptionsType>
	) : DatabasePropertyResponse() {
		override fun equals(other: Any?): Boolean {
			if (this === other) return true
			if (javaClass != other?.javaClass) return false

			other as MultiSelect

			if (id != other.id) return false
			if (type != other.type) return false
			if (name != other.name) return false
			if (!options.contentEquals(other.options)) return false

			return true
		}

		override fun hashCode(): Int {
			var result = id.hashCode()
			result = 31 * result + type.hashCode()
			result = 31 * result + name.hashCode()
			result = 31 * result + options.contentHashCode()
			return result
		}
	}

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
		override val type: DatabasePropertyType = DatabasePropertyType.RELATION,
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