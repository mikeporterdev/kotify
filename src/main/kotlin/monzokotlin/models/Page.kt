package monzokotlin.models

/**
 * Created by m_por on 16/05/2017.
 */

data class Page<T> ( //TODO Make iterable
        val href: String,
        val items: List<T>,
        val limit: Int,
        val next: String? = null,
        val offset: Int,
        val previous: String? = null,
        val total: Int
)