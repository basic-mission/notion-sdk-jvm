package http

import Config
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun getKtorClient(notionApiKey: String): HttpClient {
	return HttpClient {
		defaultRequest {
			url("https://api.notion.com/")
			headers {
				header("Accept", "application/json")
				header("Notion-Version", Config.notionVersion)
				header("Authorization", "Bearer $notionApiKey")
			}
		}
		install(Logging) {
			logger = Logger.DEFAULT
			level = LogLevel.HEADERS
		}
		install(ContentNegotiation) {
			json(Json {
				prettyPrint = true
				isLenient = true
				ignoreUnknownKeys = true
			})
		}
	}
}