package ks.connecttooffice10.data

import ks.connecttooffice10.data.model.FilesApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FileApi {

    @GET("/api/2.0/files/{id}")
    suspend fun getFolder(
        @Path("id") id: String
    ): FilesApiResponse

}