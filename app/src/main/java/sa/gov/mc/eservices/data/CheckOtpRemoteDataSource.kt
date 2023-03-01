package sa.gov.mc.eservices.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import sa.gov.mc.eservices.data.model.CheckOTP
import sa.gov.mc.eservices.data.model.OtpResponse
import sa.gov.mc.eservices.network.AccountService

import javax.inject.Inject

class CheckOtpRemoteDataSource  @Inject constructor(private val api: AccountService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun checkOtp(checkOTP: CheckOTP):OtpResponse{

        return api.checkOtp(checkOTP)
    }

}