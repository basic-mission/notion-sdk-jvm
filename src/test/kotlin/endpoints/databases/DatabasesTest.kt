package endpoints.databases

import Config
import endpoints.common.Color
import endpoints.common.RichTextObject
import endpoints.common.TextObject
import endpoints.databases.dto.request.*
import endpoints.databases.dto.response.DatabaseParent
import endpoints.databases.dto.response.DatabaseResponse
import http.getKtorClient
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

internal class DatabasesTest : AnnotationSpec() {
	private val databases: Databases = Databases(getKtorClient(Config.notionApiKey))

	@Test
	@DisplayName("[Databases] Create a database")
	fun createDatabase() {
		val result = runBlocking {
			databases.create(
				DatabaseCreateRequest(
					parent = DatabaseParent.Page(
						pageId = Config.Database.pageId
					),
					title = listOf(
						RichTextObject.Text(
							text = TextObject(
								content = "Grocery List",
								link = null
							),
						)
					),
					properties = mapOf(
						"Name" to DatabaseCreateProperties.Title(),
						"Description" to DatabaseCreateProperties.Text(),
						"In stock" to DatabaseCreateProperties.Checkbox(),
						"Food group" to DatabaseCreateProperties.Select(
							select = SelectObject(
								options = listOf(
									SelectOptionsObject(
										name = "Vegetable",
										color = Color.GREEN,
									),
									SelectOptionsObject(
										name = "Fruit",
										color = Color.RED,
									),
									SelectOptionsObject(
										name = "Protein",
										color = Color.YELLOW,
									)
								)
							)
						),
						"Price" to DatabaseCreateProperties.Number(
							number = NumberObject(
								format = "dollar",
							)
						),
						"Last ordered" to DatabaseCreateProperties.Date(),
						"Store availability" to DatabaseCreateProperties.MultiSelect(
							multiSelect = SelectObject(
								options = listOf(
									SelectOptionsObject(
										name = "Duc Loi Market",
										color = Color.BLUE,
									),
									SelectOptionsObject(
										name = "Rainbow Grocery",
										color = Color.GRAY,
									),
									SelectOptionsObject(
										name = "Nijiya Market",
										color = Color.PURPLE,
									),
									SelectOptionsObject(
										name = "Gus'\''s Community Market",
										color = Color.YELLOW,
									),
								)
							)
						),
						"+1" to DatabaseCreateProperties.People(),
						"Photo" to DatabaseCreateProperties.Files()
					)
				)
			)
		}

		result shouldNotBe null
		result is DatabaseResponse
	}

	@Test
	@DisplayName("[Databases] Update a database")
	fun updateDatabase() {
		val database = runBlocking {
			databases.create(
				DatabaseCreateRequest(
					parent = DatabaseParent.Page(
						pageId = Config.Database.pageId
					),
					title = listOf(
						RichTextObject.Text(
							text = TextObject(
								content = "Grocery List",
								link = null
							),
						)
					),
					properties = mapOf(
						"Name" to DatabaseCreateProperties.Title(),
						"Description" to DatabaseCreateProperties.Text(),
						"In stock" to DatabaseCreateProperties.Checkbox(),
						"Food group" to DatabaseCreateProperties.Select(
							select = SelectObject(
								options = listOf(
									SelectOptionsObject(
										name = "Vegetable",
										color = Color.GREEN,
									),
									SelectOptionsObject(
										name = "Fruit",
										color = Color.RED,
									),
									SelectOptionsObject(
										name = "Protein",
										color = Color.YELLOW,
									)
								)
							)
						),
						"Price" to DatabaseCreateProperties.Number(
							number = NumberObject(
								format = "dollar",
							)
						),
						"Last ordered" to DatabaseCreateProperties.Date(),
						"Store availability" to DatabaseCreateProperties.MultiSelect(
							multiSelect = SelectObject(
								options = listOf(
									SelectOptionsObject(
										name = "Duc Loi Market",
										color = Color.BLUE,
									),
									SelectOptionsObject(
										name = "Rainbow Grocery",
										color = Color.GRAY,
									),
									SelectOptionsObject(
										name = "Nijiya Market",
										color = Color.PURPLE,
									),
									SelectOptionsObject(
										name = "Gus'\''s Community Market",
										color = Color.YELLOW,
									),
								)
							)
						),
						"+1" to DatabaseCreateProperties.People(),
						"Photo" to DatabaseCreateProperties.Files()
					)
				)
			)
		}

		database shouldNotBe null
		database is DatabaseResponse

		val result = runBlocking {
			databases.update(
				DatabaseUpdateRequest(
					databaseId = database!!.id,
					body = DatabaseUpdateBodyObject(
						title = listOf(
							RichTextObject.Text(
								text = TextObject(
									content = "Today's grocery list"
								)
							)
						),
						properties = mapOf(
							"+1" to null,
							"Photo" to DatabaseUpdateBodyProperty.Url(),
							"Store availability" to DatabaseUpdateBodyProperty.MultiSelect(
								multiSelect = UpdateSelectObject(
									options = listOf(
										UpdateSelectOptionsObject(
											name = "Duc Loi Market"
										),
										UpdateSelectOptionsObject(
											name = "Rainbow Grocery"
										),
										UpdateSelectOptionsObject(
											name = "Gus's Community Market"
										),
										UpdateSelectOptionsObject(
											name = "The Good Life Grocery",
											color = Color.ORANGE,
										),
									)
								)
							)
						)
					)
				)
			)
		}

		result shouldNotBe null
		result is DatabaseResponse
	}

	@Test
	@DisplayName("[Databases] Retrieve a database")
	fun retrieveDatabase() {
		val result = runBlocking {
			databases.retrieve(DatabaseRetrieveRequest(Config.Database.databaseId))
		}

		result shouldNotBe null
		result is DatabaseResponse
	}
}
