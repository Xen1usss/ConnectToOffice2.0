package ks.connecttooffice10.domain

import javax.inject.Inject

data class FileDomainModel @Inject constructor(
    val name: String,
    val type: String,
    val id: Int
)