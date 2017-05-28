package kotify.models

import kotify.models.simple.SimpleAlbum
import kotify.models.simple.SimpleArtist
import kotify.models.simple.SimplePlaylist

data class SearchResult(
        // Maybe implements searchable?
        val albums: Page<SimpleAlbum>?,
        val artists: Page<SimpleArtist>?,
        val tracks: Page<Track>?,
        val playlists: Page<SimplePlaylist>?
)