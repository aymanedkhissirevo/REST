package com.example.rest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rest.Objects.UserWrapper
import com.example.rest.WebService.AppApi
import com.example.rest.WebService.ServiceBuilder
import com.revotrends.eliteswap.data.local.EmailPassword
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class Repository {
    val webService = ServiceBuilder.buildService(AppApi::class.java)


    fun login (emailPassword: EmailPassword): LiveData<Response<UserWrapper>?> {
        val data = MutableLiveData<Response<UserWrapper>?>()

        webService.login(emailPassword)
            .subscribeOn(Schedulers.io())
            .subscribe({ success ->
                data.postValue(success)

            }, { error ->
                data.postValue(null)
            })

        return data
    }



}