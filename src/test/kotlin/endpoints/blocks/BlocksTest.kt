package endpoints.blocks

import Config
import endpoints.blocks.dto.request.BlockIdRequest
import endpoints.blocks.dto.request.BlockListRequest
import endpoints.blocks.dto.response.BlockListResponse
import endpoints.blocks.dto.response.BlockResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BlocksTest {
	private val blocks: Blocks = Blocks(getKtorClient((Config.notionApiKey)))


	@Test
	@DisplayName("[Blocks] Retrieve paragraph block")
	fun getParagraphBlock() {
		val result = runBlocking {
			blocks.retrieve(BlockIdRequest(Config.Block.paragraphId))
		}
		result shouldNotBe null
		result is BlockResponse
	}

	@Test
	@DisplayName("[Bliocks] Retrieve children block")
	fun retrieveChildrenBlock() {
		val result = runBlocking {
			blocks.retrieveChildren(BlockListRequest(Config.Block.pageId))
		}
		result shouldNotBe null
		result is BlockListResponse
	}

	@Test
	@DisplayName("[Bliocks] Delete block")
	fun deleteBlock() {
		val result = runBlocking {
			blocks.delete(BlockIdRequest(Config.Block.codeId))
		}
		result shouldNotBe null
		result?.archived shouldBe true
	}
}
