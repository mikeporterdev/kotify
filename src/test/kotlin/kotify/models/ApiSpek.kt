package kotify.models

import kotify.Api
import kotify.SearchType
import kotify.models.simple.SimpleArtist
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.*

object ApiSpek : Spek({
    describe("api") {
        val api = Api.instance

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
                val search: SimpleArtist? = api.search("test", listOf(SearchType.ARTIST)).artists?.items?.filter({ it.id == testId })?.get(0)
                assertNotNull(search)

                // !! is fine here because tests
                val artist = api.getArtist(search!!)
                assertNotNull(artist)

                assertEquals(testId, artist.id, "IDs don't match. Possibly flimsy test, consider removing.")
            }
        }

        on("getting full artist from simple") {
            val testId = "1YEGETLT2p8k97LIo3deHL"

            it("should match") {
                val search: SimpleArtist? = api.search("test", listOf(SearchType.ARTIST)).artists?.items?.filter({ it.id == testId })?.get(0)

                val fullArtist = search?.getFull()
                assertEquals(fullArtist!!.id, testId)
            }
        }
    }
})