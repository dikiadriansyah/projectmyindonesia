package com.example.projectmyindonesia.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Museum
import androidx.compose.material.icons.filled.Tour
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.example.projectmyindonesia.R
import com.example.projectmyindonesia.data.MenuType
import com.example.projectmyindonesia.data.NavigationItemContent
import com.example.projectmyindonesia.data.model.Data
import com.example.projectmyindonesia.utils.ContentType
import com.example.projectmyindonesia.utils.NavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigationType: NavigationType,
    contentType: ContentType,
    uiState: PlaceUiState,
    onTabPressed: (MenuType) -> Unit,
    onCardPressed: (Data) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    val navigationItemContentList = listOf(
        NavigationItemContent(
            menuType = MenuType.Museum,
            icon = Icons.Filled.Museum,
            text = stringResource(id = R.string.tab_museum)
        ),
        NavigationItemContent(
            menuType = MenuType.Wisata,
            icon = Icons.Filled.Tour,
            text = stringResource(id = R.string.tab_wisata)
        )
    )
    
    if(navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER){
        val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)
        PermanentNavigationDrawer(
            drawerContent = {
        /*TODO*/
            NavigationDrawerContent(
                selectedDestination = uiState.currentMenu,
                onTabPressed = onTabPressed,
                navigationItemContentList = navigationItemContentList
            )
        }, modifier = Modifier.testTag(navigationDrawerContentDescription)
            ) {
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                uiState = uiState,
                onTabPressed = onTabPressed,
                onCardPressed = onCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }
    }else{
        if(uiState.isShowingHomePage){
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                uiState = uiState,
                onTabPressed = onTabPressed,
                onCardPressed = onCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }else{
            DetailsScreen(
                uiState = uiState,
                isFullScreen = true,
                modifier = modifier,
                onBackPressed = onDetailScreenBackPressed
            )
        }
    }
}

@Composable
private fun AppContent(
    navigationType: NavigationType,
    contentType: ContentType,
    uiState: PlaceUiState,
    onTabPressed: (MenuType) -> Unit,
    onCardPressed: (Data) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier.fillMaxSize()){
     AnimatedVisibility(visible = navigationType == NavigationType.NAVIGATION_RAIL){
         val navigationRailContentDescription = stringResource(R.string.navigation_rail)
         NavigationRail(
             currentTab = uiState.currentMenu,
             onTabPressed = onTabPressed,
             navigationItemContentList = navigationItemContentList,
             modifier = Modifier.testTag(navigationRailContentDescription)
         )
     }
        Column(
            modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            if(contentType == ContentType.LIST_AND_DETAIL){
                ListAndDetailContent(
                    uiState = uiState,
                    onCardPressed = onCardPressed,
                    modifier = Modifier.weight(1f)
                )
            }else{
                ListOnlyContent(
                    uiState = uiState,
                    onCardPressed = onCardPressed,
                    modifier = Modifier.weight(1f)
                )
            }

            AnimatedVisibility(visible = navigationType == NavigationType.BOTTOM_NAVIGATION){
                val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
                BottomNavigationBar(
                    currentTab = uiState.currentMenu,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier.testTag(bottomNavigationContentDescription)
                )
            }

        }
    }
}

@Composable
private fun NavigationRail(
    currentTab: MenuType,
    onTabPressed: ((MenuType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    NavigationRail(modifier = modifier.fillMaxHeight()){
        for(navItem in navigationItemContentList){
            NavigationRailItem(
                selected = currentTab == navItem.menuType,
                onClick = { onTabPressed(navItem.menuType) },
                icon={
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

@Composable
private fun BottomNavigationBar(
    currentTab: MenuType,
    onTabPressed: ((MenuType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    NavigationBar(modifier = modifier.fillMaxWidth()){
        for(navItem in navigationItemContentList){
            NavigationBarItem(
                selected = currentTab == navItem.menuType,
                onClick = {
                    onTabPressed(navItem.menuType)
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.text)
                }
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationDrawerContent(
    selectedDestination: MenuType,
    onTabPressed: ((MenuType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    Column(
        modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(12.dp)
    ){
        NavigationDrawerHeader(modifier)
        for(navItem in navigationItemContentList){
            NavigationDrawerItem(
                selected = selectedDestination == navItem.menuType,
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = 16.dp)
                        )
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.text)
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = {
                    onTabPressed(navItem.menuType)
                }
            )

        }
    }

}

@Composable
private fun NavigationDrawerHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ){
        AppLogo(modifier = Modifier.size(48.dp))
        ProfileImage(
            drawableResource = R.drawable.avatar,
            description = stringResource(id = R.string.profile),
            modifier = Modifier.size(28.dp)
        )

    }

}


@Composable
fun ProfileImage(
  @DrawableRes drawableResource: Int,
  description: String,
  modifier: Modifier = Modifier
)
{
    Image(
        modifier = modifier.clip(CircleShape),
        painter = painterResource(drawableResource),
        contentDescription = description
    )
}



@Composable
fun AppLogo(
    modifier: Modifier = Modifier,

){
    Image(
        painter = painterResource(R.drawable.indonesia_flag),
        contentDescription = stringResource(id = R.string.logo),

        modifier = modifier
    )

}