package ks.connecttooffice10.domain.model

data class File(
    val name: String,
    val id: String,
    val fileType: FileType
)

enum class FileType {
    FILE, FOLDER, ROOM
}