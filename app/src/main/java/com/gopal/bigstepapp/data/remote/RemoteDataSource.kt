package com.gopal.bigstepapp.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val characterService: RemoteService
) : BaseDataSource() {

    suspend fun getListFrmApi() = getResult { characterService.getListFrmApi() }
}