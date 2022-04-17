package http

import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

open class KtorClient {
	companion object {
		@Volatile
		private var instance: HttpClient? = null

		@JvmStatic
		fun getInstance(): HttpClient =
			instance ?: synchronized(this) {
				instance ?: HttpClient(Java).also {
					instance = it.config {
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
			}
	}
}
