@file:OptIn(ExperimentalMaterial3Api::class)

package ks.connecttooffice10.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ks.connecttooffice10.ui.model.DocumentsScreenState
import ks.connecttooffice10.ui.model.FileItemType
import ks.connecttooffice10.ui.model.FileUiModel
import ks.connecttooffice10.ui.theme.ConnectToOffice10Theme
import ks.connecttooffice10.ui.viewmodel.DocumentsViewModel

@Composable
fun DocumentsScreen() {
    val viewModel: DocumentsViewModel = hiltViewModel()
    val documentsScreenStateFlow = viewModel.state
    val state: State<DocumentsScreenState> = documentsScreenStateFlow.collectAsState(DocumentsScreenState.Loading)
    when (val actualState = state.value) {
        DocumentsScreenState.Loading -> LoadingState()
        is DocumentsScreenState.Success -> SuccessState(actualState)
    }
}

@Composable
fun SuccessState(successState: DocumentsScreenState.Success) {
    val (documentsList, title, isBackEnabled) = successState
    DocumentsScreenContent(documentsList, title, isBackEnabled)
}

@Composable
fun DocumentsScreenContent(filesList: List<FileUiModel>, title: String, isBackEnabled: Boolean) {
    Column {
        val navigationIcon = @Composable {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        }
        val noNavigationIcon = @Composable {}
        LargeTopAppBar(
            title = {
                Text(title)
            },
            navigationIcon = if (isBackEnabled) navigationIcon else noNavigationIcon,
        )
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            DocumentsList(filesList)
        }
    }
}

@Composable
fun DocumentsList(files: List<FileUiModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(files) { file ->
            FileItem(fileName = file.fileName, fileType = file.fileType)
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewScreen() {
    ConnectToOffice10Theme {
        val mockFiles = listOf(
            FileUiModel("Document", FileItemType.FILE, "1"),
            FileUiModel("Room", FileItemType.ROOM, "2"),
            FileUiModel("Folder", FileItemType.FOLDER, "3")
        )
        DocumentsScreenContent(mockFiles, "documnets title", false)
    }
}


@Composable
@Preview(showBackground = true)
fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        CircularProgressIndicator()
    }
}
