package ks.connecttooffice10.data

interface FilesRepository {
    suspend fun loadFiles() : List<String>
}