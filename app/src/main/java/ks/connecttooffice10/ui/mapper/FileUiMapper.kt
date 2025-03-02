package ks.connecttooffice10.ui.mapper

import ks.connecttooffice10.domain.model.File
import ks.connecttooffice10.domain.model.FileType
import ks.connecttooffice10.ui.model.FileItemType
import ks.connecttooffice10.ui.model.FileUiModel
import javax.inject.Inject

class FileUiMapper @Inject constructor(){

    fun toUiModel(fileDomainModel: File): FileUiModel {
        return FileUiModel(
            fileName = fileDomainModel.name,
            fileType = when (fileDomainModel.fileType) {
                FileType.FILE -> FileItemType.FILE
                FileType.FOLDER -> FileItemType.FOLDER
                FileType.ROOM -> FileItemType.ROOM
            },
            id = fileDomainModel.id
        )
    }
}