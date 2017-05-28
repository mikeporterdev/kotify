package spotifykotlin

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import spotifykotlin.SearchType.*
import spotifykotlin.models.Artist
import spotifykotlin.models.SearchResult


class Api {
    val BASE_URL = "https://api.spotify.com/v1"
    val mapper = jacksonObjectMapper()



    fun search(criteria: String,
               type: List<SearchType> = listOf(ALBUM, TRACK, PLAYLIST, ARTIST
    )): SearchResult {
        val searchType =
                type.fold("") { a, b: SearchType -> a + b.type + "," }
                        .trimEnd(',')
        val payload = mapOf(
                Pair("q", criteria),
                Pair("type", searchType)
        )

        val response = khttp.get(BASE_URL + "/search", params = payload)

        return mapper.readValue<SearchResult>(response.text)
    }

    fun getArtist(id: String) : Artist {
        val response = khttp.get(BASE_URL + "/artists/" + id)

        return mapper.readValue<Artist>(response.text)
    }
}

enum class SearchType(val type: String) {
    ALBUM("album"),
    TRACK("track"),
    PLAYLIST("playlist"),
    ARTIST("artist")
}