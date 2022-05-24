package endpoints.blocks

import endpoints.blocks.dto.request.BlockAppendChildRequest
import endpoints.blocks.dto.request.BlockIdRequest
import endpoints.blocks.dto.request.BlockRetrieveChildRequest
import endpoints.blocks.dto.request.BlockUpdateRequest
import endpoints.blocks.dto.response.BlockListResponse
import endpoints.blocks.dto.response.BlockResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import mu.KotlinLogging

open class Blocks(
	private val ktorClient: HttpClient,
) {
	val logger = KotlinLogging.logger {}

	suspend fun retrieve(
		request: BlockIdRequest
	): BlockResponse? = try {
		ktorClient.get("v1/blocks/${request.blockId}").body<BlockResponse>()
	} catch (error: Exception) {
		logger.error { "[Blocks.retrieve] ${error.message}" }
		null
	}

	suspend fun update(
		request: BlockUpdateRequest
	): BlockResponse? = try {
		ktorClient.patch("v1/blocks/${request.blockId}") {
			contentType(ContentType.Application.Json)
			setBody(request.body)
		}.body<BlockResponse>()
	} catch (error: Exception) {
		logger.error { "[Blocks.update] ${error.message}" }
		null
	}

	suspend fun retrieveChildren(
		request: BlockRetrieveChildRequest
	): BlockListResponse? = try {
		ktorClient.get("v1/blocks/${request.blockId}/children}").body<BlockListResponse>()
	} catch (error: Exception) {
		logger.error { "[Blocks.retrieveChildren] ${error.message}" }
		null
	}

	suspend fun appendChildren(
		request: BlockAppendChildRequest
	): BlockListResponse? = try {
		ktorClient.patch("v1/blocks/${request.blockId}/children") {
			contentType(ContentType.Application.Json)
			setBody(request.body)
		}.body<BlockListResponse>()
	} catch (error: Exception) {
		logger.error { "[Blocks.retrieveChildren] ${error.message}" }
		null
	}


	suspend fun delete(
		request: BlockIdRequest
	): BlockResponse? = try {
		ktorClient.delete("v1/blocks/${request.blockId}").body<BlockResponse>()
	} catch (error: Exception) {
		logger.error { "[Blocks.delete] ${error.message}" }
		null
	}
}
