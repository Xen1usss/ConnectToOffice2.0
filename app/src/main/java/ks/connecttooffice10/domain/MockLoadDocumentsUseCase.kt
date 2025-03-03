package ks.connecttooffice10.domain

import ks.connecttooffice10.domain.model.File
import javax.inject.Inject

class MockLoadDocumentsUseCase @Inject constructor() : LoadDocumentsUseCase {
    override suspend operator fun invoke(folderId: String?): List<File> {

        return when (folderId) {
            null -> emptyList()

            else -> emptyList() // Если папка не найдена

//        return listOf(
//            FileModel( "Document", "Document", 1),
//            FileModel( "Room", "Room", 2),
//            FileModel( "Folder", "Folder", 3),
//        )
        }
    }
}