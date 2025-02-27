package ks.connecttooffice10.domain

import ks.connecttooffice10.data.FileDataModel

interface LoadDocumentsUseCase {
    suspend operator fun invoke(): List<FileModel>
}

// create data class for domain model

// implement LoadDocumentsUseCase return listOf(...) MockLoadDocumentsUseCase

// map domain model onto ui model -> create Mapper class and inject into VM

// inject MockLoadDocumentsUseCase into ViewModel, call use case and display data