package ks.connecttooffice10.domain

import ks.connecttooffice10.data.FileDataModel
import javax.inject.Inject

class MockLoadDocumentsUseCase @Inject constructor() : LoadDocumentsUseCase {
    override suspend operator fun invoke(): List<FileModel> {
        return listOf(
            FileModel( "Document", "Document", 1),
            FileModel( "Room", "Room", 2),
            FileModel( "Folder", "Folder", 3),
        )
    }
}