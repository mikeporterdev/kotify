package monzokotlin.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by m_por on 16/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Artist(
        @JsonProperty("external_urls")
        val externalUrls: Map<String, String>,
        val name: String
)