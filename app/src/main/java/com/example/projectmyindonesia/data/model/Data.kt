package com.example.projectmyindonesia.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.projectmyindonesia.data.MenuType

data class Data(
    val id: Int,
    @StringRes val judulTempatWisata: Int,
    @DrawableRes val imgResourceTempatWisata: Int,
    @StringRes val deskripsiTempatWisata: Int,
    val type: MenuType

)
