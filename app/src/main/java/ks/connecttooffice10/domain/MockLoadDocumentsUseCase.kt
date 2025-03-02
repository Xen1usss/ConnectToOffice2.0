package ks.connecttooffice10.domain

import javax.inject.Inject

class MockLoadDocumentsUseCase @Inject constructor() : LoadDocumentsUseCase {
    override suspend operator fun invoke(folderId: String?): List<FileModel> {

        return when (folderId) {
            null -> listOf( // Корневая папка
                FileModel("Document1", "Document", 1),
                FileModel("Folder1", "Folder", 2),
                FileModel("Room1", "Room", 3)
            )

            "2" -> listOf( // Папка "Folder1"
                FileModel("Document2", "Document", 4),
                FileModel("Folder2", "Folder", 5)
            )

            "5" -> listOf( // Папка "Folder2"
                FileModel("Document3", "Document", 6)
            )

            else -> emptyList() // Если папка не найдена

//        return listOf(
//            FileModel( "Document", "Document", 1),
//            FileModel( "Room", "Room", 2),
//            FileModel( "Folder", "Folder", 3),
//        )
        }
    }
}