<div align="center">
	<h1>Notion SDK for JVM</h1>
	<p>
		<b>A simple and easy to use client for the <a href="https://developers.notion.com">Notion API</a></b><br/>
        <b>This is an unofficially project</b>
	</p>
	<br>

[![test](https://github.com/basic-mission/notion-sdk-jvm/actions/workflows/test.yml/badge.svg)](https://github.com/basic-mission/notion-sdk-jvm/actions/workflows/test.yml)
[![release](https://github.com/basic-mission/notion-sdk-jvm/actions/workflows/release.yml/badge.svg)](https://github.com/basic-mission/notion-sdk-jvm/actions/workflows/release.yml)
[![](https://jitpack.io/v/basic-mission/notion-sdk-jvm.svg)](https://jitpack.io/#basic-mission/notion-sdk-jvm)
</div>

## Dependency

1. Add it in your root build.gradle at the end of repositories

```kotlin
allprojects {
	repositories {
		...
		maven {
			setUrl("https://jitpack.io")
		}
	}
}
```

2. Add the dependency

```kotlin
dependencies {
	implementation("com.github.basic-mission:notion-sdk-jvm:${notion_sdk_jvm_version}")
}
```

## Usage

> Use Notion's [Getting Started Guide](https://developers.notion.com/docs/getting-started) to get
> set up to use Notion's API.

```kotlin
val notion: Client = Client("$notionApiKey")
```

Make a request to any Notion API endpoint.

> See the complete list of endpoints in the [API reference](https://developers.notion.com/reference)
> .

```kotlin
val listUserResponse: UserListResponse? = notion.users.list()
```

## Requirements

This package supports the following minimum versions:

- Runtime: `jdk >= 11`

## Getting help

If you found a bug with the library,
please [submit an issue](https://github.com/basic-mission/notion-sdk-jvm/issues).