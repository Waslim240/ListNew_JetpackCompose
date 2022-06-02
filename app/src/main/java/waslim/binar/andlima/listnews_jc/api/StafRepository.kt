package waslim.binar.andlima.listnews_jc.api

import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import waslim.binar.andlima.listnews_jc.data.GettAllStaffResponseItem
import javax.inject.Inject

class StafRepository @Inject constructor(private val apiService : ApiService) {
    suspend fun getStaf() : List<GettAllStaffResponseItem>{
        return apiService.getAllStaff()
    }
}