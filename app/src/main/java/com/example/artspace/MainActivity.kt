package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContentState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}
@Composable
fun ArtSpace(){

    var currentStep by remember { mutableStateOf(1) }

    
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background

    ){
        when (currentStep) {
            1 -> {
                ArtSpaceTextAndImage(
                    drawableResourceId = R.drawable.astorat16,
                    contentDescriptionResourceId = R.string.astor_at_16,
                    onPreviousClick = { currentStep = 1 },
                    onNextClick = { currentStep = 2 },
                    text1 = "Me at 16",
                    text2 = "Location: High School"
                )
            }
            2 -> {
                ArtSpaceTextAndImage(
                    drawableResourceId = R.drawable.astorat20,
                    contentDescriptionResourceId = R.string.astor_at_20,
                    onPreviousClick = { currentStep = 1 },
                    onNextClick = { currentStep = 3 },
                    text1 = "Me at 20",
                    text2 = "Location: Sala de Ensayo"
                )

            }
            3 -> {
                ArtSpaceTextAndImage(
                    drawableResourceId = R.drawable.astorat25,
                    contentDescriptionResourceId = R.string.astor_at_25,
                    onPreviousClick = { currentStep = 2},
                    text1 = "Me at 25",
                    text2 = "Location: La Popular (PUB) ",
                    onNextClick = { currentStep = 4 })
            }
            4 -> {
                ArtSpaceTextAndImage(
                    drawableResourceId = R.drawable.astorandjohann,
                    contentDescriptionResourceId = R.string.astor_and_johann,
                    onPreviousClick = { currentStep = 3 },
                    text1 = "Me and Johann ",
                    text2 = "Bonus Image! Greetings :)",
                    onNextClick = { currentStep = 1 })
            }
        }
        stringResource(R.string.astor_and_johann)
    }

}
@Composable
fun ArtSpaceTextAndImage(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onPreviousClick: () -> Unit,
    text1: String,
    text2: String,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
   Box(
       modifier = modifier
   ) {
     Column(
         modifier = Modifier
             .fillMaxSize()
             .verticalScroll(rememberScrollState()),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center,

         ) {
        Image(
            painter = painterResource(drawableResourceId) ,
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier.border(
                width = 5.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(0.dp)
            ))

         Text (text = text1,
             modifier = Modifier.padding(top = 10.dp),
             fontSize = 20.sp,
             textAlign = TextAlign.Justify,
             fontWeight = FontWeight.W500,
             letterSpacing = 0.sp)

         Spacer(modifier = Modifier.height(5.dp))

         Text (text = text2,
             modifier = Modifier.padding(5.dp),
             fontSize = 20.sp,
             textAlign = TextAlign.Justify,
             fontStyle = FontStyle.Italic,
             letterSpacing = 0.sp)

         Spacer(modifier = Modifier.height(5.dp))

         Row (horizontalArrangement = Arrangement.SpaceBetween,
             verticalAlignment = Alignment.Bottom) {
             Button(
                 onClick = { onPreviousClick() }
             ) {
                 Text("Previous")
             }

             Spacer(modifier = Modifier.padding(20.dp))

             Button(onClick = { onNextClick() }
             ) {
                 Text("Next")
             }
         }

     }

   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}