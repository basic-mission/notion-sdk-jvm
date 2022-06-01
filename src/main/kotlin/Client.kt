import endpoints.blocks.Blocks
import endpoints.databases.Databases
import endpoints.pages.Pages
import endpoints.users.Users
import http.getKtorClient
import io.ktor.client.*


open class Client(
	notionApiKey: String,
) {
	private val ktorClient: HttpClient = getKtorClient(notionApiKey)

	open val blocks: Blocks = Blocks(ktorClient)
	open val databases: Databases = Databases(ktorClient)
	open val pages: Pages = Pages(ktorClient)
	open val users: Users = Users(ktorClient)
}
