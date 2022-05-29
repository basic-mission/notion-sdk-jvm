package endpoints.blocks

import Config
import Config.Block.todoId
import endpoints.blocks.dto.request.*
import endpoints.blocks.dto.response.BlockListResponse
import endpoints.blocks.dto.response.BlockResponse
import endpoints.common.Link
import endpoints.common.RichTextObject
import endpoints.common.TextObject
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

class BlocksTest : AnnotationSpec() {
	private val blocks: Blocks = Blocks(getKtorClient((Config.notionApiKey)))


	@Test
	@DisplayName("[Blocks] Retrieve paragraph block")
	fun retrieveParagraphBlock() {
		val result = runBlocking {
			blocks.retrieve(
				BlockIdRequest(
					Config.Block.paragraphId
				)
			)
		}

		result shouldNotBe null
		result is BlockResponse
	}

	@Test
	@DisplayName("[Blocks] Update todo block")
	fun updateBlock() {
		val result = runBlocking {
			blocks.update(
				BlockUpdateRequest(
					blockId = todoId,
					body = BlockBodyRequest.Todo(
						toDo = ToDoRequestType(
							richText = listOf(
								RichTextObject.Text(
									text = TextObject("Lacinato kale.", null)
								)
							),
							checked = true
						)
					)
				)
			)
		}

		result shouldNotBe null
		result is BlockResponse
	}

	@Test
	@DisplayName("[Blocks] Retrieve children block")
	fun retrieveChildrenBlock() {
		val result = runBlocking {
			blocks.retrieveChildren(
				BlockRetrieveChildRequest(
					Config.Block.pageId
				)
			)
		}

		result shouldNotBe null
		result is BlockListResponse
	}

	@Test
	@DisplayName("[Blocks] Append children block")
	fun appendChildrenBlock() {
		val result = runBlocking {
			blocks.appendChildren(
				BlockAppendChildRequest(
					blockId = Config.Block.pageId,
					body = BlockListChildRequest(
						listOf(
							BlockListBodyRequest.Heading2(
								heading2 = HeadingRequestType(
									listOf(
										RichTextObject.Text(
											text = TextObject(
												content = "Lacinato kale",
												link = Link(
													url = "https://en.wikipedia.org/wiki/Lacinato_kale"
												)
											)
										)
									)
								)
							),
							BlockListBodyRequest.Paragraph(
								paragraph = ParagraphRequestType(
									listOf(
										RichTextObject.Text(
											text = TextObject(
												content = "Lacinato kale is a variety of kale with a long tradition in Italian cuisine, especially that of Tuscany.",
												link = Link(
													url = "https://en.wikipedia.org/wiki/Lacinato_kale"
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		}

		result shouldNotBe null
		result is BlockListResponse
	}

	@Test
	@DisplayName("[Blocks] Delete block")
	fun deleteBlock() {
		val result = runBlocking {
			blocks.delete(
				BlockIdRequest(
					Config.Block.codeId
				)
			)
		}

		result shouldNotBe null
		result is BlockResponse
	}
}
