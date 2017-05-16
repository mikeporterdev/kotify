package monzokotlin.models.simple

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SimpleArtist(
        val name: String,
        val popularity: Int,
        val id: String
)