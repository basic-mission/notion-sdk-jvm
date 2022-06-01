package endpoints.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class FileResponse {
	abstract val type: String

	@Serializable
	@SerialName("file")
	data class File(
		override val type: String = "file",

		val file: FileType,
	) : FileResponse()

	@Serializable
	@SerialName("external")
	data class External(
		override val type: String = "external",

		val external: ExternalType,
	) : FileResponse()
}

@Serializable
data class FileType(
	val url: String,
	@SerialName("expiry_time")
	val expiryTime: String,
)

@Serializable
data class ExternalType(
	val url: String
)