package org.superbiz.moviefun.albums

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
class AlbumsRepository(val entityManager: EntityManager) {

    @Transactional
    fun addAlbum(album: Album) {
        entityManager.persist(album)
    }

    fun find(id: Long): Album {
        return entityManager.find(Album::class.java, id)
    }

    fun getAlbums(): List<Album> {
        val cq = entityManager.criteriaBuilder.createQuery(Album::class.java)
        cq.select(cq.from(Album::class.java))
        return entityManager.createQuery(cq).resultList
    }

    @Transactional
    fun deleteAlbum(album: Album) {
        entityManager.remove(album)
    }

    @Transactional
    fun updateAlbum(album: Album) {
        entityManager.merge(album)
    }
}
