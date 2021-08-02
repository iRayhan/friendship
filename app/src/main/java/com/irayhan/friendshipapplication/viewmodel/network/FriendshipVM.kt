package com.irayhan.friendshipapplication.viewmodel.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irayhan.friendshipapplication.repository.FriendshipRepository
import com.irayhan.friendshipapplication.utils.DataState
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response

class FriendshipVM(private val repository: FriendshipRepository) : ViewModel() {

    private val _getFriendsResponse: MutableLiveData<DataState<Response<ResponseBody>>> = MutableLiveData()
    val getFriendsResponse: LiveData<DataState<Response<ResponseBody>>> get() = _getFriendsResponse

    fun getFriends(
        results: Int
    ) = viewModelScope.launch {
        _getFriendsResponse.value = DataState.Loading
        _getFriendsResponse.value = repository.getFriends(results)
    }

}