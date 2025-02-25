package ks.connecttooffice10.ui.mapper

import ks.connecttooffice10.domain.FileDomainModel
import ks.connecttooffice10.ui.model.FileUiModel
import ks.connecttooffice10.ui.screen.FileItemType
import javax.inject.Inject

class MapperDomainToUi @Inject constructor(){

    fun toUiModel(fileDomainModel: FileDomainModel): FileUiModel {
        return FileUiModel(
            fileName = fileDomainModel.name,
            fileType = when (fileDomainModel.type) {
                "Document" -> FileItemType.FILE
                "Folder" -> FileItemType.FOLDER
                "Room" -> FileItemType.ROOM
                else -> throw IllegalArgumentException("Unknown file type: ${fileDomainModel.type}")
            },
            id = fileDomainModel.id.toString()
        )
    }
}