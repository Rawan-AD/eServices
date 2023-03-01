package sa.gov.mc.eservices.rawan

import sa.gov.mc.eservices.data.model.Login
import sa.gov.mc.eservices.data.model.LoginResponse
import sa.gov.mc.eservices.rawan.utils.ResultWrapper


interface AuthRepository {
    suspend fun signIn(loginRequest: Login): ResultWrapper<LoginResponse>
//    suspend fun signUp(req: RegistrationRq): ResultWrapper<RegistrationRs>
}