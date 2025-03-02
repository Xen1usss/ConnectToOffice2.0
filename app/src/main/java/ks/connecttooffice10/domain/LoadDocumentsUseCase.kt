package ks.connecttooffice10.domain

interface LoadDocumentsUseCase {
    suspend operator fun invoke(folderId: String?): List<FileModel>
}