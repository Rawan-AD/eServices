package sa.gov.mc.eservices.uiScreen


import android.annotation.SuppressLint
import android.util.Log


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import sa.gov.mc.eservices.R


import sa.gov.mc.eservices.data.model.*
import sa.gov.mc.eservices.rawan.AuthRepositoryImpl
import sa.gov.mc.eservices.rawan.utils.BaseViewModel
import sa.gov.mc.eservices.rawan.utils.ErrorMsg
import sa.gov.mc.eservices.rawan.utils.UiText
import sa.gov.mc.eservices.repository.CaptchaRepository
import sa.gov.mc.eservices.repository.CheckOtpRepository
import sa.gov.mc.eservices.repository.LoginRepository

import javax.inject.Inject


enum class AccountApiStatus { LOADING, ERROR, DONE }

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val captchaRepository: CaptchaRepository,
    private val loginRepository: LoginRepository,
    private val checkOtpRepository: CheckOtpRepository,
    private val authRepository: AuthRepositoryImpl
) : BaseViewModel() {
    private val _status = MutableLiveData<AccountApiStatus>()
    val uuid = MutableLiveData<String>()

    val captcha = MutableLiveData<String>()
    var loginResponse = MutableLiveData<LoginResponse>()
    var requestId = MutableLiveData<Long>()

    var uuidLoginResponse = MutableLiveData<String>()
    var result = MutableLiveData<Captcha>()
    fun getCaptchaInfo() {

        viewModelScope.launch {
//            _status.value = AccountApiStatus.LOADING

            try {

                result.value = captchaRepository.captchaLogin()
                captcha.value = result.value?.captcha
                uuid.value = result.value?.uuid

//                _status.value = AccountApiStatus.DONE


            } catch (e: Exception) {
                _status.value = AccountApiStatus.ERROR
                result.value = Captcha("", "")


            }


        }


    }


    fun signIn(userName: String, password: String, uuid: String, answer: String) {
        if (validInput(userName, password, uuid, answer)) {
            _isLoading.value = true
            val loginRequest = Login(userName, password, uuid, answer)

            viewModelScope.launch {
                when (val response: sa.gov.mc.eservices.rawan.utils.ResultWrapper<LoginResponse> = authRepository.signIn(loginRequest)) {
                    is sa.gov.mc.eservices.rawan.utils.ResultWrapper.Success -> response.value?.let { onGetResponse(it) }
                    else -> onResponseError(response)
                }

                _isLoading.value = false
            }
        }
    }
    private fun onGetResponse(response: LoginResponse) {
        Log.i("***** login response", response.toString())
        loginResponse.value?.requestId=response.requestId
        loginResponse.value?.uuid = response.uuid
        Log.i("login", "${ loginResponse.value?.requestId}")
        // set data to live data here
    }

//    @SuppressLint("SuspiciousIndentation")
//    fun login(userName: String, password: String, uuid: String, answer: String) {
//        viewModelScope.launch {
//
//            var login = Login(userName, password, uuid, answer)
//
//            when (val response: ResultWrapper<LoginResponse> = loginRepository.loginRepo(login)) {
//                is ResultWrapper.Success -> response.value?.let { onGetResponse(it) }
//                else -> "error in viewwModel"
//            }
//
//
//        }
//
//
//    }

    private fun validInput(
        userName: String,
        password: String,
        uuid: String,
        answer: String
    ): Boolean {
        val noEmptyField = userName.isNotBlank() && password.isNotBlank() &&
                uuid.isNotBlank() && answer.isNotBlank()

        if (!noEmptyField) {
            _errorMsg.value = ErrorMsg(text = UiText.StringResource(R.string.all_fields_required))
            return false
        }

        // add your validation here

        return true
    }




    fun checkOtp(requestId: String, otp: String, uuid: String) {

        val otpResponse = MutableLiveData<OtpResponse>()
        viewModelScope.launch {
            _status.value = AccountApiStatus.LOADING

            try {
//var otp=CheckOTP()
//                otpResponse.value= checkOtpRepository.checkOtp()

                _status.value = AccountApiStatus.DONE


            } catch (e: Exception) {
                _status.value = AccountApiStatus.ERROR
                otpResponse.value = OtpResponse("", "")


            }


        }

    }


//    private fun onGetResponse(rs: LoginResponse) {
//
//
//        loginResponse.postValue(rs)
//        requestId.postValue(rs.requestId)
//        Log.e("viewModel","$requestId")
//        uuidLoginResponse.postValue(rs.uuid)
//Log.e("viewModel2","${uuid.value}")
//
//    }

//    fun validUser(userName:String):Boolean{
//        if(userName!=null) {
//            return true
//        }
//            else {
//
//                return false
//            }
//        }
//
//    fun validPassword(password:String):Boolean{
//        if(password!=null) {
//            return true
//        }
//        else {
//
//            return false
//        }
//    }


}




