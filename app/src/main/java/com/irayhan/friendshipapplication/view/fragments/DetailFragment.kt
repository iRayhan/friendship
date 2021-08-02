package com.irayhan.friendshipapplication.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.irayhan.friendshipapplication.base.BaseFragment
import com.irayhan.friendshipapplication.databinding.FragmentDetailBinding
import com.irayhan.friendshipapplication.models.ModelFriend
import com.irayhan.friendshipapplication.networking.APIService
import com.irayhan.friendshipapplication.repository.FriendshipRepository
import com.irayhan.friendshipapplication.viewmodel.network.FriendshipVM
import android.content.Intent
import android.net.Uri


class DetailFragment : BaseFragment<FriendshipVM, FragmentDetailBinding, FriendshipRepository>() {
    override fun getViewModel() = FriendshipVM::class.java
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentDetailBinding.inflate(inflater, container, false)
    override fun getRepository() = FriendshipRepository(remoteDataSource.buildApi(APIService::class.java))

    override fun init(savedInstanceState: Bundle?) {

        // get friend
        getFriend()

    }

    private fun getFriend() {
        arguments?.getSerializable("friend")?.let {
            val friend = it as ModelFriend
            showFriendDetail(friend)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showFriendDetail(friend: ModelFriend) {

        // image
        Glide.with(mContext).load(friend.picture?.large).into(binding.imgFriend)

        // name
        binding.txtName.text = "${friend.name?.title} ${friend.name?.first} ${friend.name?.last}"

        // street
        binding.txtStreet.text = "Street: ${friend.location?.street?.name}"

        // postcode
        binding.txtPostcode.text = "Postcode: ${friend.location?.postcode}"

        // city
        binding.txtCity.text = "City: ${friend.location?.city}"

        // state
        binding.txtState.text = "State: ${friend.location?.state}"

        // country
        binding.txtCountry.text = "Country: ${friend.location?.country}"

        // email
        binding.txtEmail.apply {
            text = "Email: ${friend.email}"
            setOnClickListener {
                friend.email.let { email ->
                    if (!email.isNullOrBlank()) sendEmail(email)
                }
            }
        }

        // cell
        binding.txtCell.text = "Cell: ${friend.cell}"
    }

    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        startActivity(intent)
    }
}