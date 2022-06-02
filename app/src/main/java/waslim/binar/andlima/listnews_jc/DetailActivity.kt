package waslim.binar.andlima.listnews_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import waslim.binar.andlima.listnews_jc.ui.theme.ListNews_JCTheme

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailNews = intent.getParcelableExtra<GetAllNewsResponseItem>("detailnews")
        setContent {
            ListNews_JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2(detailNews!!)
                }
            }
        }
    }
}

@Composable
fun Greeting2(detail : GetAllNewsResponseItem) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Detail",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.fillMaxWidth())

        Image(painter = rememberImagePainter(data = detail.image),
            contentDescription = "icondetail",
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
                .padding(end = 10.dp))

        Text(text = "Judul : ${detail.title}",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp))

        Text(text = "Rilis : ${detail.createdAt}",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp))

        Text(text = "Author : ${detail.author}",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp))

        Text(text = "Deskripsi : ${detail.description}",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ListNews_JCTheme {

    }
}