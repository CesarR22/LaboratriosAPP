package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.MovieWithActor

@Dao
interface MovieDao {
    // TODO: create getAllMovies method
    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies():List<MovieModel>
    // TODO: create insertMovie method
    @Transaction
    @Insert
    suspend fun insertMovie(movie:MovieModel)
    // TODO: create getMovieWithActorsById method
    @Query("SELECT * FROM movie_table WHERE movieId = :movieId")
    suspend fun getMovieWithActorsById(movieId:Int):MovieWithActor?
}