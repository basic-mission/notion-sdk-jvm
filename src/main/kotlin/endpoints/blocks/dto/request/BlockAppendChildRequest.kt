package endpoints.blocks.dto.request

import endpoints.blocks.dto.response.*
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlockAppendChildRequest(
	val blockId: String,
	@Serializable
	val body: BlockListChildRequest
)

@Serializable
data class BlockListChildRequest(
	@Serializable
	val children: List<BlockListBodyRequest>
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
sealed class BlockListBodyRequest {
	@SerialName("object")
	abstract val objects: String

	@Serializable
	@SerialName("embed")
	data class Embed(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val embed: EmbedRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("bookmark")
	data class Bookmark(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val bookmark: BookmarkType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("image")
	data class Image(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val image: MediaRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("video")
	data class Video(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val video: MediaRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("pdf")
	data class Pdf(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val pdf: MediaRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("file")
	data class File(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val file: MediaRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("audio")
	data class Audio(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val audio: MediaRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("code")
	data class Code(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val code: CodeType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("equation")
	data class Equation(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val equation: EquationType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("table_of_contents")
	data class TableOfContents(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("table_of_contents")
		val tableOfContents: TableOfContentsType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("link_to_page")
	data class LinkToPage(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("link_to_page")
		val linkToPage: LinkToPageType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("table_row")
	data class TableRow(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("table_row")
		val tableRow: TableRowType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("heading_1")
	data class Heading1(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("heading_1")
		val heading1: HeadingRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("heading_2")
	data class Heading2(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("heading_2")
		val heading2: HeadingRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("heading_3")
	data class Heading3(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("heading_3")
		val heading3: HeadingRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("paragraph")
	data class Paragraph(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val paragraph: ParagraphRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("bulleted_list_item")
	data class BulletedListItem(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("bulleted_list_item")
		val bulletedListItem: BulletedListItemRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("numbered_list_item")
	data class NumberedListItem(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("numbered_list_item")
		val numberedListItem: NumberedListItemRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("quote")
	data class Quote(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val quote: QuoteRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("to_do")
	data class Todo(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("to_do")
		val toDo: ToDoRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("toggle")
	data class Toggle(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val toggle: ToggleRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("template")
	data class Template(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val template: TemplateRequestType,
	) : BlockListBodyRequest()


	@Serializable
	@SerialName("callout")
	data class Callout(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val callout: CalloutRequestType,
	) : BlockListBodyRequest()

	@Serializable
	@SerialName("synced_block")
	data class SyncedBlock(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		@SerialName("synced_block")
		val syncedBlock: SyncedBlockRequestType,
	) : BlockListBodyRequest()


	@Serializable
	@SerialName("table")
	data class Table(
		@SerialName("object")
		@EncodeDefault override val objects: String = "block",
		val table: TableRequestType,
	) : BlockListBodyRequest()
}

