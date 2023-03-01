
package sa.gov.mc.eservices.repository



import android.annotation.SuppressLint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.eservices.data.CheckOtpRemoteDataSource
import sa.gov.mc.eservices.data.model.CheckOTP
import sa.gov.mc.eservices.data.model.OtpResponse
import javax.inject.Inject


class CheckOtpRepository @Inject constructor(
    private val checkOtpRemoteDataSource: CheckOtpRemoteDataSource
) {

    lateinit var otp: OtpResponse


    suspend fun checkOtp(checkOTP: CheckOTP):OtpResponse{
        withContext(Dispatchers.IO) {
            try {
      otp= checkOtpRemoteDataSource.checkOtp(checkOTP)
                return@withContext otp

            } catch (e: Exception) {

            }
        }
return otp

    }
}




//class CheckOtpRepository @Inject constructor(
//    private val checkOtpRemoteDataSource: CheckOtpRemoteDataSource
//) {
//
//    lateinit var otp: OtpResponse
//
//
//    @SuppressLint("SuspiciousIndentation")
//    suspend fun checkOtp():OtpResponse {
//        withContext(Dispatchers.IO) {
//            try {
//            otp= checkOtpRemoteDataSource.checkOtp()
//                return@withContext otp
//
//            } catch (e: Exception) {
//
//            }
//        }
//        return otp
//
//    }
//}

