package com.demo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import com.demo.R
import com.demo.databinding.ActivityMainBinding
import com.demo.persistance.entities.ApiResponse
import com.demo.ui.adapter.PostAdapter
import com.demo.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //variables that are required by the Activity
    private val TAG = "MainActivity"
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDetailsFrag : DetailsFragment
    private val mViewModel: MainViewModel by viewModels()
    private lateinit var mList : List<ApiResponse>
    private lateinit var mAdapter : PostAdapter
    val fragment = DetailsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        //Start fetching the post Details from the Api
        mViewModel.getPostData().observe(this) {

            Log.e(TAG, "onCreate :: Data Api List is :: ${it}")
            if (it != null) {
                mList = it
            }

            mAdapter = PostAdapter(this , mList)
            mBinding.postRv.adapter = mAdapter




            if(it == null || it.isEmpty()){
                Toast.makeText(this, "No data found at the given api endPoint...", Toast.LENGTH_SHORT)
                return@observe
            }
        }

    }


    //Function to load the given fragment into the activity
    fun loadFragment(bundle: Bundle) {
        mBinding.postRv.visibility = GONE
        fragment.arguments = bundle
        val transaction =  supportFragmentManager.beginTransaction()
        showFragmentDialog()
        transaction.replace(
            R.id.rootFragmentLayout,
            fragment,
        ).commitAllowingStateLoss()
    }


    //Closing the Details Fragment and showing the RecyclerView List
    fun closeDetailsFragment() {
        hideFragmentDialog()
        showRecyclerViewDialog()
    }


    //Function to hide the Loading Dialog
    private fun hideLoadingDialog() {
        mBinding.loadingCl.visibility = GONE
    }


    //Function to show the RecyclerView Dialog
    private fun showRecyclerViewDialog(){
        mBinding.postRv.visibility = VISIBLE
    }


    //Function to hide the RecyclerView Dialog
    private fun hideRecyclerViewDialog(){
        mBinding.postRv.visibility = GONE
    }


    //Function to show the Fragment Dialog
    private fun showFragmentDialog() {
        mBinding.rootFragmentLayout.visibility = VISIBLE
    }


    //Function to hide the Fragment Dialog
    private fun hideFragmentDialog() {
        mBinding.rootFragmentLayout.visibility = GONE
    }

    override fun onBackPressed() {
        if(fragment.isVisible){
            mBinding.rootFragmentLayout.visibility = GONE
            mBinding.postRv.visibility = VISIBLE
           return
        }
        super.onBackPressed()
    }
}


