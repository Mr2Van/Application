package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    GreetingSpaceArt()


                }
            }
        }
    }
}

data class Artwork(
    val imageResId: Int,
    val title: String,
    val artist: String,
    val year: String
)

@Composable
fun GreetingSpaceArt(modifier: Modifier =Modifier){

    val artworks = listOf(
        Artwork(R.drawable.djlujlby, "purete de l'afrique", "van eke", "2021"),
        Artwork(R.drawable._z6iy5rv, "motif du pays", "bella", "2022"),
        Artwork(R.drawable.african_woman_carrying_clay_pot_on_head__two_goats_canvas_print_by_loraine_yaffe__all_canvas_prints_a___african_art_paintings__african_drawings__african_paintings, "Femme du monde", "rose", "2023")
    )
    var currentIndex by remember { mutableStateOf(0) }


    val artwork = artworks[currentIndex]
    val image = painterResource(id = artwork.imageResId)

    Column(Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Card(
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier= Modifier
                    .fillMaxSize().fillMaxHeight().padding(30.dp)


            )

        }

        Spacer(modifier = Modifier.height(150.dp))


        Column(
            modifier=Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.purple_701))
                .padding(16.dp)
            , verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = artwork.title,
                fontSize = 24.sp,
                textAlign = TextAlign.Justify

            )
            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "${artwork.artist} (${artwork.year})",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

        }

        Spacer(modifier = Modifier.height(40.dp))


        Row( modifier=Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button( modifier = Modifier
                .weight(1f) // Donne à ce bouton 1 part de l'espace
                .padding(start = 8.dp), onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                }
            }) {

                Text(text = "Previous", fontSize = 24.sp)

            }
            Spacer(modifier = Modifier.width(20.dp))


            Button( modifier = Modifier
                .weight(1f) // Donne à ce bouton 1 part de l'espace
                .padding(start = 8.dp), onClick = {
                if (currentIndex < artworks.size - 1) {
                    currentIndex++
                }
            }) {

                Text(text = "Next", fontSize = 24.sp)

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    GreetingSpaceArt()
}