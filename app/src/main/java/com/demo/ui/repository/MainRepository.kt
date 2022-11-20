package com.demo.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.RoomDatabase
import com.demo.interfaces.DummyApiInterface
import com.demo.persistance.AppDatabase
import com.demo.persistance.entities.ApiResponse
import com.demo.utils.NetworkResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiInterface: DummyApiInterface,
    private val roomDb: AppDatabase
) {

    //Function to get all the Post from the REST API
    suspend fun getAllPosts() : List<ApiResponse> {
        //Fetching the data using the Retrofit
        val response = apiInterface.getAllEmployees()

        //Checking if the fetching is success or not
        if(response.code() == 200 && response.body() != null){
            //First removing all the data from the local db to avoid duplication of the Data
            roomDb.getPostDao().deleteAllPosts()

            //Saving all data into the Room Database
            roomDb.getPostDao().insertAllPost(response.body()!!)

            //fetching the data from local database and returning the list
            return roomDb.getPostDao().getAllPosts()
        }

        return listOf()
    }


}