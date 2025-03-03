package ks.connecttooffice10.data.model

data class FilesApiResponse(
    val count: Int?,
    val links: List<LinkDto>?,
    val response: FolderContentDto,
    val status: Int?,
    val statusCode: Int?
)

data class LinkDto(
    val action: String?,
    val href: String?
)

data class FolderContentDto(
    val count: Int?,
    val current: Current?,
    val files: List<FileDto>,
    val folders: List<FolderDto>,
    val new: Int?,
    val pathParts: List<PathPartDto>?,
    val startIndex: Int?,
    val total: Int?
)

data class Current(
    val access: Int?,
    val canShare: Boolean?,
    val created: String?,
    val createdBy: CreatedBy?,
    val denyDownload: Boolean?,
    val fileEntryType: Int?,
    val filesCount: Int?,
    val foldersCount: Int?,
    val id: Int?,
    val indexing: Boolean?,
    val mute: Boolean?,
    val new: Int?,
    val parentId: Int?,
    val pinned: Boolean?,
    val `private`: Boolean?,
    val rootFolderId: Int?,
    val rootFolderType: Int?,
    val security: Security?,
    val shared: Boolean?,
    val title: String?,
    val updated: String?,
    val updatedBy: UpdatedBy?
)

data class FileDto(
    val access: Int?,
    val availableExternalRights: AvailableExternalRights?,
    val canShare: Boolean?,
    val comment: String?,
    val contentLength: String?,
    val created: String?,
    val createdBy: CreatedBy?,
    val fileEntryType: Int?,
    val fileExst: String?,
    val fileStatus: Int?,
    val fileType: Int?,
    val folderId: Int?,
    val hasDraft: Boolean?,
    val id: Int,
    val isForm: Boolean?,
    val mute: Boolean?,
    val pureContentLength: Int?,
    val rootFolderId: Int?,
    val rootFolderType: Int?,
    val security: SecurityX?,
    val shared: Boolean?,
    val thumbnailStatus: Int?,
    val title: String,
    val updated: String?,
    val updatedBy: UpdatedBy?,
    val version: Int?,
    val versionGroup: Int?,
    val viewAccessibility: ViewAccessibility?,
    val viewUrl: String?,
    val webUrl: String?
)

data class FolderDto(
    val access: Int?,
    val canShare: Boolean?,
    val created: String?,
    val createdBy: CreatedBy?,
    val denyDownload: Boolean?,
    val fileEntryType: Int?,
    val filesCount: Int?,
    val foldersCount: Int?,
    val id: Int,
    val indexing: Boolean?,
    val mute: Boolean?,
    val new: Int?,
    val parentId: Int?,
    val pinned: Boolean?,
    val `private`: Boolean?,
    val rootFolderId: Int?,
    val rootFolderType: Int?,
    val security: Security?,
    val shared: Boolean?,
    val title: String,
    val updated: String?,
    val updatedBy: UpdatedBy?
)

data class PathPartDto(
    val id: Int?,
    val title: String?
)

data class CreatedBy(
    val avatar: String?,
    val avatarMax: String?,
    val avatarMedium: String?,
    val avatarOriginal: String?,
    val avatarSmall: String?,
    val displayName: String?,
    val hasAvatar: Boolean?,
    val id: String?,
    val isAnonim: Boolean?,
    val profileUrl: String?
)

data class Security(
    val ChangeOwner: Boolean?,
    val Copy: Boolean?,
    val CopyLink: Boolean?,
    val CopySharedLink: Boolean?,
    val CopyTo: Boolean?,
    val Create: Boolean?,
    val CreateRoomFrom: Boolean?,
    val Delete: Boolean?,
    val Download: Boolean?,
    val Duplicate: Boolean?,
    val EditAccess: Boolean?,
    val EditRoom: Boolean?,
    val Embed: Boolean?,
    val IndexExport: Boolean?,
    val Move: Boolean?,
    val MoveTo: Boolean?,
    val Mute: Boolean?,
    val Pin: Boolean?,
    val Read: Boolean?,
    val Reconnect: Boolean?,
    val Rename: Boolean?
)

data class UpdatedBy(
    val avatar: String?,
    val avatarMax: String?,
    val avatarMedium: String?,
    val avatarOriginal: String?,
    val avatarSmall: String?,
    val displayName: String?,
    val hasAvatar: Boolean?,
    val id: String?,
    val isAnonim: Boolean?,
    val profileUrl: String?
)

data class AvailableExternalRights(
    val Comment: Boolean?,
    val CustomFilter: Boolean?,
    val Editing: Boolean?,
    val None: Boolean?,
    val Read: Boolean?,
    val Restrict: Boolean?,
    val Review: Boolean?
)

data class SecurityX(
    val Comment: Boolean?,
    val Convert: Boolean?,
    val Copy: Boolean?,
    val CopyLink: Boolean?,
    val CreateRoomFrom: Boolean?,
    val CustomFilter: Boolean?,
    val Delete: Boolean?,
    val Download: Boolean?,
    val Duplicate: Boolean?,
    val Edit: Boolean?,
    val EditHistory: Boolean?,
    val Embed: Boolean?,
    val FillForms: Boolean?,
    val Lock: Boolean?,
    val Move: Boolean?,
    val Read: Boolean?,
    val ReadHistory: Boolean?,
    val Rename: Boolean?,
    val Review: Boolean?,
    val SubmitToFormGallery: Boolean?
)

data class ViewAccessibility(
    val CanConvert: Boolean?,
    val CoAuhtoring: Boolean?,
    val ImageView: Boolean?,
    val MediaView: Boolean?,
    val MustConvert: Boolean?,
    val WebComment: Boolean?,
    val WebCustomFilterEditing: Boolean?,
    val WebEdit: Boolean?,
    val WebRestrictedEditing: Boolean?,
    val WebReview: Boolean?,
    val WebView: Boolean?
)