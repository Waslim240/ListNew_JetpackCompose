package waslim.binar.andlima.listnews_jc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import waslim.binar.andlima.listnews_jc.api.NewsRepository
import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import javax.inject.Inject

@HiltViewModel
class ViewModelNews @Inject constructor(private val newsRepository: NewsRepository) : ViewModel(){
    private val newsState = MutableStateFlow(emptyList<GetAllNewsResponseItem>())
    val dataState : StateFlow<List<GetAllNewsResponseItem>> get() = newsState

    init {
        viewModelScope.launch {
            val news = newsRepository.getNews()
            newsState.value = news
        }
    }
}