package ks.connecttooffice10.ui.activity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

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

    fun onPortalChanged(newPortal: String) {
        _portal.value = newPortal
        _portalError.value =
            if (newPortal.startsWith("https://") && newPortal.endsWith(".onlyoffice.com/"))
                null else "Некорректный адрес портала"
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