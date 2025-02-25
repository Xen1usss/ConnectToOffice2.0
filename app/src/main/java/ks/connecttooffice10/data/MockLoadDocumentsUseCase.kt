package ks.connecttooffice10.data

import javax.inject.Inject

class MockLoadDocumentsUseCase @Inject constructor() : LoadDocumentsUseCase {
    override suspend operator fun invoke(): List<FileDataModel> {
        return listOf(
            FileDataModel(1, "Document", "Document"),
            FileDataModel(2, "Room", "Room"),
            FileDataModel(3, "Folder", "Folder")
        )
    }
}