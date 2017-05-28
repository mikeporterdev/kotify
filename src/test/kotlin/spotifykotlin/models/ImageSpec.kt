package spotifykotlin.models

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertNotNull
import spotifykotlin.Api

object ImageSpec : Spek({
    describe("api") {
        val api = Api()

        on("search") {
            val search = api.search("test")

            it("should return pages") {
                assertNotNull(search.albums.items)
                assertNotNull(search.artists.items)
                assertNotNull(search.playlists.items)
                assertNotNull(search.tracks.items)
            }
        }
    }
})