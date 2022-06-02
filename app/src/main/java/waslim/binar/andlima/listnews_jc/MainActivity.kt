package waslim.binar.andlima.listnews_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import waslim.binar.andlima.listnews_jc.ui.theme.ListNews_JCTheme
import waslim.binar.andlima.listnews_jc.viewmodel.ViewModelNews

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListNews_JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModelNews = viewModel(modelClass = ViewModelNews::class.java)
                    val dataNews by viewModelNews.dataState.collectAsState()

                    LazyColumn{
                        if (dataNews.isEmpty()){
                            item {

                            }
                        }

                        items(dataNews){
                            NewsComposeCustom(news = it)
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(news : GetAllNewsResponseItem) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ListNews_JCTheme {
//        Greeting("", "", "", "", "", "")
    }
}