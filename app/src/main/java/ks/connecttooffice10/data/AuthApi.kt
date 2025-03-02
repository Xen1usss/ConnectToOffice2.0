package ks.connecttooffice10.data

import ks.connecttooffice10.data.model.ApiResponse
import ks.connecttooffice10.data.model.AuthDto
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url


const val authPath = "/api/2.0/authentication/"

interface AuthApi {

    @POST
    suspend fun login(
        @Url url: String,
        @Body authData: AuthDto
    ): ApiResponse

}

/*
https://yourportal.onlyoffice.com/api/2.0/authentication.json
POST /api/2.0/authentication.json HTTP/1.1
Host: yourportal.onlyoffice.com
Content-Type: application/json
Accept: application/json

{
    "userName": "yourusername",
    "password": "yourpassword"
}

*/
