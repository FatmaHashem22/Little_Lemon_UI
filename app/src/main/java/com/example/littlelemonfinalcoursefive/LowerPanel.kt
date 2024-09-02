package com.example.littlelemonfinalcoursefive

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.littlelemonfinalcoursefive.ui.theme.MyTypography
import com.example.littlelemonfinalcoursefive.data.Categories
import com.example.littlelemonfinalcoursefive.data.Dish
import com.example.littlelemonfinalcoursefive.data.DishRepository.dishes
import com.example.littlelemonfinalcoursefive.ui.theme.LittleLemonColor


@Composable
fun LowerPanel(navController: NavController, dishes: List<Dish> = listOf()) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        WeeklySpecials()
        Categories()
        Divider(
            modifier = Modifier.padding(12.dp),
            thickness = 1.dp,
            color = LittleLemonColor.yellow
        )
        MenuDishes(navController, dishes)
    }

}

@Composable
fun WeeklySpecials() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Weekly Specials",
            style = MyTypography.titleMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

    }
}

@Composable
fun Categories() {

    LazyRow(
        state = rememberLazyListState(),
        content = {
            items(Categories) { category ->
                CategoryItem(category = category)
            }

        })

}

@Composable
fun CategoryItem(category: String) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(LittleLemonColor.cloud),
        modifier = Modifier.padding(5.dp)
    ) {

        Text(
            text = category,
            style = MyTypography.labelLarge,
            color = LittleLemonColor.charcoal
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDishes(navController: NavController, dishes: List<Dish> = listOf()) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = rememberLazyListState(),
        content = {
            itemsIndexed(dishes) { _, dish ->
                MenuItem(navController, dish)
            }
        })

}

@ExperimentalMaterial3Api
@Composable
fun MenuItem(navController: NavController, dish: Dish) {
    Card(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        onClick = {
            navController?.navigate(DishDetails.route + "/${dish.id}")
        }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Column {

                Text(
                    text = dish.title,
                    style = MyTypography.titleMedium,
                    fontSize = 18.sp,
                    color = LittleLemonColor.charcoal,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = dish.description,
                    style = MyTypography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.75F)
                        .padding(vertical = 5.dp)
                )


                Text(
                    text = "$${dish.price}",
                    style = MyTypography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

            }

            Image(
                painter = painterResource(id = dish.image),
                contentDescription = "Dish Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.CenterVertically)
                    .padding(start = 2.dp)
            )

        }

    }

}