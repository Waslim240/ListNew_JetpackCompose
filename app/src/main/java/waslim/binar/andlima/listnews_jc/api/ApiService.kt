package waslim.binar.andlima.listnews_jc.api

import retrofit2.http.GET
import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem

interface ApiService {

    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsResponseItem>
}