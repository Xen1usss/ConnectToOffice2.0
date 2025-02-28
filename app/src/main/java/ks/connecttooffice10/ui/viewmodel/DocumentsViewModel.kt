package ks.connecttooffice10.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ks.connecttooffice10.domain.LoadDocumentsUseCase
import ks.connecttooffice10.ui.mapper.FileUiMapper
import ks.connecttooffice10.ui.model.DocumentsScreenState
import ks.connecttooffice10.ui.model.FileUiModel
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val loadDocumentsUseCase: LoadDocumentsUseCase,
    private val mapper: FileUiMapper
) : ViewModel() {

    val state: MutableStateFlow<DocumentsScreenState> = MutableStateFlow(DocumentsScreenState.Loading)

    init {
        loadDocuments()
    }

    private fun loadDocuments() {
        viewModelScope.launch {
            val documents = loadDocumentsUseCase().map { mapper.toUiModel(it) }

            state.value = DocumentsScreenState.Success(
                documentsList = documents,
                title = "Documents",
                isBackEnabled = false
            )
        }
    }

    fun onFileClicked(file: FileUiModel) {
        println("File clicked: ${file.fileName}, ID: ${file.id}")
    }
}