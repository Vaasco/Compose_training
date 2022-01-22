// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*



fun main() = singleWindowApplication(
    title = "Compose training",
    state = WindowState(position = WindowPosition(Alignment.Center), width = Dp.Unspecified, height = Dp.Unspecified)
) {
    MaterialTheme {
        Column(modifier = Modifier.padding(30.dp), verticalArrangement = Arrangement.Center){
            var value by remember { mutableStateOf(5) }
            Text("value = $value")
            Spacer(modifier = Modifier.height(10.dp))
            NumberEdit(Modifier.background(Color.LightGray), init = value, range = 1..10) { value = it }
        }



    }
}

@Composable
@Preview
fun NumberEdit(modifier: Modifier, init: Int = 0, range: IntRange, onNumberChange: (Int) -> Unit) {
    Row(modifier = modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = {onNumberChange(init-1)}, enabled = init>range.first) {
           Text("-")
        }
        Text("$init", style = MaterialTheme.typography.h5,modifier=Modifier.padding(2.dp))
        Button(onClick = {onNumberChange(init+1)}, enabled = init<range.last) {
           Text("+")
        }
    }
}
