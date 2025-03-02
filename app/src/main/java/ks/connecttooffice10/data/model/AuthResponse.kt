package ks.connecttooffice10.data.model

data class ApiResponse(
    val count: Int,
    val response: AuthResponse,
    val status: Int,
    val statusCode: Int
)

data class AuthResponse(
    val expires: String,
    val token: String
)