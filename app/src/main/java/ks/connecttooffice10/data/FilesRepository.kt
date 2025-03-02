package ks.connecttooffice10.data

import ks.connecttooffice10.domain.model.File

interface FilesRepository {
    suspend fun loadFolderContentsById(id: String) : List<File>
    suspend fun loadDocuments(): List<File>
    suspend fun loadTrash(): List<File>
}