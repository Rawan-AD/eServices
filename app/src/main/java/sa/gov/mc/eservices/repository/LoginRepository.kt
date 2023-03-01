package sa.gov.mc.eservices.repository



import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.HttpException
import sa.gov.mc.eservices.data.model.*

import sa.gov.mc.eservices.network.AccountService
import java.io.IOException


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(private val api: AccountService
) {
    suspend fun loginRepo( login: Login): ResultWrapper<LoginResponse> {
return safeApiCall(Dispatchers.IO){
    api.loginRequest(login)

}

        }




    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> Deferred<T>
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                ResultWrapper.Success(apiCall.invoke().await())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        ResultWrapper.GenericError(code,errorResponse)
                    }
                    is IOException -> ResultWrapper.NetworkError
                    else -> {
                        ResultWrapper.GenericError(null, null)
                    }
                }
            }
        }
    }

    fun convertErrorBody(throwable: HttpException): ErrorResponse? {
        return try {

            throwable.response()?.errorBody()?.let {
                val gson = Gson()
                val error: ErrorResponse = gson.fromJson(
                    it.string(),
                    ErrorResponse::class.java
                )
                error
            }

        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }


}










