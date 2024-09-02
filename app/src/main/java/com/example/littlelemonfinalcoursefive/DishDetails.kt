package com.example.littlelemonfinalcoursefive

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonfinalcoursefive.data.DishRepository
import com.example.littlelemonfinalcoursefive.ui.theme.MyTypography

@Composable
fun DishDetails(id: Int) {

    val dish = requireNotNull(DishRepository.getDish(id))

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TopAppBar()
        Image(
            painter = painterResource(id = dish.image),
            contentDescription = dish.title,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {

            Text(
                text = dish.title,
                style = MyTypography.titleLarge,
                fontSize = 70.sp
            )

            Text(
                text = dish.description,
                style = MyTypography.bodyLarge,
                fontSize = 28.sp
            )
            Counter()
        }

    }


}

@Composable
fun Counter() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        var counter by remember {
            mutableStateOf(1)
        }

        TextButton(onClick = {
            counter--
        }) {
            Text(text = "-", style = MyTypography.bodyMedium, fontSize = 42.sp)
        }

        Text(
            text = counter.toString(),
            style = MyTypography.bodyMedium,
            modifier = Modifier.padding(16.dp), fontSize = 42.sp
        )

        TextButton(onClick = { counter++ }) {
            Text(text = "+", style = MyTypography.bodyMedium, fontSize = 35.sp)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun dishPrevies() {
    DishDetails(id = 1)
}