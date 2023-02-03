package com.programmingsimplified.pizzaappui.commonui


import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
@SuppressLint("ModifierParameter")
fun CommonIconFromDrawable(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    onClick:()->Unit={}
) {
    IconButton(onClick = {onClick() }, modifier = modifier.size(28.dp)) {
        Icon(
            painter = painterResource(id = icon), contentDescription = "",
            tint = tint
        )
    }
}


@Composable
@SuppressLint("ModifierParameter")
fun CommonIconFromVector(
    icon: ImageVector,
    tint: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = { }, modifier = modifier.size(28.dp)) {
        Icon(
            imageVector = icon, contentDescription = "",
            tint = tint
        )
    }
}

@Composable
fun SpacerHeight(
    height:Dp = 10.dp
) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(
    width:Dp = 10.dp
) {
    Spacer(modifier = Modifier.width(width))
}