package com.gabrielbizarria.composeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                MainToolbar()

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val painter1 = painterResource(R.drawable.kermit_family)
                    val description1 = "Foto da família do Kermit"
                    val title1 = "Família Kermit"

                    val painter2 = painterResource(R.drawable.kermit_na_neve)
                    val description2 = "Foto do Kermit na neve"
                    val title2 = "Kermit na Neve"

                    Box(
                        modifier =  Modifier.size(200.dp)
                    ){
                        ImageCard(
                            painter1,
                            description1,
                            title1
                        )
                    }

                    Box(
                        modifier = Modifier.size(200.dp)
                    ){
                        ImageCard(
                            painter2,
                            description2,
                            title2
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun MainToolbar() {
    TopAppBar(
        backgroundColor = Color.DarkGray,
        title = {
            Text("Kermit")
        },
        elevation = 5.dp
    )
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    //Card
    Card(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        //Imagem do Card
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            //Gradiente do Card
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )

            //Título do Card
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}
