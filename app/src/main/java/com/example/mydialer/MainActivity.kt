package com.example.mydialer

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import com.example.mydialer.ui.theme.MyDIalerTheme
import com.example.mydialer.ui.theme.Typography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                val dial = Intent(Intent.ACTION_CALL)

            }

        }.launch(Manifest.permission.CALL_PHONE)
        setContent {

            MyDIalerTheme {
                Dialer()

            }
        }
    }
}

fun placeCall(context: Context, number: String){
    val intent = Intent()
}

@Composable
fun DialButton(
    main: String,
    sub: String? = null,
    icon: Painter? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxHeight()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = main,
                color = Color.White,
                style = Typography.headlineLarge
            )
            if (icon != null) {
                Spacer(Modifier.height(2.dp))
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            } else if (!sub.isNullOrBlank()) {
                Spacer(Modifier.height(2.dp))
                Text(text = sub)
            }
        }
    }
}


@Composable
fun DialerRow(
    left: @Composable RowScope.() -> Unit,
    middle: @Composable RowScope.() -> Unit,
    right: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        left()
        Spacer(Modifier.width(8.dp))
        middle()
        Spacer(Modifier.width(8.dp))
        right()
    }

}


@Preview(showBackground = true)
@Composable
fun Dialer() {
    var number by rememberSaveable { mutableStateOf("") }
    val backIcon = painterResource(id = R.drawable.backspace_24dp_1f1f1f_fill0_wght400_grad0_opsz24)
    val callIcon = painterResource(id = R.drawable.call_24dp_1f1f1f_fill0_wght400_grad0_opsz24)
    val mailIcon = painterResource(id = R.drawable.voicemail_24dp_1f1f1f_fill0_wght400_grad0_opsz24)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8EEF1))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        HorizontalDivider()


        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = number.ifEmpty { " " },
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black,
                fontSize = 58.sp,
                style = Typography.headlineLarge

            )
            Icon(
                painter = backIcon,
                contentDescription = "Delete",
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        if (number.isNotEmpty()) number = number.dropLast(1)
                    }
            )
        }

        HorizontalDivider()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            DialerRow(
                left = {
                    DialButton(
                        main = "1",
                        icon = mailIcon,
                        onClick = { number += "1" },
                        modifier = Modifier.weight(1f)
                    )
                },
                middle = {
                    DialButton(
                        main = "2",
                        sub = "ABC",
                        onClick = { number += "2" },
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "3",
                        sub = "DEF",
                        onClick = { number += "3" },
                        modifier = Modifier.weight(1f)
                    )
                },
                modifier = Modifier.weight(1f))
            DialerRow(
                left = {
                    DialButton(
                        main = "4",
                        sub = "GHI",
                        onClick = { number += "4" },
                        modifier = Modifier.weight(1f)
                    )
                },
                middle = {
                    DialButton(
                        main = "5",
                        sub = "JKL",
                        onClick = { number += "5" },
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "6",
                        sub = "MNO",
                        onClick = { number += "6" },
                        modifier = Modifier.weight(1f)
                    )
                },
                modifier = Modifier.weight(1f))
            DialerRow(
                left = {
                    DialButton(
                        main = "7",
                        sub = "PQRS",
                        onClick = { number += "7" },
                        modifier = Modifier.weight(1f)
                    )
                },
                middle = {
                    DialButton(
                        main = "8",
                        sub = "TUV",
                        onClick = { number += "8" },
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "9",
                        sub = "WXYZ",
                        onClick = { number += "9" },
                        modifier = Modifier.weight(1f)
                    )
                },
                modifier = Modifier.weight(1f))
            DialerRow(
                left = { DialButton(main = "*", onClick = {}, modifier = Modifier.weight(1f)) },
                middle = {
                    DialButton(
                        main = "0",
                        sub = "+",
                        onClick = { number += "0" },
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "#",
                        onClick = {},
                        modifier = Modifier.weight(1f)
                    )
                },
                modifier = Modifier.weight(1f))


        }

        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {/*place call*/},
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF04650A),
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = callIcon,
                    contentDescription = "Call Icon",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "CALL",
                    modifier = Modifier,
                    style = Typography.headlineLarge
                )
            }
        }
    }
}


