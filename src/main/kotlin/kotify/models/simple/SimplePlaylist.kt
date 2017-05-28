package kotify.models.simple

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by m_por on 16/05/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class SimplePlaylist(val href: String)