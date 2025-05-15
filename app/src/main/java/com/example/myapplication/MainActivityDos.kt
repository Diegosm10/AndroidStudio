package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivityDos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                InputComponentsScreen()
            }
        }
    }
}

@Composable
fun InputComponentsScreen() {
    // Estados para cada componente de input
    var textFieldValue by remember { mutableStateOf("") }
    var outlinedTextFieldValue by remember { mutableStateOf("") }
    var checkboxState by remember { mutableStateOf(false) }
    var switchState by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(50f) }
    var selectedRadio by remember { mutableStateOf("") }
    val context = LocalContext.current
    var red by remember { mutableStateOf(255f) }
    var green by remember { mutableStateOf(255f) }
    var blue by remember { mutableStateOf(255f) }
    val backgroundColorSwitch = Color(red.toInt(), green.toInt(), blue.toInt())
    var isDarkMode by remember { mutableStateOf(false) }
    val backgroudColor = if (isDarkMode) Color.Black else Color.White
    val textColor = if (isDarkMode) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroudColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("TextField") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = outlinedTextFieldValue,
            onValueChange = { outlinedTextFieldValue = it },
            label = { Text("OutlinedTextField") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkboxState,
                onCheckedChange = { checkboxState = it }
            )
            Text("Aceptar términos y condiciones", color = textColor)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = switchState,
                onCheckedChange = { switchState = it }
            )
            Text("Switch", color = textColor)
        }

        Column(
            modifier = Modifier
                //.fillMaxSize()
                .background(backgroundColorSwitch)
                .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Selecciona el color",
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
                )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Rojo: ${red.toInt()}",
                color = textColor
            )
            Slider(
                value = red,
                onValueChange = { red = it },
                valueRange = 0f..255f,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Verde: ${green.toInt()}",
                color = textColor
            )
            Slider(
                value = green,
                onValueChange = { green = it },
                valueRange = 0f..255f,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Azul: ${blue.toInt()}",
                color = textColor
            )
            Slider(
                value = blue,
                onValueChange = { blue = it },
                valueRange = 0f..255f,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text(
            text = "Seleccione el modo de color:",
            color = textColor,
            style = MaterialTheme.typography.bodyLarge
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !isDarkMode,
                onClick = { isDarkMode = false }
            )
            Text("Modo Claro", color = textColor)
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = isDarkMode,
                onClick = { isDarkMode = true }
            )
            Text("Modo Oscuro", color = textColor)
        }
        Button(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        }) {
            Text("Volver a Componentes Básicos", color = textColor)
        }
    }
}