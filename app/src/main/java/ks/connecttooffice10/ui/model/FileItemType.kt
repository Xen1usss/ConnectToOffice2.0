package ks.connecttooffice10.ui.model

import androidx.annotation.DrawableRes
import ks.connecttooffice10.R

enum class FileItemType(@DrawableRes val iconResId: Int) {
    FILE(R.drawable.ic_folder_open), FOLDER(R.drawable.ic_folder_open), ROOM(R.drawable.ic_folder_open)
}