package ks.connecttooffice10.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ks.connecttooffice10.domain.LoadDocumentsUseCase
import ks.connecttooffice10.ui.mapper.FileUiMapper
import ks.connecttooffice10.ui.model.DocumentsScreenState
import ks.connecttooffice10.ui.model.FileItemType
import ks.connecttooffice10.ui.model.FileUiModel
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val loadDocumentsUseCase: LoadDocumentsUseCase,
    private val mapper: FileUiMapper
) : ViewModel() {

    val state: MutableStateFlow<DocumentsScreenState> = MutableStateFlow(DocumentsScreenState.Loading)

    private val navigationStack = mutableListOf<String>()

    init {
        loadDocuments(null)
    }

    private fun loadDocuments(folderId: String?) {
        viewModelScope.launch {
            val documents = loadDocumentsUseCase(folderId).map { mapper.toUiModel(it) }

            val folderName = documents.find { it.id == folderId }?.fileName ?: "Documents"

            state.value = DocumentsScreenState.Success(
                documentsList = documents.toList(),
                title = folderName,
                isBackEnabled = navigationStack.isNotEmpty()
            )
        }
    }

    fun navigateToFolder(folderId: String) {
        navigationStack.add(folderId)
        loadDocuments(folderId)
    }

    fun onBackClicked() {
        if (navigationStack.isNotEmpty()) {
            navigationStack.removeLast()
            val previousFolderId = navigationStack.lastOrNull()
            loadDocuments(previousFolderId)
        }
    }

    fun onFileClicked(file: FileUiModel) {
        if (file.fileType == FileItemType.FOLDER) {
            navigateToFolder(file.id)
        }
    }
}