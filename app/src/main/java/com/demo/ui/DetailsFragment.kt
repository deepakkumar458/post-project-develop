package com.demo.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.R
import com.demo.databinding.FragmentDetailsBinding
import com.demo.persistance.entities.ApiResponse


class DetailsFragment : Fragment() {

    //Variables that will be used in the Fragment
    private lateinit var postDetails : ApiResponse
    private lateinit var mFragBinding: FragmentDetailsBinding
    private lateinit var mActivity: MainActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as MainActivity
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Fetching the data from the Bundle
        arguments?.let {
            postDetails = it.getParcelable("postData")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mFragBinding = FragmentDetailsBinding.inflate(layoutInflater)
        return mFragBinding.root
    }


    override fun onStart() {
        super.onStart()

        //Setting Data into the UI
        mFragBinding.titleTv.text = postDetails.title
        mFragBinding.bodyTv.text = postDetails.body


        //onClickListener for thr Close Button
        mFragBinding.closeIv.setOnClickListener{
            mActivity.closeDetailsFragment()
        }
    }


    companion object {
        //Function to create an instance for this Fragment
        @JvmStatic
        fun newInstance(postData: ApiResponse) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("postData", postData)
                }
            }
    }
}