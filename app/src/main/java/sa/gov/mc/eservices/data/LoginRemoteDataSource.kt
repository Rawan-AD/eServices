package sa.gov.mc.eservices.data


import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import sa.gov.mc.eservices.data.model.*


import sa.gov.mc.eservices.di.NetworkModel_ProvideCaptchaRemoteDataSourceFactory
import sa.gov.mc.eservices.di.NetworkModel_ProvideCaptchaRemoteDataSourceFactory.create
import sa.gov.mc.eservices.network.AccountService
import javax.inject.Inject


//class LoginRemoteDataSource @Inject constructor(private val api: AccountService, private val dispatcher:CoroutineDispatcher=Dispatchers.IO) {

//    suspend fun login(loginInfo: Login):ResultWrapper<LoginResponse> {
//        return withContext(dispatcher) {
//           api.loginRequest(loginInfo) }
//               }



//}











