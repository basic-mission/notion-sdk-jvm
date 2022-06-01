package common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Annotations(
	val bold: Boolean = false,
	val italic: Boolean = false,
	val strikethrough: Boolean = false,
	val underline: Boolean = false,
	val code: Boolean = false,
	val color: Color = Color.DEFAULT,
)

@Serializable
enum class Color {
	@SerialName("default")
	DEFAULT,

	@SerialName("gray")
	GRAY,

	@SerialName("brown")
	BROWN,

	@SerialName("orange")
	ORANGE,

	@SerialName("yellow")
	YELLOW,

	@SerialName("green")
	GREEN,

	@SerialName("blue")
	BLUE,

	@SerialName("purple")
	PURPLE,

	@SerialName("pink")
	PINK,

	@SerialName("red")
	RED,

	@SerialName("gray_background")
	GRAY_BACKGROUND,

	@SerialName("brown_background")
	BROWN_BACKGROUND,

	@SerialName("orange_background")
	ORANGE_BACKGROUND,

	@SerialName("yellow_background")
	YELLOW_BACKGROUND,

	@SerialName("green_background")
	GREEN_BACKGROUND,

	@SerialName("blue_background")
	BLUE_BACKGROUND,

	@SerialName("purple_background")
	PURPLE_BACKGROUND,

	@SerialName("pink_background")
	PINK_BACKGROUND,

	@SerialName("red_background")
	RED_BACKGROUND,
}















