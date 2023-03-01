package sa.gov.mc.eservices.network


import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import sa.gov.mc.eservices.data.model.*

interface AccountService {
    @GET("account/create-captcha")
    suspend fun getCaptcha(): Captcha

    @POST("account/login")@Headers("Content-Type: application/json")
fun loginRequest(@Body login:Login) :Deferred<LoginResponse>



    @POST("account/check-otp")@Headers("device: application/json")
    fun checkOtp(@Body checkOTP: CheckOTP): OtpResponse}
//
//
//    @POST("account/check-otp")
//    suspend fun refreshToken(@Body token: RefreshToken): TokenResponse
//
//    @POST("account/resend-otp")
//    suspend fun resendOtp(@Body uuid: UUID): LoginResponse
