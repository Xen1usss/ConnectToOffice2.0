package ks.connecttooffice10.ui.model

sealed class DocumentsScreenState {
    object Loading : DocumentsScreenState()
    data class Success(
        val documentsList: List<FileUiModel>,
        val title: String,
        val isBackEnabled: Boolean
    ) : DocumentsScreenState() {
        // Переопределяем equals и hashCode, чтобы Compose мог корректно сравнивать состояния
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Success) return false
            return documentsList == other.documentsList &&
                    title == other.title &&
                    isBackEnabled == other.isBackEnabled
        }

        override fun hashCode(): Int {
            return documentsList.hashCode() + title.hashCode() + isBackEnabled.hashCode()
        }
    }
}

//sealed class DocumentsScreenState {
//
//    object Loading : DocumentsScreenState()
////    data class Error(val message: String) : DocumentsScreenState
//    data class Success(
//        val documentsList: List<FileUiModel>,
//        val title: String,
//        val isBackEnabled: Boolean
//    ) : DocumentsScreenState()
//}