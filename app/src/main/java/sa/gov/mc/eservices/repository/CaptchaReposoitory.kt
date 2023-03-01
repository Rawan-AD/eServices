
package sa.gov.mc.eservices.repository


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.eservices.data.CaptchaRemoteDataSource

import sa.gov.mc.eservices.data.model.Captcha
import javax.inject.Inject


class CaptchaRepository @Inject constructor(
    private val captchaRemoteDataSource: CaptchaRemoteDataSource
) {

   lateinit var captcha: Captcha

   suspend fun captchaLogin(): Captcha {
        withContext(Dispatchers.IO) {
            try {
                captcha = captchaRemoteDataSource.getCaptcha()
                return@withContext captcha

            } catch (e: Exception) {

            }
        }
return captcha

    }
}






