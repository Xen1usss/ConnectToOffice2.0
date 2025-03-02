package ks.connecttooffice10.domain

import ks.connecttooffice10.data.AuthRepository
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : LoginUseCase {
    override suspend fun invoke(
        domainUrl: String,
        login: String,
        password: String
    ): Result<Unit> {
        return authRepository.login(domainUrl, login, password)
    }
}