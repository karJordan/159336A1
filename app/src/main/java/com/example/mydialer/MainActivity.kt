package com.example.mydialer

import android.Manifest
import android.content.Intent
import android.graphics.drawable.Drawable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.mydialer.ui.theme.MyDIalerTheme
import com.example.mydialer.ui.theme.Typography
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val number = "tel:777"
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                val dial = Intent(Intent.ACTION_CALL, number.toUri())
            }

        }.launch(Manifest.permission.CALL_PHONE)
        setContent {

            MyDIalerTheme {
                Dialer()

            }
        }
    }
}


@Composable
fun DialButton(
    main: String,
    sub: String? = null,
    icon: Painter? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dButtonModifier = Modifier
        .fillMaxHeight()
    Button(
        onClick = onClick,
        modifier = modifier.then(dButtonModifier)
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
    left: @Composable () -> Unit,
    middle: @Composable () -> Unit,
    right: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(80.dp),
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
                Box(Modifier.fillMaxSize()) {
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
                            .clickable{
                                if (number.isNotEmpty()) number = number.dropLast(1)
                            }
                    )
                }
            }
            HorizontalDivider()

            DialerRow(
                left = {
                    DialButton(
                        main = "1",
                        icon = mailIcon,
                        onClick = {number += "1"},
                        modifier = Modifier.weight(1f)
                    )
                },
                middle = {
                    DialButton(
                        main = "2",
                        sub = "ABC",
                        onClick = {number +="2"},
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "3",
                        sub = "DEF",
                        onClick = {number += "3"},
                        modifier = Modifier.weight(1f)
                    )
                })
            DialerRow(
                left = {
                    DialButton(
                        main = "4",
                        sub = "GHI",
                        onClick = {number +="4"},
                        modifier = Modifier.weight(1f)
                    )
                },
                middle = {
                    DialButton(
                        main = "5",
                        sub = "JKL",
                        onClick = {number +="5"},
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "6",
                        sub = "MNO",
                        onClick = {number +="6"},
                        modifier = Modifier.weight(1f)
                    )
                })
            DialerRow(
                left = {
                    DialButton(
                        main = "7",
                        sub = "PQRS",
                        onClick = {number +="7"},
                        modifier = Modifier.weight(1f)
                    )
                },
                middle = {
                    DialButton(
                        main = "8",
                        sub = "TUV",
                        onClick = {number +="8"},
                        modifier = Modifier.weight(1f)
                    )
                },
                right = {
                    DialButton(
                        main = "9",
                        sub = "WXYZ",
                        onClick = {number +="9"},
                        modifier = Modifier.weight(1f)
                    )
                })
            DialerRow(
                left = { DialButton(main = "*", onClick = {}, modifier = Modifier.weight(1f)) },
                middle = {
                    DialButton(
                        main = "0",
                        sub = "+",
                        onClick = {number +="0"},
                        modifier = Modifier.weight(1f)
                    )
                },
                right = { DialButton(main = "#", onClick = {}, modifier = Modifier.weight(1f)) })

            Spacer(Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {},
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
}


