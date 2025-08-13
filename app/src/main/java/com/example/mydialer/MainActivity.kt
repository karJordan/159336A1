package com.example.mydialer

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.example.mydialer.ui.theme.MyDIalerTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Typography
import androidx.compose.ui.Alignment
import com.example.mydialer.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val number = "tel:777"
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                val dial = Intent(Intent.ACTION_CALL, number.toUri())
                startActivity(dial)
            }

        }.launch(Manifest.permission.CALL_PHONE)
        /*setContent {
            MyDIalerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Android",
                        modifier = Modifie.padding(innerPadding)
                    )*/
                }
            }
        }*/
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyDIalerTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun Dialer() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8EEF1))
            .padding(16.dp)
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalDivider()
            Row(
                Modifier.height(200.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "test",
                    modifier = Modifier,
                    color = Color.Black,
                    style = Typography.headlineLarge

                )
            }
            HorizontalDivider()
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(80.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "1",
                        modifier = Modifier,
                        color = Color.White,
                        style = Typography.headlineLarge
                    )
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "2",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "ABC"
                        )
                    }

                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "3",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "DEF"
                        )
                    }
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(80.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "4",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "GHI"
                        )
                    }
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "5",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "JKL"
                        )
                    }

                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "6",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "MNO"
                        )
                    }
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(80.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "7",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "PQRS"
                        )
                    }
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "8",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "TUV"
                        )
                    }

                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "9",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "WXYZ"
                        )
                    }
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(80.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "*",
                        modifier = Modifier,
                        color = Color.White,
                        style = Typography.headlineLarge
                    )
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column() {
                        Text(
                            text = "0",
                            modifier = Modifier,
                            color = Color.White,
                            style = Typography.headlineLarge
                        )
                        Text(
                            text = "+"
                        )
                    }

                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "#",
                        modifier = Modifier,
                        color = Color.White,
                        style = Typography.headlineLarge
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(130.dp),
                contentAlignment = Alignment.Center
            ){
                Button(
                    onClick = {},
                    modifier = Modifier.width(200.dp).fillMaxHeight(),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = Color(0xFF04650A),
                       contentColor = Color.White
                   )


                ){
                    Text(
                        text = "CALL",
                        modifier = Modifier,
                        style = Typography.headlineLarge
                    )
                }
            }


        }
    }
}


