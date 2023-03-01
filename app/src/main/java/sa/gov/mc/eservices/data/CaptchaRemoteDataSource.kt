package sa.gov.mc.eservices.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.eservices.data.model.Captcha
import sa.gov.mc.eservices.network.AccountService

import javax.inject.Inject

class CaptchaRemoteDataSource @Inject constructor(private val api: AccountService, private val dispatcher:CoroutineDispatcher=Dispatchers.IO) {
    suspend fun getCaptcha(): Captcha =
        withContext(dispatcher){
            api.getCaptcha()
        }
}