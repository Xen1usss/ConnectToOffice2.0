package ks.connecttooffice10.data


interface AuthRepository {

    suspend fun login(domain: String, login: String, password: String): Result<Unit>

    fun getAuthToken(): String?

}
