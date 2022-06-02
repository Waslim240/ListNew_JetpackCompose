package waslim.binar.andlima.listnews_jc.api

import retrofit2.http.GET
import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import waslim.binar.andlima.listnews_jc.data.GettAllStaffResponseItem

interface ApiService {

    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsResponseItem>

    @GET("staf")
    suspend fun getAllStaff() : List<GettAllStaffResponseItem>
}