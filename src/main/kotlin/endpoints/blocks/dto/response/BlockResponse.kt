package endpoints.blocks.dto.response

import endpoints.common.Color
import endpoints.common.FileResponse
import endpoints.common.IconObject
import endpoints.common.RichTextObject
import endpoints.users.dto.response.PartialUserResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class BlockResponse {
	@SerialName("object")
	val objects: String = "block"

	abstract val id: String

	@SerialName("created_time")
	abstract val createdTime: String

	@SerialName("created_by")
	abstract val createdBy: PartialUserResponse

	@SerialName("last_edited_time")
	abstract val lastEditedTime: String

	@SerialName("last_edited_by")
	abstract val lastEditedBy: PartialUserResponse

	abstract val archived: Boolean

	@SerialName("has_children")
	abstract val hasChildren: Boolean

	abstract val type: String

	@Serializable
	@SerialName("paragraph")
	data class Paragraph(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "paragraph",

		val paragraph: ParagraphType
	) : BlockResponse()

	@Serializable
	@SerialName("heading_1")
	data class Heading_1(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "heading_1",

		@SerialName("heading_1") val heading1: HeadingType
	) : BlockResponse()

	@Serializable
	@SerialName("heading_2")
	data class Heading_2(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "heading_2",

		@SerialName("heading_2") val heading2: HeadingType
	) : BlockResponse()

	@Serializable
	@SerialName("heading_3")
	data class Heading_3(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "heading_3",

		@SerialName("heading_3") val heading3: HeadingType
	) : BlockResponse()

	@Serializable
	@SerialName("callout")
	data class Callout(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "callout",

		val callout: CalloutType
	) : BlockResponse()

	@Serializable
	@SerialName("quote")
	data class Quote(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "quote",

		val quote: QuoteType
	) : BlockResponse()

	@Serializable
	@SerialName("bulleted_list_item")
	data class BulletedListItem(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "bulleted_list_item",

		@SerialName("bulleted_list_item") val bulletedListItem: BulletedListItemType
	) : BlockResponse()

	@Serializable
	@SerialName("numbered_list_item")
	data class NumberedListItem(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "numbered_list_item",

		val numberedListItem: NumberedListItemType
	) : BlockResponse()

	@Serializable
	@SerialName("to_do")
	data class ToDo(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "to_do",

		@SerialName("to_do") val toDO: ToDoType
	) : BlockResponse()

	@Serializable
	@SerialName("toggle")
	data class Toggle(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "toggle",

		val toggle: ToggleType
	) : BlockResponse()

	@Serializable
	@SerialName("code")
	data class Code(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "code",

		val code: CodeType
	) : BlockResponse()


	@Serializable
	@SerialName("child_page")
	data class ChildPage(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "child_page",

		val chilePage: ChildPageType
	) : BlockResponse()

	@Serializable
	@SerialName("child_database")
	data class ChildDatabase(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "child_database",

		@SerialName("child_database")
		val childDatabase: ChildDatabaseType
	) : BlockResponse()

	@Serializable
	@SerialName("embed")
	data class Embed(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "embed",

		val embed: EmbedType
	) : BlockResponse()

	@Serializable
	@SerialName("image")
	data class Image(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "image",

		val image: ImageType
	) : BlockResponse()

	@Serializable
	@SerialName("video")
	data class Video(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "video",

		val video: VideoType
	) : BlockResponse()

	@Serializable
	@SerialName("file")
	data class File(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "file",

		val file: FileType
	) : BlockResponse()

	@Serializable
	@SerialName("pdf")
	data class Pdf(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "pdf",

		val pdf: PdfType
	) : BlockResponse()

	@Serializable
	@SerialName("bookmark")
	data class Bookmark(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "bookmark",

		val bookmark: BookmarkType
	) : BlockResponse()

	@Serializable
	@SerialName("equation")
	data class Equation(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "equation",

		val equation: EquationType
	) : BlockResponse()

	@Serializable
	@SerialName("divider")
	data class Divider(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "divider",

		val divider: DividerType
	) : BlockResponse()

	@Serializable
	@SerialName("table_of_contents")
	data class TableOfContents(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "table_of_contents",

		@SerialName("table_of_contents")
		val TableOfContents: TableOfContentsType
	) : BlockResponse()

	@Serializable
	@SerialName("breadcrumb")
	data class Breadcrumb(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "breadcrumb",

		val breadcrumb: BreadcrumbType
	) : BlockResponse()

	@Serializable
	@SerialName("column_list")
	data class ColumnList(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "column_list",

		@SerialName("column_list")
		val ColumnList: ColumnListType
	) : BlockResponse()

	@Serializable
	@SerialName("column")
	data class Column(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "column",

		val column: ColumnType
	) : BlockResponse()

	@Serializable
	@SerialName("link_preview")
	data class LinkPreview(
		override val id: String,
		@SerialName("created_time")
		override val createdTime: String,
		@SerialName("created_by")
		override val createdBy: PartialUserResponse,
		@SerialName("last_edited_time")
		override val lastEditedTime: String,
		@SerialName("last_edited_by")
		override val lastEditedBy: PartialUserResponse,
		@SerialName("has_children")
		override val hasChildren: Boolean,
		override val archived: Boolean,
		override val type: String = "link_preview",

		@SerialName("link_preview")
		val LinkPreview: LinkPreviewType
	) : BlockResponse()

	@Serializable
	@SerialName("template")
	data class Template(
		val type: String = "template",
		val template: TemplateType
	)

	@Serializable
	@SerialName("link_to_page")
	data class LinkToPage(
		val type: String = "link_to_page",

		@SerialName("link_to_page")
		val LinkToPage: LinkToPageType
	)

	@Serializable
	sealed class SyncedBlock {
		abstract val type: String

		@Serializable
		data class Original(
			override val type: String = "synced_block",

			@SerialName("synced_block")
			val syncedBlock: SyncedOriginalType
		) : SyncedBlock()

		@Serializable
		data class Reference(
			override val type: String = "synced_block",

			@SerialName("synced_block")
			val syncedBlock: SyncedReferenceType,
		) : SyncedBlock()
	}

	@Serializable
	@SerialName("table")
	data class Table(
		val type: String = "table",
		val table: TableType
	)

	@Serializable
	@SerialName("table_row")
	data class TableRow(
		val type: String = "table_row",

		@SerialName("table_row")
		val tableRow: TableRowType
	)
}

