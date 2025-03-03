package ks.connecttooffice10.data

import ks.connecttooffice10.data.model.ApiResponse
import ks.connecttooffice10.data.model.AuthDto
import ks.connecttooffice10.di.network.FilesApiProvider
import java.net.URI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val fileApiProvider: FilesApiProvider
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
            fileApiProvider.initializeWithBaseUrl(domain, token!!) // in single thread !! is safe
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun createUrl(domain: String): String {
        return URI(domain).resolve(authPath).toString()
    }

    private fun saveToken(response: ApiResponse) {
        token = response.response.token
    }

    override fun getAuthToken(): String? {
        return token
    }
}