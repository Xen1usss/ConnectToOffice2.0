package ks.connecttooffice10.data

import ks.connecttooffice10.domain.model.File
import ks.connecttooffice10.domain.model.FileType
import javax.inject.Inject

class FilesRepositoryImpl @Inject constructor(
    private val api: FileApi
) : FilesRepository {

    override suspend fun loadFolderContentsById(id: String): List<File> {
        val response = api.getFolder(id)
        val listFiles = response.response.files
        val listFolders = response.response.folders
        val listOfDomainFiles = mutableListOf<File>()


        for (i in 0 until listFiles.size) {
            listOfDomainFiles.add(
                File(
                    id = listFiles[i].id.toString(),
                    name = listFiles[i].title,
                    fileType = FileType.FILE
                )
            )
        }

        for (i in 0 until listFolders.size) {
            listOfDomainFiles.add(
                File(
                    id = listFolders[i].id.toString(),
                    name = listFolders[i].title,
                    fileType = FileType.FOLDER
                )
            )
        }
        return listOfDomainFiles
    }
    /*
    listFiles = [
        FileDto(access = false, id = 12, comment = "kgam"....),
        FileDto(access = false, id = 13, comment = "kgam"....),
        FileDto(access = false, id = 14, comment = "kgam"....),
        FileDto(access = false, id = 125, comment = "kgam"....),
        FileDto(access = false, id = 15, comment = "kgam"....),
        FileDto(access = false, id = 16, comment = "kgam"....),
    ]

    */


    override suspend fun loadDocuments(): List<File> {
        return loadFolderContentsById("@my")
    }

    override suspend fun loadTrash(): List<File> {
        return loadFolderContentsById("@trash")
    }
}