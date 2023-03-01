package sa.gov.mc.eservices.rawan

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import sa.gov.mc.eservices.R
import sa.gov.mc.eservices.data.model.Login
import sa.gov.mc.eservices.data.model.LoginResponse
import sa.gov.mc.eservices.rawan.utils.BaseViewModel
import sa.gov.mc.eservices.rawan.utils.ErrorMsg
import sa.gov.mc.eservices.rawan.utils.ResultWrapper
import sa.gov.mc.eservices.rawan.utils.UiText
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepositoryImpl
) : BaseViewModel() {

    fun signIn(userName: String, password: String, uuid: String, answer: String) {
        if (validInput(userName, password, uuid, answer)) {
            _isLoading.value = true
            val loginRequest = Login(userName, password, uuid, answer)

            viewModelScope.launch {
                when (val response: ResultWrapper<LoginResponse> = authRepository.signIn(loginRequest)) {
                    is ResultWrapper.Success -> response.value?.let { Log.e("success","sucess")
                        onGetResponse(it) }
                    else -> onResponseError(response)
                }

                _isLoading.value = false
            }
        }
    }

    private fun onGetResponse(response: LoginResponse) {
        Log.i("***** login response", response.toString())
        // set data to live data here
    }

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
}