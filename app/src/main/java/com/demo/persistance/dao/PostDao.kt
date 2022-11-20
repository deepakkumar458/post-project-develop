package com.demo.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demo.persistance.entities.ApiResponse

@Dao
interface PostDao {

    @Insert
    fun insertAllPost(post: List<ApiResponse>)


    @Query("delete from posts_data")
    fun deleteAllPosts()


    @Query("SELECT * FROM posts_data")
    fun getAllPosts(): List<ApiResponse>

}