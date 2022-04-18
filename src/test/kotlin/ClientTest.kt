import io.kotest.core.spec.style.AnnotationSpec

internal class ClientTest : AnnotationSpec() {
	private val client: Client = Client(Config.notionApiKey)
}