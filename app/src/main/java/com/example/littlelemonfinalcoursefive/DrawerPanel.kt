package com.example.littlelemonfinalcoursefive

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerPanel(scaffoldState: ScaffoldState? = null, coroutineScope: CoroutineScope? = null) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = {
            coroutineScope?.launch { scaffoldState?.drawerState?.close() }
        }) {

            Icon(imageVector = Icons.Default.Close, contentDescription = "Exit")

        }

    }
    List(10) {
        Text(
            text = "item #$it",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp
            )
        )
    }
    

}