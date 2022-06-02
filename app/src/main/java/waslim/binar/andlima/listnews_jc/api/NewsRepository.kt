package waslim.binar.andlima.listnews_jc.api

import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService : ApiService) {
    suspend fun getNews() : List<GetAllNewsResponseItem>{
        return apiService.getAllNews()
    }
}