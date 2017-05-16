package monzokotlin.models.simple

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import monzokotlin.models.Image

@JsonIgnoreProperties(ignoreUnknown = true)
data class SimpleAlbum(
        val name: String,
        val href: String,
        val artists: List<SimpleArtist>,
        @JsonProperty("available_markets")
        val availableMarkets: List<String>,
        val id: String,
        val images: List<Image>,
        val popularity: Int
)