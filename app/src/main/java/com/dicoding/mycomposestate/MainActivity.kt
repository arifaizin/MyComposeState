package com.dicoding.mycomposestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.mycomposestate.ui.theme.MyComposeStateTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    FormInput()
                }
            }
        }
    }
}

@Composable
fun FormInput() {
//    val name = remember { mutableStateOf("") } //state
//    OutlinedTextField(
//        value = name.value, //display state
//        onValueChange = { newName -> //event
//            name.value = newName //update state
//        },
//        label = { Text("Nama") },
//        modifier = Modifier.padding(8.dp)
//    )
    var name by rememberSaveable { mutableStateOf("") } //state
    OutlinedTextField(
        value = name, //display state
        onValueChange = { newName -> //event
            name = newName //update state
        },
        label = { Text("Nama") },
        modifier = Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeStateTheme {
        FormInput()
    }
}

@Composable
fun StatefulCounter() {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onClick = { count++ },
    )
}

@Composable
fun StatelessCounter(count: Int, onClick : (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Button clicked $count times:")
        Button(onClick = { onClick }) {
            Text("Click me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MyComposeStateTheme {
        StatefulCounter()
    }
}