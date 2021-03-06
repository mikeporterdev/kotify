package kotify.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotify.models.simple.SimpleArtist

/**
 * Created by m_por on 16/05/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class Track(
        val artists: List<SimpleArtist>
)