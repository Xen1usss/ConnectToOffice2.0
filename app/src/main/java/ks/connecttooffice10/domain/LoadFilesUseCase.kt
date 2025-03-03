package ks.connecttooffice10.domain

import ks.connecttooffice10.data.FilesRepository
import ks.connecttooffice10.domain.model.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadFilesUseCase @Inject constructor(
    private val repository: FilesRepository
) : LoadDocumentsUseCase {
    override suspend fun invoke(folderId: String?): List<File> {
        return repository.loadDocuments()
    }
}