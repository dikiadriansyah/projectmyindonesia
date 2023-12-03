package com.example.projectmyindonesia.ui

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp

import coil.compose.AsyncImage
import coil.request.ImageRequest


import com.example.projectmyindonesia.R
import com.example.projectmyindonesia.data.MenuType
import com.example.projectmyindonesia.data.model.Data

@Composable
fun DetailsScreen(
    uiState: PlaceUiState,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    isFullScreen: Boolean = false
){
    BackHandler{
        onBackPressed()
    }

    LazyColumn(
        modifier = modifier
            .testTag(stringResource(R.string.details_screen))
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inverseOnSurface)
            .padding(top = 24.dp)
    ){
        item{
            if(isFullScreen){
                DetailsScreenTopBar(onBackPressed, uiState)
            }
            Box{
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(uiState.currentSelectedData.imgResourceTempatWisata)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.ic_image),
                    error = painterResource(id = R.drawable.ic_error),
                    contentDescription = stringResource(id = R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.DarkGray),
                                startY = size.height / 3,
                                endY = size.height
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        }
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ){
                    Text(
                        text = stringResource(uiState.currentSelectedData.judulTempatWisata),
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                }

            }
            DetailsCard(
                data = uiState.currentSelectedData,
                menuType = uiState.currentMenu,
                isFullScreen = isFullScreen,
                modifier = if(isFullScreen)
                    Modifier.padding(horizontal = 16.dp)
                else
                    Modifier.padding(end = 16.dp)

            )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsCard(
    data: Data,
    menuType: MenuType,
    isFullScreen: Boolean = false,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    val displayToast = { text: String->
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    if(isFullScreen){
        Column(modifier = Modifier.fillMaxWidth()){
            DescriptionCard(
                data = data,
                isFullScreen = isFullScreen,
                modifier = Modifier.padding(16.dp)
            )

        }
    }else{
        Row(modifier = Modifier.fillMaxWidth()){
            DescriptionCard(
                data = data,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                isFullScreen = isFullScreen
            )
        }
    }
}

@Composable
private fun DetailsScreenTopBar(
    onBackButtonClicked: () -> Unit,
    uiState: PlaceUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
     IconButton(
         onClick = onBackButtonClicked,
         modifier = Modifier
             .padding(horizontal = 16.dp)
             .background(MaterialTheme.colorScheme.surface, shape = CircleShape)
     )   {
         Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(id = R.string.navigation_back))
     }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 40.dp)){
            Text(
                text = stringResource(uiState.currentSelectedData.judulTempatWisata),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


@Composable
fun DescriptionCard(
    data: Data,
    isFullScreen: Boolean = false,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(id = R.string.description)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ){
                if(!isFullScreen){
                    Text(
                        text = stringResource(data.judulTempatWisata),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.padding(top = 12.dp,bottom = 8.dp)
                    )
                }else{
                    Spacer(modifier = Modifier.height(12.dp))

                }
                Text(
                    text = stringResource(data.deskripsiTempatWisata),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
