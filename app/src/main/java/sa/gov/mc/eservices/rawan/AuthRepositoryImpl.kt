package sa.gov.mc.eservices.rawan

import kotlinx.coroutines.Dispatchers
import sa.gov.mc.eservices.data.model.Login
import sa.gov.mc.eservices.data.model.LoginResponse
import sa.gov.mc.eservices.rawan.utils.ResultWrapper
import sa.gov.mc.eservices.rawan.utils.safeApiCall
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val webService: AuthApiService,
) : AuthRepository {

    override suspend fun signIn(loginRequest: Login): ResultWrapper<LoginResponse> {
        return safeApiCall(Dispatchers.IO) {
            webService.login(loginRequest)
        }
    }

//    override suspend fun signUp(req: RegistrationRq): ResultWrapper<RegistrationRs> {
//        return safeApiCall(Dispatchers.IO) {
//            webService.register(req)
//        }
//    }
}