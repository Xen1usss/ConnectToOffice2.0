package ks.connecttooffice10.domain

import ks.connecttooffice10.domain.model.File
import javax.inject.Inject

class MockLoadDocumentsUseCase @Inject constructor() : LoadDocumentsUseCase {
    override suspend operator fun invoke(folderId: String?): List<File> {

        return when (folderId) {
            null -> emptyList()

            else -> emptyList()

        }
    }
}