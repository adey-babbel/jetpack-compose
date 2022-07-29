package com.example.practicecompose.meditationui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose.R
import com.example.practicecompose.bottomnav.BottomNavItem
import com.example.practicecompose.ui.theme.*

@Composable
fun HomeScreen() {

    Box(modifier = Modifier
        .background(DeepBlue)
        .padding(16.dp)
        .fillMaxSize()) {
        Column {
            Greeting("Anik Dey")
            Spacer(modifier = Modifier.height(16.dp))
            ChipSection(list = listOf("Sweet Sleep", "Insomnia", "Depression"))
            Spacer(modifier = Modifier.height(16.dp))
            CurrentlyPlaying()
            Spacer(modifier = Modifier.height(32.dp))
            FeaturedSection(features)
        }
        BottomNavMenu(items = listOf(
            BottomNavItem.Home,
            BottomNavItem.MyNetwork,
            BottomNavItem.AddPost,
            BottomNavItem.Notification,
            BottomNavItem.Jobs
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }



}

@Composable
fun Greeting(name: String = "Anik Dey") {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            //.padding(16.dp)
    ){
        Column() {
            Text(text = "Good Morning $name", color = TextWhite, style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "We wish you a good day!", color = TextWhite, style = MaterialTheme.typography.body1)
        }
        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "search", tint = Color.White)
    }
}

@Composable
fun ChipSection(list: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(list.size) {
            Box(modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (selectedChipIndex == it) ButtonBlue
                    else DarkerButtonBlue
                )
                .padding(15.dp), contentAlignment = Alignment.Center) {
                Text(text = list[it], color = Color.White)
            }
        }
    }
}

@Composable
fun CurrentlyPlaying(color: Color = LightRed) {
    Row(
        modifier = Modifier
            //.padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(text = "Daily Thought", color = TextWhite, style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Meditation * 2-10 min", color = TextWhite, style = MaterialTheme.typography.body1)
        }
        Box(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(ButtonBlue)
            .padding(10.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "play", tint = Color.White, modifier = Modifier.size(20.dp
            ))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedSection(featuresList : List<Feature>) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Featured", color = TextWhite, style = MaterialTheme.typography.h5)
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxHeight()) {
            items(featuresList.size) {
                Feature(feature = featuresList[it])
            }
        }
    }

}

@Composable
fun Feature(feature: Feature) {
 BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
     val width = constraints.maxWidth
     val height = constraints.maxHeight

     // Medium colored path
     val mediumColoredPoint1 = Offset(0f, height * 0.3f)
     val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
     val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
     val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
     val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

     val mediumColoredPath = Path().apply {
         moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
         standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
         standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
         standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
         standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
         lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
         lineTo(-100f, height.toFloat() + 100f)
         close()
     }

     // Light colored path
     val lightPoint1 = Offset(0f, height * 0.35f)
     val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
     val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
     val lightPoint4 = Offset(width * 0.65f, height.toFloat())
     val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

     val lightColoredPath = Path().apply {
         moveTo(lightPoint1.x, lightPoint1.y)
         standardQuadFromTo(lightPoint1, lightPoint2)
         standardQuadFromTo(lightPoint2, lightPoint3)
         standardQuadFromTo(lightPoint3, lightPoint4)
         standardQuadFromTo(lightPoint4, lightPoint5)
         lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
         lineTo(-100f, height.toFloat() + 100f)
         close()
     }
     Canvas(
         modifier = Modifier
             .fillMaxSize()
     ) {
         drawPath(
             path = mediumColoredPath,
             color = feature.mediumColor
         )
         drawPath(
             path = lightColoredPath,
             color = feature.lightColor
         )
     }

     Box(modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)) {
         Text(text = feature.title, color = TextWhite, style = MaterialTheme.typography.h5, lineHeight = 24.sp,
             modifier = Modifier.align(Alignment.TopStart))

         Icon(painter = painterResource(id = feature.iconId), contentDescription = null, tint = Color.White,
             modifier = Modifier.align(Alignment.BottomStart))

         Text(text = "Start", color = TextWhite, fontWeight = FontWeight.Bold, fontSize = 14.sp,
             modifier = Modifier
                 .align(Alignment.BottomEnd)
                 .clip(RoundedCornerShape(8.dp))
                 .background(ButtonBlue)
                 .padding(vertical = 10.dp, horizontal = 16.dp)
                 .clickable {

                 })
     }

        /*Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }*/


    }

}/**/
