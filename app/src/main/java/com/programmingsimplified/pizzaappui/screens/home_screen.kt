package com.programmingsimplified.pizzaappui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.pizzaappui.commonui.CommonIconFromDrawable
import com.programmingsimplified.pizzaappui.ui.theme.BackgroundColor
import  com.programmingsimplified.pizzaappui.R
import com.programmingsimplified.pizzaappui.commonui.SpacerWidth
import com.programmingsimplified.pizzaappui.ui.theme.DarkBlackColor
import com.programmingsimplified.pizzaappui.ui.theme.YellowColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val menuList =
        listOf("Starter", "Asian", "Placha & Roast & Grill", "Classic", "Indian", "Italian")
    val scrollState = rememberScrollState()
    var menuState by remember { mutableStateOf("Starter") }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(text = {
                Row {
                    Text(
                        text = "£60.40", style = TextStyle(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.White
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                }
            }, onClick = {

            }, backgroundColor = DarkBlackColor,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.pizza),
                        contentDescription = "",
                        modifier = Modifier.size(42.dp),
                        tint = Color.Unspecified
                    )
                }
            )
        }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg), contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(70.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            CommonIconFromDrawable(icon = R.drawable.menu)
                            SpacerWidth()
                            Text(
                                text = "JKM Resto",
                                style = TextStyle(
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.W600,
                                    color = Color.White
                                )
                            )
                        }
                        CommonIconFromDrawable(icon = R.drawable.search)
                    }
                }
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 1.dp
                ) {
                    Row(
                        modifier = Modifier.horizontalScroll(scrollState)
                    ) {
                        menuList.forEach {
                            MenuItems(menuName = it, selected = it == menuState) {
                                menuState = it
                            }
                        }
                    }
                }

            }

        }

    }

}

@Composable
fun MenuItems(
    menuName: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onValueUpdate: (String) -> Unit
) {

    Card(
        shape = RoundedCornerShape(200.dp),
        elevation = 0.dp,
        backgroundColor = if (selected) YellowColor else Color.Transparent,
        modifier = modifier
            .padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
            onValueUpdate(menuName)
        }) {
            Text(
                text = menuName, style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = if (selected) Color.White else DarkBlackColor
                ),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
        }
    }

}

@Composable
fun ExtendedActionButton() {

}