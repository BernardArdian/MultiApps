package com.example.multiapps.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.multiapps.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            MainPage(
                                modifier = Modifier
                                    .clickable {
                                        Toast.makeText(context,Greeting().greet(),Toast.LENGTH_SHORT).show()
                                    },
                                text = Greeting().greet()
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainPage(
    modifier:Modifier,
    text: String
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        content = {
            items(
                count = 5,
                itemContent = {
                    Text(
                        modifier = modifier,
                        text = text
                    )
                }
            )
        }
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
