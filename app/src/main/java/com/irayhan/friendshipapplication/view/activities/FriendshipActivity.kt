package com.irayhan.friendshipapplication.view.activities

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.irayhan.friendshipapplication.R
import com.irayhan.friendshipapplication.base.BaseActivity
import com.irayhan.friendshipapplication.databinding.ActivityFriendshipBinding

class FriendshipActivity : BaseActivity<ActivityFriendshipBinding>() {

    override val contentView: Int get() = R.layout.activity_friendship
    private lateinit var navController: NavController

    override fun init(savedInstanceState: Bundle?) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }
}