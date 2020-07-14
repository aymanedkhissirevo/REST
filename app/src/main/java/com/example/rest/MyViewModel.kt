package com.example.rest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rest.Objects.UserWrapper
import com.revotrends.eliteswap.data.local.EmailPassword
import retrofit2.Response

 class MyViewModel  : ViewModel() {

    val repository: Repository=Repository()

    fun login (emailPassword: EmailPassword):LiveData<Response<UserWrapper>?>{
        return repository.login(emailPassword)
    }
}