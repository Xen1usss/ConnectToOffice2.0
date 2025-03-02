package ks.connecttooffice10.domain

import ks.connecttooffice10.domain.model.File

interface LoadDocumentsUseCase {
    suspend operator fun invoke(folderId: String?): List<File>
}