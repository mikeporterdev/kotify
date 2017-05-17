package spotifykotlin

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import spotifykotlin.models.Artist
import spotifykotlin.models.SearchResult


fun main(args: Array<String>) {
    val x = SpotifyImpl()
    val search = x.search("test")
    println(search.albums)
    println(search.artists)

    val artists = x.getArtist(search.artists.items.get(0).id)
}

class SpotifyImpl {
    val BASE_URL = "https://api.spotify.com/v1"
    val mapper = jacksonObjectMapper()



    fun search(criteria: String, type: String = "album,track,playlist,artist"): SearchResult {
        val payload = mapOf(Pair("q", criteria), Pair("type", type))

        val response = khttp.get(BASE_URL + "/search", params = payload)

        return mapper.readValue<SearchResult>(response.text)
    }

    fun getArtist(id: String) : Artist {
        val response = khttp.get(BASE_URL + "/artists/" + id)

        return mapper.readValue<Artist>(response.text)
    }
}

