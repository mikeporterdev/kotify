package monzokotlin.models

import monzokotlin.models.simple.SimpleAlbum
import monzokotlin.models.simple.SimpleArtist
import monzokotlin.models.simple.SimplePlaylist

data class SearchResult(
        val albums: Page<SimpleAlbum>,
        val artists: Page<SimpleArtist>,
        val tracks: Page<Track>,
        val playlists: Page<SimplePlaylist>
)