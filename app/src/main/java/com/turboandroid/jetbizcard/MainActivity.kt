package com.turboandroid.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.turboandroid.jetbizcard.ui.theme.JetBizCardTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(20.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White,
            elevation = 4.dp) {
            
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {

                CreateImageProfile()
                Divider(modifier = Modifier.padding(5.dp))
                CreateInfo()
                Button(
                    onClick = {
                        buttonClickState.value = !buttonClickState.value
                    },
                    ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button,
                        color = Color.White
                    )
                }
                if(buttonClickState.value) {
                    Content()
                } else {
                    Box {}
                }
            }
        }
    }
}

@Preview
@Composable
fun Content() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)) {
        
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(2.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)) {

            Portfolio(data = listOf("Project 1", "Project 2", "Project 3",  "Project 4",  "Project 5",  "Project 6"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
                backgroundColor = Color.White,
                shape = RectangleShape) {

                Row(modifier = Modifier
                    .padding(8.dp)
                    .padding(8.dp)) {

                    CreateImageProfile(modifier = Modifier.size(100.dp))

                    Column(modifier = Modifier
                        .padding(8.dp)
                        .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                        Text(
                            text = "A great Project!",
                            style = MaterialTheme.typography.body2,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Fernando Barbosa",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Software Developer",
            modifier = Modifier.padding(3.dp),
            color = Color.DarkGray
        )
        Text(
            text = "@fernandobarbosa",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.DarkGray
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_icon
            ),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}



