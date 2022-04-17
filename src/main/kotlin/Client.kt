import org.slf4j.Logger

class Client(
	private val auth: String?,
	private val timeoutMs: Number?,
	private val baseUrl: String?,
	private val logger: Logger?,
	private val notionVersion: String?,
)
