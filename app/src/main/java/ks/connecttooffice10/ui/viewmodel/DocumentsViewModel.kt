package ks.connecttooffice10.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ks.connecttooffice10.data.LoadDocumentsUseCase
import ks.connecttooffice10.domain.FileModel
import ks.connecttooffice10.ui.mapper.FileUiMapper
import ks.connecttooffice10.ui.model.FileUiModel
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val loadDocumentsUseCase: LoadDocumentsUseCase,
    private val mapper: FileUiMapper
) : ViewModel() {

    // Поток для хранения списка UI-моделей
    val documentsListFlow = MutableStateFlow(emptyList<FileUiModel>())

    init {
        addDocument()
    }

    private fun addDocument() {
        viewModelScope.launch {
            val dataModels = loadDocumentsUseCase()

            val domainModels = dataModels.map { dataModel ->
                FileModel(
                    name = dataModel.name,
                    type = dataModel.type,
                    id = dataModel.id
                )
            }

            val uiModels = domainModels.map { domainModel ->
                mapper.toUiModel(domainModel)
            }
            documentsListFlow.value = uiModels
        }
    }
}