package com.demo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.persistance.entities.ApiResponse
import com.demo.ui.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    //Live Data that will be used to post the results to the Activity UI
    private var postLiveData: MutableLiveData<List<ApiResponse>?> = MutableLiveData()


    //Function to fetch the Post from the repository and using the Livedata will be posted to the Activity
    private fun fetchAllPosts() {

        //Starting Coroutines Scope for fetching in Background thread
        viewModelScope.launch(Dispatchers.IO) {
            //fetching data from repo
            val postList = repo.getAllPosts()

            //Checking if the Result is empty or not
            if (postList.isNotEmpty()) {
                postLiveData.postValue(postList)
            } else {
                postLiveData.postValue(null)
            }
        }
    }


    //Function to expose the instance of LiveData to the Activity for consumption
    fun getPostData() : LiveData<List<ApiResponse>?> {
        //Starting to fetch the data from the Repo
        fetchAllPosts()

        //Returning the Instance of the Livedata
        return postLiveData
    }

}