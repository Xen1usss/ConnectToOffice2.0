package ks.connecttooffice10.di.network

import com.squareup.moshi.Moshi
import ks.connecttooffice10.data.FileApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilesApiProvider @Inject constructor(
    private val moshi: Moshi,
) {

    private var instance: FileApi? = null

    fun initializeWithBaseUrl(baseUrl: String, token: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createOkHttp(token))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        instance = retrofit.create(FileApi::class.java)
    }

    fun getApi() : FileApi {
        return instance ?: throw IllegalStateException()
    }

    private fun createOkHttp(token: String): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(AuthHeaderInterceptor(token))
            .addInterceptor(interceptor)
            .build()
    }

}

class AuthHeaderInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .header("Authorization", token)
            .build()
        return chain.proceed(newRequest)
    }
}