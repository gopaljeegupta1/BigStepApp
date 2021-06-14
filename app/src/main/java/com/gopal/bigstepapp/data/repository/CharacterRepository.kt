package com.gopal.bigstepapp.data.repository

import com.gopal.bigstepapp.data.entities.Results
import com.gopal.bigstepapp.data.local.DbDao
import com.gopal.bigstepapp.data.remote.RemoteDataSource
import com.gopal.bigstepapp.utils.performGetOperation
import com.gopal.bigstepapp.utils.performGetOperationApi
import com.gopal.bigstepapp.utils.performGetOperationDb
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: DbDao
) {


    fun getListFrmApi() = performGetOperationApi(
        networkCall = { remoteDataSource.getListFrmApi() }

    )

    fun getListFrmLocal() = performGetOperationDb(
        databaseQuery = { localDataSource.getAllList() }
    )


    suspend fun saveListToLocal(result: Results) =
        localDataSource.insert(result)


}