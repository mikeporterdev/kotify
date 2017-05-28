package spotifykotlin.models

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.*
import spotifykotlin.Api
import spotifykotlin.SearchType

object ImageSpec : Spek({
    describe("api") {
        val api = Api()

        on("search") {
            val search = api.search("test")

            it("should return pages") {
                assertNotNull(search.albums?.items)
                assertNotNull(search.artists?.items)
                assertNotNull(search.playlists?.items)
                assertNotNull(search.tracks?.items)
            }
        }

        on("searching for artists") {
            val search = api.search("test", listOf(SearchType.ARTIST))

            it("should only return artist pages") {
                assertNotNull(search.artists)
                assertNull(search.albums)
                assertNull(search.playlists)
                assertNull(search.tracks)
            }
        }

        on("getting an artist by simple artist") {
            val testId = "1YEGETLT2p8k97LIo3deHL"

            it("should return artist") {
                val artist = api.getArtist(testId)
                assertNotNull(artist)
            }
        }
    }
})