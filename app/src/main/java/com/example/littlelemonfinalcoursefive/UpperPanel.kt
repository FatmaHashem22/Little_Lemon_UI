package com.example.littlelemonfinalcoursefive

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonfinalcoursefive.ui.theme.LittleLemonColor
import com.example.littlelemonfinalcoursefive.ui.theme.MyTypography

@Preview(showBackground = true)
@Composable
fun UpperPanel() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonColor.green)
            .padding(vertical = 16.dp, horizontal = 12.dp)
    ) {

        Text(
            text = stringResource(R.string.title),
            color = LittleLemonColor.yellow,
            style = MyTypography.titleLarge,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.location),
            color = LittleLemonColor.cloud,
            style = MyTypography.titleMedium,
            fontSize = 24.sp
        )

        Row(
            modifier = Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.description),
                color = LittleLemonColor.cloud,
                fontSize = 18.sp,
                style = MyTypography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth(0.6F)
                    .padding(bottom = 20.dp, end = 20.dp)

            )

            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(LittleLemonColor.yellow)
        ) {

            Text(
                text = stringResource(R.string.order_button_text),
                style = MyTypography.labelLarge,
                color = LittleLemonColor.green
            )


        }


    }
}