package waslim.binar.andlima.listnews_jc

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import waslim.binar.andlima.listnews_jc.data.GettAllStaffResponseItem

@Composable
fun StafComposeCustom (staf : GettAllStaffResponseItem){
    val mcontect = LocalContext.current

    Column(modifier = Modifier

        .padding(start = 15.dp, end = 15.dp, bottom = 3.dp, top = 3.dp)) {
        Card(shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val pindah = Intent(mcontect, DetailStaff::class.java)
                    pindah.putExtra("detailstaf", staf)
                    mcontect.startActivity(pindah)
                }
                .height(80.dp)) {

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {

                Image(painter = rememberImagePainter(data = staf.image),
                    contentDescription = "iconstaf",
                    modifier = Modifier
                        .width(130.dp)
                        .height(70.dp)
                        .padding(end = 10.dp))

                Column() {
                    Text(
                        text = "Name : ${staf.name}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))

                    Text(
                        text = "create date : ${staf.createdAt}",
                        color = Color.Magenta,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))

                    Text(
                        text = "Email : ${staf.email}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))
                }
            }
        }
    }
}