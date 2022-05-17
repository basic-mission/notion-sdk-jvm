package endpoints.blocks

import endpoints.blocks.dto.request.BlockRetrieveRequest
import endpoints.blocks.dto.response.BlockResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import mu.KotlinLogging

open class Blocks(
	private val ktorClient: HttpClient,
) {
	private val logger = KotlinLogging.logger {}

	suspend fun retrieve(
		request: BlockRetrieveRequest
	): BlockResponse? = try {
		ktorClient.get("v1/blocks/${request.blockId}").body<BlockResponse>()
	} catch (error: Exception) {
		logger.error { "[Blocks.retrieve] ${error.message}" }
		null
	}

	suspend fun update() {}

	suspend fun retrieveChildren() {}

	suspend fun appendChildren() {}

	suspend fun delete() {}
}
