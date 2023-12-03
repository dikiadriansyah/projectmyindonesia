package com.example.projectmyindonesia.ui

import androidx.lifecycle.ViewModel
import com.example.projectmyindonesia.data.MenuType
import com.example.projectmyindonesia.data.model.Data
import com.example.projectmyindonesia.data.source.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


data class PlaceUiState(
    val dataList: Map<MenuType, List<Data>> = emptyMap(),
    val currentMenu: MenuType = MenuType.Museum,
    val currentSelectedData: Data = DataSource.defaultData,
    val isShowingListPage: Boolean = true,
    val isShowingHomePage: Boolean = true,
) {
    val currentMenuData: List<Data> by lazy { dataList[currentMenu]!! }
}

class PlaceViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(PlaceUiState())
    val uiState: StateFlow<PlaceUiState> = _uiState

    init{
        initializeUIState()
    }

   private fun initializeUIState(){
        var datas: Map<MenuType, List<Data>> = DataSource.getAllData().groupBy{ it.type }

       _uiState.value = PlaceUiState(
           dataList = datas,
           currentSelectedData = datas[MenuType.Museum]?.get(0) ?: DataSource.defaultData
       )
   }

    fun updateDetailsScreenState(data: Data){
        _uiState.update{
            it.copy(
                currentSelectedData = data,
                isShowingHomePage = false
            )
        }
    }

    fun resetHomeScreenState(){
        _uiState.update{
            it.copy(
                currentSelectedData = it.dataList[it.currentMenu]?.get(0) ?: DataSource.defaultData,
                isShowingHomePage = true
            )
        }
    }

    fun updateCurrentMenu(menuType: MenuType){
        _uiState.update{
            it.copy(currentMenu = menuType)
        }
    }
}
