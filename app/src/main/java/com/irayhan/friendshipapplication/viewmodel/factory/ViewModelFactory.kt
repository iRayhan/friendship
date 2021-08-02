package com.irayhan.friendshipapplication.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irayhan.friendshipapplication.base.BaseRepository
import com.irayhan.friendshipapplication.repository.FriendshipRepository
import com.irayhan.friendshipapplication.viewmodel.network.FriendshipVM

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FriendshipVM::class.java) -> FriendshipVM(repository as FriendshipRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}