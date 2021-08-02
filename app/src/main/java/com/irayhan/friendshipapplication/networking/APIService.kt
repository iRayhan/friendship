package com.irayhan.friendshipapplication.networking

import com.irayhan.friendshipapplication.core.AppConstants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET(AppConstants.API_URL)
    suspend fun getFriends(
        @Query("results") results: Int
    ): Response<ResponseBody>

}