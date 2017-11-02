package org.superbiz.moviefun.albums

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Album (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var artist: String? = null,
    var title: String? = null,
    var year: Int = 0,
    var rating: Int = 0
) {
    fun hasId() = id != null

    fun isEquivalent(other: Album): Boolean {
        if (year != other.year) return false
        if (title != other.title) return false
        if (artist != other.artist) return false

        return true
    }
}
