package com.programmingsimplified.pizzaappui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.pizzaappui.commonui.CommonIconFromDrawable
import  com.programmingsimplified.pizzaappui.R
import com.programmingsimplified.pizzaappui.commonui.SpacerHeight
import com.programmingsimplified.pizzaappui.commonui.SpacerWidth
import com.programmingsimplified.pizzaappui.data.Pizza
import com.programmingsimplified.pizzaappui.data.pizzaList
import com.programmingsimplified.pizzaappui.ui.theme.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val menuList =
        listOf("Starter", "Asian", "Placha & Roast & Grill", "Classic", "Indian", "Italian")
    val scrollState = rememberScrollState()
    var menuState by remember { mutableStateOf("Starter") }
    val pizzaList = pizzaList

    Scaffold(
        floatingActionButton = {
            ExtendedActionButton()
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
                        .background(RedColor)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                            .align(Center),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            CommonIconFromDrawable(icon = R.drawable.menu)
                            SpacerWidth()
                            Text(
                                text = stringResource(R.string.username),
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

                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(pizzaList) {
                        ShowPizza(pizza = it)
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

    TextButton(
        onClick = { onValueUpdate(menuName) },
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) YellowColor else Color.Transparent
        ),
        shape = RoundedCornerShape(200.dp),
        modifier = modifier
            .padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Text(
            text = menuName,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = if (selected) Color.White else DarkBlackColor
            ),
        )
    }

}

@Composable
fun ShowPizza(
    pizza: Pizza
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .width(175.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = pizza.image), contentDescription = "",
                    modifier = Modifier.size(109.dp)
                )
                SpacerHeight(5.dp)
                Text(
                    text = pizza.price, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = RedColor
                    ),
                    textAlign = TextAlign.Center
                )
                SpacerHeight(5.dp)
                Text(
                    text = pizza.name, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = DarkBlackColor
                    ),
                    textAlign = TextAlign.Center
                )
                SpacerHeight(5.dp)
                Text(
                    text = pizza.description, style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W300,
                        color = LightGrayColor
                    ),
                    textAlign = TextAlign.Center
                )
                SpacerHeight(5.dp)
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(91.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = YellowColor
                    )
                ) {
                    Text(
                        text = stringResource(R.string.add), style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.White
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}

@Composable
fun ExtendedActionButton() {

    Card(
        shape = RoundedCornerShape(27.dp),
        backgroundColor = DarkBlackColor,
        modifier = Modifier.height(48.dp)
    ) {

        Row {
            SpacerWidth(20.dp)
            Text(
                text = stringResource(R.string.price), style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                ),
                modifier = Modifier.align(CenterVertically)
            )
            SpacerWidth()
            Icon(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "",
                modifier = Modifier
                    .size(46.dp)
                    .padding(2.dp),
                tint = Color.Unspecified
            )
        }

    }

}