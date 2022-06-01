package endpoints.blocks.dto.request

import endpoints.blocks.dto.response.*
import endpoints.common.Color
import endpoints.common.IconObject
import endpoints.common.RichTextObject
import endpoints.common.TextObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class BlockUpdateRequest(
	val blockId: String,
	@Serializable
	val body: BlockBodyRequest
)

@Serializable
sealed class BlockBodyRequest {

	@Serializable
	@SerialName("embed")
	data class Embed(
		val embed: EmbedRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("bookmark")
	data class Bookmark(
		val bookmark: BookmarkType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("image")
	data class Image(
		val image: MediaRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("video")
	data class Video(
		val video: MediaRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("pdf")
	data class Pdf(
		val pdf: MediaRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("file")
	data class File(
		val file: MediaRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("audio")
	data class Audio(
		val audio: MediaRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("code")
	data class Code(
		val code: CodeType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("equation")
	data class Equation(
		val equation: EquationType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("table_of_contents")
	data class TableOfCotents(
		@SerialName("table_of_contents")
		val tableOfContents: TableOfContentsType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("link_to_page")
	data class LinkToPage(
		@SerialName("link_to_page")
		val linkToPage: LinkToPageType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("table_row")
	data class TableRow(
		@SerialName("table_row")
		val tableRow: TableRowType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("heading_1")
	data class Heading1(
		@SerialName("heading_1")
		val heading1: HeadingRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("heading_2")
	data class Heading2(
		@SerialName("heading_2")
		val heading2: HeadingRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("heading_3")
	data class Heading3(
		@SerialName("heading_3")
		val heading3: HeadingRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("paragraph")
	data class Paragraph(
		val paragraph: ParagraphRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("bulleted_list_item")
	data class BulletedListItem(
		@SerialName("bulleted_list_item")
		val bulletedListItem: BulletedListItemRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("numbered_list_item")
	data class NumberedListItem(
		@SerialName("numbered_list_item")
		val numberedListItem: NumberedListItemRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("quote")
	data class Quote(
		val quote: QuoteRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("to_do")
	data class Todo(
		@SerialName("to_do")
		val toDo: ToDoRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("toggle")
	data class Toggle(
		val toggle: ToggleRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("template")
	data class Template(
		val template: TemplateRequestType,
	) : BlockBodyRequest()


	@Serializable
	@SerialName("callout")
	data class Callout(
		val callout: CalloutRequestType,
	) : BlockBodyRequest()

	@Serializable
	@SerialName("synced_block")
	data class SyncedBlock(
		@SerialName("synced_block")
		val syncedBlock: SyncedBlockRequestType,
	) : BlockBodyRequest()


	@Serializable
	@SerialName("table")
	data class Table(
		val table: TableRequestType,
	) : BlockBodyRequest()

}


@Serializable
data class EmbedRequestType(
	val url: String?,
	val caption: List<RichTextObject>?,
)

@Serializable
data class ToDoRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val checked: Boolean = false,
	val color: Color = Color.DEFAULT,
)

@Serializable
data class MediaRequestType(
	val caption: List<RichTextObject>?,
	val external: ExternalRequestType?,
)

@Serializable
class BreadcrumbType

@Serializable
class DividerType

@Serializable
data class HeadingRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?
)

@Serializable
data class ParagraphRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?,
	val color: Color? = Color.DEFAULT,
)

@Serializable
data class BulletedListItemRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?,
	val color: Color? = Color.DEFAULT,
)

@Serializable
data class NumberedListItemRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?,
	val color: Color? = Color.DEFAULT,
)

@Serializable
data class QuoteRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?,
	val color: Color? = Color.DEFAULT,
)

@Serializable
data class ToggleRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?,
	val color: Color? = Color.DEFAULT,
)

@Serializable
data class TemplateRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
)

@Serializable
data class CalloutRequestType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val icon: IconObject,
	val color: Color = Color.DEFAULT,
)

@Serializable
data class SyncedBlockRequestType(
	val blockId: String,
	val type: String? = "block_id"
)

@Serializable
data class TableRequestType(
	@SerialName("has_column_header")
	val hasColumnHeader: Boolean,
	@SerialName("has_row_header")
	val hasRowHeader: Boolean,
)

@Serializable
data class ExternalRequestType(
	val url: TextObject?
)
