package com.mte.marvelapp.base

import com.mte.marvelapp.data.remote.service.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiRequest(
        apiRequest : suspend () -> T): NetworkResult<T>{
        return withContext(Dispatchers.IO){
            try{
                NetworkResult.Success(apiRequest.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        NetworkResult.Error(false,"Network Error!")
                    }
                    else -> NetworkResult.Error(true,throwable.localizedMessage)
                }
            }
        }
    }
}