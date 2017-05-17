package spotifykotlin.models

import spotifykotlin.models.simple.SimpleAlbum
import spotifykotlin.models.simple.SimpleArtist
import spotifykotlin.models.simple.SimplePlaylist

data class SearchResult(
        val albums: Page<SimpleAlbum>,
        val artists: Page<SimpleArtist>,
        val tracks: Page<Track>,
        val playlists: Page<SimplePlaylist>
)