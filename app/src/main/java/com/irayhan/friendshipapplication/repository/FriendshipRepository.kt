package com.irayhan.friendshipapplication.repository

import com.irayhan.friendshipapplication.base.BaseRepository
import com.irayhan.friendshipapplication.networking.APIService
import okhttp3.MultipartBody
import okhttp3.RequestBody

class FriendshipRepository(private val api: APIService) : BaseRepository() {

    suspend fun getFriends(
        results: Int
    ) = safeApiCall {
        api.getFriends(results)
    }


}