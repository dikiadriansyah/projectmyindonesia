package com.example.projectmyindonesia.data

import androidx.compose.ui.graphics.vector.ImageVector


data class NavigationItemContent(
    val menuType: MenuType,
    val icon: ImageVector,
    val text: String
)

enum class MenuType{
    Wisata, Museum
}