package ks.connecttooffice10.domain

interface LoginUseCase {

    suspend operator fun invoke(domainUrl: String, login: String, password: String): Result<Unit>
}