package com.example.devoptima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devoptima.ui.theme.DevOptimaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevOptimaTheme {
                // A surface container using the 'background' color from the theme
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(top = 100.dp, start = 12.dp)
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 12.dp, vertical = 100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(100.dp),
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = "logo"
                            )
                        }
                    }
                    items(customColumns.size) { index ->
                        val columnData = customColumns[index]
                        CustomColumn(
                            title = columnData.title,
                            dataValue = columnData.dataValue,
                            showDivider = columnData.showDivider
                        )
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 12.dp, vertical = 100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(100.dp),
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = "logo"
                            )
                        }
                    }
                }
            }
        }
    }
}


val customColumns = listOf(
    CustomColumnData("Дата и время", "06 мар 2023 12:23"),
    CustomColumnData("Квитанция", "KGTP33966736/106072196143646"),
    CustomColumnData("С карты", "5429"),
    CustomColumnData("С карты", "5429"),
    CustomColumnData("С карты", "5429"),
    CustomColumnData("С карты", "5429"),
    CustomColumnData("С карты", "5429"),
    CustomColumnData("Поставщик услуг", "МЕГА"),
    CustomColumnData("Реквизиты", "555 537 398"),
    CustomColumnData("Сумма", "10 000,00 KGS"),
    CustomColumnData("Комиссия", "0,00 KGS"),
    CustomColumnData("Сумма с учетом комиссии", "10 000,00", false)
)

data class CustomColumnData(
    val title: String,
    val dataValue: String,
    val showDivider: Boolean = true
)

@Composable
fun CustomColumn(title: String, dataValue: String, showDivider: Boolean = true) {
    Column {
        Text(text = title, fontSize = 12.sp)
        Text(
            modifier = Modifier.padding(),
            text = dataValue,
            color = Color.Black,
            fontSize = 16.sp
        )
        if (showDivider) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 8.5.dp, bottom = 8.5.dp)
            )
        }
    }
}