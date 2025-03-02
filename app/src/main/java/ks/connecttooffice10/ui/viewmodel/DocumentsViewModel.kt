package ks.connecttooffice10.ui.viewmodel

import android.util.Log
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

    private val navigationStack = mutableListOf<String>() // стек для хранения id пути навигации

    init {
        loadDocuments(null) // Загружаем корневую папку
    }

    // Загрузка данных для папки
    private fun loadDocuments(folderId: String?) {
        viewModelScope.launch {
            val documents = loadDocumentsUseCase(folderId).map { mapper.toUiModel(it) }

            state.value = DocumentsScreenState.Success(
                documentsList = documents,
                title = folderId?.let { "Folder $folderId" } ?: "Documents",
                isBackEnabled = navigationStack.isNotEmpty() // Кнопка "Назад" активна, если есть куда возвращаться
            )
        }
    }

    // Переход в папку
    fun navigateToFolder(folderId: String) {
        navigationStack.add(folderId) // Добавляем папку в стек
        loadDocuments(folderId) // Загружаем данные для новой папки
    }

    // Возврат назад
    fun onBackClicked() {
        if (navigationStack.isNotEmpty()) {
            navigationStack.removeLast() // Удаляем текущую папку из стека
            val previousFolderId = navigationStack.lastOrNull() // Получаем ID предыдущей папки
            loadDocuments(previousFolderId) // Загружаем данные для предыдущей папки
        }
    }

    // Обработка нажатия на элемент
    fun onFileClicked(file: FileUiModel) {
        Log.d("Documents","File clicked: ${file.fileName}, ID: ${file.id}")
        if (file.fileType == FileItemType.FOLDER) {
            navigateToFolder(file.id) // Переход в папку
        }
    }
}