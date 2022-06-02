package waslim.binar.andlima.listnews_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import waslim.binar.andlima.listnews_jc.ui.theme.ListNews_JCTheme
import waslim.binar.andlima.listnews_jc.viewmodel.ViewModelNews
import waslim.binar.andlima.listnews_jc.viewmodel.ViewModelStaff

@AndroidEntryPoint
class StaffLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListNews_JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModelStaf = viewModel(modelClass = ViewModelStaff::class.java)
                    val dataStaf by viewModelStaf.dataState.collectAsState()

                    LazyColumn{
                        if (dataStaf.isEmpty()){
                            item {

                            }
                        }

                        items(dataStaf){
                            StafComposeCustom(staf = it)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ListNews_JCTheme {
    }
}