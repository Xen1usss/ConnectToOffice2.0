package ks.connecttooffice10.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ks.connecttooffice10.ui.theme.ConnectToOffice10Theme
import ks.connecttooffice10.ui.viewmodel.LoginViewModel

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConnectToOffice10Theme {
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember { SnackbarHostState()}
                val viewModel = hiltViewModel<LoginViewModel>()
                val message = viewModel.message.value
                if (message?.isUsed == false) {
                    message.isUsed = true
                    scope.launch {
                        snackbarHostState.showSnackbar(message.text)
                    }
                }
                LaunchedEffect(viewModel.navigateMain.value) {
                    val value = viewModel.navigateMain.value
                    if (value == Unit) {
                        startActivity(
                            Intent(this@LoginActivity, MainActivity::class.java).apply {
                                setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) //fixme
                            }
                        )
                        viewModel.navigateMain.value = null
                    }
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(snackbarHostState)
                    }
                ) { innerPadding ->
                    LoginScreen(
                        context = this,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    context: Context,
    viewModel: LoginViewModel
) {
    val portal by viewModel.portal
    val email by viewModel.email
    val password by viewModel.password

    val portalError by viewModel.portalError
    val emailError by viewModel.emailError
    val passwordError by viewModel.passwordError

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Connect to ONLYOFFICE", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = portal,
            onValueChange = { viewModel.onPortalChanged(it) },
            label = { Text("Portal") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.onEmailChanged(it) },
            label = { Text("E-mail") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = emailError != null
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError != null
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                viewModel.onLoginClick()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = portalError == null && emailError == null && passwordError == null
        ) {
            Text("Login")
        }

    }
}