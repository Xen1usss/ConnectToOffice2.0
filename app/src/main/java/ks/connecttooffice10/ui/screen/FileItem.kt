package ks.connecttooffice10.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ks.connecttooffice10.ui.model.FileItemType
import ks.connecttooffice10.ui.theme.ConnectToOffice10Theme

@Composable
fun FileItem(
    fileName: String,
    fileType: FileItemType
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
    ) {
        FileOrRoomOrFolderListItemIcon(fileType)
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically),
            text = fileName,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun FileOrRoomOrFolderListItemIcon(
    listItemType: FileItemType
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(32.dp, 32.dp)
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(22.dp),
            tint = Color.White,
            painter = painterResource(listItemType.iconResId),
            contentDescription = null,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewFileOrRoomOrFolderListItemIcon() {
    ConnectToOffice10Theme {
        FileOrRoomOrFolderListItemIcon(FileItemType.FILE)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewFile() {
    ConnectToOffice10Theme {
        FileItem("Test.docx", FileItemType.FILE)
    }
}

