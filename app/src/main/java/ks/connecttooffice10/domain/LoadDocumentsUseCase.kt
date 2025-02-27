package ks.connecttooffice10.domain

interface LoadDocumentsUseCase {
    suspend operator fun invoke(): List<FileModel>
}