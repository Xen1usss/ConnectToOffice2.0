package ks.connecttooffice10.ui.model

import ks.connecttooffice10.ui.screen.FileItemType

data class FileUiModel(
    val fileName: String,
    val fileType: FileItemType,
    val id: String
)
