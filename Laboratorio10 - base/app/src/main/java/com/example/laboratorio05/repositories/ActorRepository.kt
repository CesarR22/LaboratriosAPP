package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.model.ActorModel

class ActorRepository(private val actorDao: ActorDao) {
        // TODO: complete Actor ActorRepository
    suspend fun getAllActors() = actorDao.getAllActors()
    suspend fun addActors(actor: ActorModel)= actorDao.insertActor(actor)
}