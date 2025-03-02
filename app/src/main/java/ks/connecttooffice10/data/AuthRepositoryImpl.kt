package ks.connecttooffice10.data

import android.net.Uri
import android.util.Log
import ks.connecttooffice10.data.model.ApiResponse
import ks.connecttooffice10.data.model.AuthDto
import java.net.URI
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {
    private var token: String? = null

    override suspend fun login(domain: String, login: String, password: String): Result<Unit> {
        return try {
            val response = authApi.login(
                url = createUrl(domain),
                authData = AuthDto(
                    login, password
                )
            )
            saveToken(response)

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun createUrl(domain: String): String {
        //domain ...com || ...com/
        return URI(domain).resolve(authPath).toString()
    }

    private fun saveToken(response: ApiResponse) {
        token = response.response.token
    }


    override fun getAuthToken(): String? {
        return token
    }
}