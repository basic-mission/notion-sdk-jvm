package endpoints.blocks

import Config
import endpoints.blocks.dto.request.BlockRetrieveRequest
import endpoints.blocks.dto.response.BlockResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BlocksTest {
	private val blocks: Blocks = Blocks(getKtorClient((Config.notionApiKey)))

	@Test
	@DisplayName("[Blocks] Retrieve paragraph block")
	fun getParagraphBlock() {
		val result = runBlocking {
			blocks.retrieve(BlockRetrieveRequest(Config.Block.ParagraphId))
		}
		result shouldNotBe null
		result is BlockResponse
	}

	@Test
	@DisplayName("[Blocks] Retrieve todo block")
	fun getTodoBlock() {
		val result = runBlocking {
			blocks.retrieve(BlockRetrieveRequest(Config.Block.TodoId))
		}
		result shouldNotBe null
		result is BlockResponse
	}

	@Test
	@DisplayName("[Blocks] Retrieve code block")
	fun getCodeBlock() {
		val result = runBlocking {
			blocks.retrieve(BlockRetrieveRequest(Config.Block.CodeId))
		}
		result shouldNotBe null
		result is BlockResponse
	}

	@Test
	@DisplayName("[Blocks] Retrieve quote block")
	fun getQuoteBlock() {
		val result = runBlocking {
			blocks.retrieve(BlockRetrieveRequest(Config.Block.QuoteId))
		}
		result shouldNotBe null
		result is BlockResponse
	}

}