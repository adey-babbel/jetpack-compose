package com.example.practicecompose.meditationui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practicecompose.bottomnav.BottomNavItem
import com.example.practicecompose.ui.theme.AquaBlue
import com.example.practicecompose.ui.theme.ButtonBlue
import com.example.practicecompose.ui.theme.DeepBlue

@Composable
fun BottomNavMenu(
    items: List<BottomNavItem>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
    ) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    
    Row(horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .fillMaxWidth()
            .background(
                DeepBlue
            ).padding(top = 16.dp)) {
        items.forEachIndexed{index, item ->
            BottomMenuItem(item = item, isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor, activeTextColor = activeTextColor
                , inactiveTextColor = inactiveTextColor) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(item:BottomNavItem,
                   isSelected: Boolean = false,
                   activeHighlightColor: Color = ButtonBlue,
                   activeTextColor: Color = Color.White,
                   inactiveTextColor: Color = AquaBlue,
                   onItemClick: (BottomNavItem) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.clickable {
        onItemClick(item)
    }) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) activeHighlightColor else Color.Transparent)
            .padding(8.dp)){
            Icon(painter = painterResource(id = item.icon), contentDescription = item.title, tint =
            if(isSelected) activeTextColor else inactiveTextColor, modifier = Modifier.size(20.dp))
        }
        Text(text = item.title, color = if(isSelected) activeTextColor else inactiveTextColor)
    }
}