package ks.connecttooffice10.ui.model

sealed interface DocumentsScreenState {

    object Loading : DocumentsScreenState
//    data class Error(val message: String) : DocumentsScreenState
    data class Success(
        val documentsList: List<FileUiModel>,
        val title: String,
        val isBackEnabled: Boolean
    ) : DocumentsScreenState
}