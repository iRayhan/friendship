package com.irayhan.friendshipapplication.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.irayhan.friendshipapplication.R
import com.irayhan.friendshipapplication.base.BaseFragment
import com.irayhan.friendshipapplication.databinding.FragmentHomeBinding
import com.irayhan.friendshipapplication.models.ModelFriend
import com.irayhan.friendshipapplication.models.ModelFriendship
import com.irayhan.friendshipapplication.networking.APIService
import com.irayhan.friendshipapplication.repository.FriendshipRepository
import com.irayhan.friendshipapplication.utils.DataState
import com.irayhan.friendshipapplication.view.adapters.FriendAdapter
import com.irayhan.friendshipapplication.viewmodel.network.FriendshipVM
import org.json.JSONException
import org.json.JSONObject

class HomeFragment : BaseFragment<FriendshipVM, FragmentHomeBinding, FriendshipRepository>() {
    override fun getViewModel() = FriendshipVM::class.java
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentHomeBinding.inflate(inflater, container, false)
    override fun getRepository() = FriendshipRepository(remoteDataSource.buildApi(APIService::class.java))

    override fun init(savedInstanceState: Bundle?) {

        // observe api response
        observeGetFriendsResponse()

        // get friends
        viewModel.getFriends(10)

    }

    private fun observeGetFriendsResponse() {
        viewModel.getFriendsResponse.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Success -> {

                    // dismiss
                    binding.progressCircular.isGone = true

                    // get data
                    val body = it.value.body()?.string()!!

                    try {
                        val jsonObject = JSONObject(body)
                        showFriendList(jsonObject)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                is DataState.Loading -> {
                    binding.progressCircular.isVisible = true
                }

                is DataState.Error -> {
                    if (it.isNetworkError) Toast.makeText(mContext, "No Network", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(mContext, "Error: $it", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showFriendList(jsonObject: JSONObject) {
        val friendship = Gson().fromJson(jsonObject.toString(), ModelFriendship::class.java)

        val adapterFriend = FriendAdapter(mContext, R.layout.row_friend, object : FriendAdapter.OnCardClickListener {
            override fun onClick(friend: ModelFriend) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(friend))
            }
        })

        binding.rvFriend.apply {
            setHasFixedSize(true)
            adapter = adapterFriend
        }

        friendship.friendList?.let { adapterFriend.addAll(it, true) }

    }

}