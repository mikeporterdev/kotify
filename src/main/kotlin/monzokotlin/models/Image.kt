package monzokotlin.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by m_por on 16/05/2017.
 */

data class Image (
        val width: Int,
        val height: Int,
        @JsonProperty("url")
        val imageUrl: String
)