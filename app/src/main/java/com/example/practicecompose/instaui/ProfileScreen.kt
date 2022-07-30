package com.example.practicecompose.instaui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose.R

@Composable
fun ProfileScreen() {
    TopBar()
    Spacer(modifier = Modifier.height(16.dp))
    ProfileInfo()
    Spacer(modifier = Modifier.height(16.dp))
    ButtonSection(modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(16.dp))
    HighLightSection()
    Spacer(modifier = Modifier.height(16.dp))
    PostTabView(onTabSelected = {

    })
}

@Composable
fun TopBar() {

    Row(modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = null, tint = Color.Black,
        modifier = Modifier.size(32.dp))

        Text(text = "Anik Dey Profile", style = MaterialTheme.typography.h5,
            color = Color.Black, overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp, end = 16.dp))

        Icon(painter = painterResource(id = R.drawable.ic_notifications), contentDescription = null, tint = Color.Black,
        modifier = Modifier.size(32.dp))
        
        Spacer(modifier = Modifier.width(16.dp))

        Icon(painter = painterResource(id = R.drawable.ic_more), contentDescription = null, tint = Color.Black,
        modifier = Modifier.size(32.dp))
    }

}

@Composable
fun ProfileInfo() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            RoundImage(image = painterResource(id = R.drawable.ic_launcher_background), modifier = Modifier
                .size(100.dp)
                .weight(0.3f))
            Spacer(modifier = Modifier.width(16.dp))
            Row(modifier = Modifier.weight(0.7f),
                horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                ProfileInfoCol(number = "601", str = "Posts")
                ProfileInfoCol(number = "99.8k", str = "Followers")
                ProfileInfoCol(number = "72", str = "Following")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        ProfileDescription(name = "Anik Dey", description = "Demo text here", url = "www.youtube.com", 50)
    }

}

@Composable
fun RoundImage(image: Painter, modifier: Modifier = Modifier) {
    Image(painter = image, contentDescription = null, modifier = modifier
        .aspectRatio(
            1f, matchHeightConstraintsFirst = true
        )
        .border(1.dp, color = Color.LightGray, shape = CircleShape)
        .padding(3.dp)
        .clip(CircleShape))
}

@Composable
fun ProfileInfoCol(number: String, str: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = number, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h5, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = str)
    }
}

@Composable
fun ProfileDescription(name: String, description: String, url: String, followedBy: Int = 0) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name, color = Color.Black, fontWeight = Bold, letterSpacing = letterSpacing, lineHeight = lineHeight)
        Text(text = description, color = Color.Black, letterSpacing = letterSpacing, lineHeight = lineHeight)
        Text(text = url, color = Color.LightGray, letterSpacing = letterSpacing, lineHeight = lineHeight)
        if(followedBy>0) {
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(color = Color.Black, fontWeight = Bold, fontSize = 16.sp)
                append("Followed by ")
                pushStyle(boldStyle)
                append("anik dey")
                pop()
                append(",")
                pushStyle(boldStyle)
                append(" another user")
                pop()
                append(" and ")
                pushStyle(boldStyle)
                append("$followedBy")
            }, letterSpacing = letterSpacing, lineHeight = lineHeight)
        }
    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 90.dp
    val height = 30.dp
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier){
        ActionButton(
            Modifier
                .defaultMinSize(minWidth)
                .height(height), "Following", Icons.Default.KeyboardArrowDown)
        ActionButton(
            Modifier
                .defaultMinSize(minWidth)
                .height(height), "Message")
        ActionButton(
            Modifier
                .defaultMinSize(minWidth)
                .height(height), "Email")
        ActionButton(Modifier.height(height), null, Icons.Default.KeyboardArrowDown)
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .padding(5.dp)
    ) {
        text?.let { 
            Text(text = text, fontWeight = SemiBold, fontSize = 14.sp)
        }

        icon?.let {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }
    }
}

@Composable
fun HighLightSection() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        HighLightItem("YouTube")
        HighLightItem("Q&A")
        HighLightItem("Discord")
        HighLightItem("Telegram")
    }
}

@Composable
fun HighLightItem(str: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        RoundImage(image = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier.size(65.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = str)
    }
}

@Composable
fun PostTabView(modifier: Modifier = Modifier, onTabSelected: (selectedIndex: Int) -> Unit) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(selectedTabIndex = selectedTabIndex,
    backgroundColor = Color.Transparent,
    contentColor = Color.Black,
    modifier = modifier) {
        Tab(selected = selectedTabIndex == 0, onClick = {
            selectedTabIndex = 0
            onTabSelected(0)
        },
        selectedContentColor = Color.Black,
        unselectedContentColor = inactiveColor) {
            Icon(painter = painterResource(id = R.drawable.ic_notifications), contentDescription = null,
            tint = if(selectedTabIndex == 0) Color.Black else inactiveColor,
                modifier = Modifier.padding(10.dp).size(20.dp)
            )
        }
    }

}