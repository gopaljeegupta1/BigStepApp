package com.gopal.bigstepapp.data.remote

import com.gopal.bigstepapp.data.entities.ResultsList
import retrofit2.Response
import retrofit2.http.GET

interface RemoteService {

    @GET("search?term=Michael+jackson&media=musicVideo")
    suspend fun getListFrmApi(): Response<ResultsList>
}