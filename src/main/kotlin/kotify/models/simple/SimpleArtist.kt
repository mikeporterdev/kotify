package kotify.models.simple

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotify.Api
import kotify.models.Artist

@JsonIgnoreProperties(ignoreUnknown = true)
data class SimpleArtist(
        val name: String,
        val popularity: Int,
        val id: String
) {
    fun getFull(): Artist {
        return Api.instance.getArtist(this)
    }
}