@Serializable
data class ParagraphType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class HeadingType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val color: Color? = Color.DEFAULT
)

@Serializable
data class CalloutType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val icon: IconObject,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class QuoteType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class BulletedListItemType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class NumberedListItemType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class ToDoType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val checked: Boolean = false,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class ToggleType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val color: Color = Color.DEFAULT,
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class CodeType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>?,
	val caption: List<RichTextObject>?,
	val language: String?
)

@Serializable
data class ChildPageType(
	val title: String
)

@Serializable
data class ChildDatabaseType(
	val title: String
)

@Serializable
data class EmbedType(
	val url: String
)

@Serializable
data class ImageType(
	val image: FileResponse
)

@Serializable
data class VideoType(
	val image: FileResponse
)

@Serializable
data class FileType(
	val file: FileResponse,
	val caption: List<RichTextObject>
)

@Serializable
data class PdfType(
	val pdf: FileResponse
)

@Serializable
data class BookmarkType(
	val url: String?,
	val caption: List<RichTextObject>?
)

@Serializable
data class EquationType(
	val expression: String?
)

@Serializable
class DividerType

@Serializable
data class TableOfContentsType(
	val color: Color? = Color.DEFAULT
)

@Serializable
class BreadcrumbType

@Serializable
data class ColumnListType(
	val children: List<ColumnType>
)

@Serializable
data class ColumnType(
	val children: List<BlockResponse>
)

@Serializable
data class LinkPreviewType(
	val url: String
)

@Serializable
data class TemplateType(
	@SerialName("rich_text")
	val richText: List<RichTextObject>,
	val children: List<BlockResponse>
)

@Serializable
sealed class LinkToPageType {
	abstract val type: String?

	@SerialName("page_id")
	data class PageId(
		override val type: String? = "page_id",

		@SerialName("page_id")
		val pageId: String
	) : LinkToPageType()

	@SerialName("database_id")
	data class DatabaseId(
		override val type: String? = "database_id",

		@SerialName("database_id")
		val databaseId: String
	) : LinkToPageType()
}

@Serializable
data class SyncedOriginalType(
	val children: List<BlockResponse>? = ArrayList<BlockResponse>()
)

@Serializable
data class SyncedReferenceType(
	@SerialName("synced_from")
	val syncedFrom: SyncedFromObject
)

@Serializable
data class SyncedFromObject(
	@SerialName("block_id")
	val blockId: String
)

@Serializable
data class TableType(
	@SerialName("table_width")
	val tableWidth: Int,

	@SerialName("has_column_header")
	val hasColumnHeader: Boolean,

	@SerialName("has_row_header")
	val hasRowHeader: Boolean,

	val children: List<TableRowType>? = ArrayList<TableRowType>()
)

@Serializable
data class TableRowType(
	val cells: List<RichTextObject>?
)