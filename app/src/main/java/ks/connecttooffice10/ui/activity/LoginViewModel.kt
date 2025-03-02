package ks.connecttooffice10.ui.activity

import android.net.Uri
import android.os.Build
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ks.connecttooffice10.BuildConfig
import ks.connecttooffice10.domain.LoginUseCase
import ks.connecttooffice10.ui.model.Message
import org.apache.commons.validator.routines.UrlValidator
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUseCase: LoginUseCase
) : ViewModel() {

    // Поля ввода
    private val _portal = mutableStateOf("")
    val portal: State<String> = _portal

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    // Ошибки
    private val _portalError = mutableStateOf<String?>(null)
    val portalError: State<String?> = _portalError

    private val _emailError = mutableStateOf<String?>(null)
    val emailError: State<String?> = _emailError

    private val _passwordError = mutableStateOf<String?>(null)
    val passwordError: State<String?> = _passwordError

    private val _message = mutableStateOf<Message?>(null)
    val message: State<Message?> = _message


    init {
        if (BuildConfig.DEBUG) {
            _portal.value = "https://testdocspaceportal.onlyoffice.com/"
            _email.value = "1one.test901@gmail.com"
            _password.value = "Testpass123"
        }
    }

    fun onPortalChanged(newPortal: String) {
        _portal.value = newPortal
        _portalError.value =
            if (isPortalValid(newPortal))
                null else "Некорректный адрес портала"
    }

    fun isPortalValid(newPortal: String): Boolean {
        val urlValidator = UrlValidator()

        val uri = Uri.parse(newPortal)

        return urlValidator.isValid(newPortal) && uri.host?.endsWith(".onlyoffice.com") == true
    }

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        _emailError.value = if (isValidEmail(newEmail)) null else "Некорректный e-mail"
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
        _passwordError.value =
            if (isValidPassword(newPassword)) null else "Пароль должен быть минимум 8 символов, содержать цифры и буквы"
    }

    fun onLoginClick() {
        if (_portalError.value == null && _emailError.value == null && _passwordError.value == null) {
            viewModelScope.launch {
                val result = loginUseCase.invoke(
                    _portal.value,
                    _email.value,
                    _password.value
                )
                val error: Throwable? = result.exceptionOrNull()
                if (error == null) {
                    navigateMain()
                } else {
                    _message.value = Message(error.message ?: "")  // fixme
                }
            }
        } else {
            _message.value = Message("Ytrjhttrnhyst lfyyst")
        }
    }

    private fun navigateMain() {


    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        )
        return emailPattern.matcher(email).matches()
    }



    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8 && password.any { it.isDigit() } && password.any { it.isLetter() }
    }
}