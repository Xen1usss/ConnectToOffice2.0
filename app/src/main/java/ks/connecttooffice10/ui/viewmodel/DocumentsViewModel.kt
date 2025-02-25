package ks.connecttooffice10.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ks.connecttooffice10.data.MockLoadDocumentsUseCase
import ks.connecttooffice10.domain.FileDomainModel
import ks.connecttooffice10.ui.mapper.MapperDomainToUi
import ks.connecttooffice10.ui.model.FileUiModel
import javax.inject.Inject

class DocumentsViewModel @Inject constructor(
    private val mockLoadDocumentsUseCase: MockLoadDocumentsUseCase,
    private val mapper: MapperDomainToUi
) : ViewModel() {

    // Поток для хранения списка UI-моделей
    val documentsListFlow = MutableStateFlow(emptyList<FileUiModel>())

    init {
        addDocument()
    }

    private fun addDocument() {
        viewModelScope.launch {
            val dataModels = mockLoadDocumentsUseCase()

            val domainModels = dataModels.map { dataModel ->
                FileDomainModel(
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