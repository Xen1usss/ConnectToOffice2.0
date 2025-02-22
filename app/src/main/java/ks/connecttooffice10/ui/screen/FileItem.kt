package ks.connecttooffice10.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ks.connecttooffice10.R
import ks.connecttooffice10.ui.theme.ConnectToOffice10Theme
import ks.connecttooffice10.ui.theme.Purple40

@Composable
fun FileItem(fileName: String) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        FileIcon()
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
@Preview(showBackground = true)
private fun FileIcon() {
    Icon(
        tint = Color.White,
        painter = painterResource(R.drawable.ic_folder_open),
        contentDescription = null,
    )
}



@Composable
@Preview(showBackground = true)
fun Kruzhochek() {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(32.dp, 32.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {

    }
}


@Composable
@Preview(showBackground = true)
fun FolderIcon() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Kruzhochek()
        FileIcon()
    }
}












@Composable
//@Preview(showBackground = true)
fun PreviewFile() {
    ConnectToOffice10Theme {
        FileItem("Test.docx")
    }
}