package ks.connecttooffice10.data

interface LoadDocumentsUseCase {
    suspend operator fun invoke(): List<FileDataModel> {
        return listOf(
            FileDataModel(1,"Document", "Document"),
            FileDataModel(2,"Room", "Room"),
            FileDataModel(3,"Folder", "Folder"),
        )
    }
}

// create data class for domain model

// implement LoadDocumentsUseCase return listOf(...) MockLoadDocumentsUseCase

// map domain model onto ui model -> create Mapper class and inject into VM

// inject MockLoadDocumentsUseCase into ViewModel, call use case and display data