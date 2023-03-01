package sa.gov.mc.eservices.rawan

import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST
import sa.gov.mc.eservices.data.model.Login
import sa.gov.mc.eservices.data.model.LoginResponse

interface AuthApiService {

    @POST(URLs.LOGIN_URL)
    fun login(@Body rq: Login): Deferred<LoginResponse>


//    @POST(URLs.FORGET_PASSWORD)
//    fun forgotPass(@Body rq: ForgetPasswordRq): Deferred<GenResponse>
//
//    @POST(URLs.CHANGE_PASSWORD)
//    fun changePass(
//        @Header("Authorization") token: String,
//        @Body rq: ChangePasswordRq
//    ): Deferred<GenResponse>


}
