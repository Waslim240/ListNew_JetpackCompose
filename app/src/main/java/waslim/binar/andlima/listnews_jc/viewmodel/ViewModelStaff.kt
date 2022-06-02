package waslim.binar.andlima.listnews_jc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import waslim.binar.andlima.listnews_jc.api.StafRepository
import waslim.binar.andlima.listnews_jc.data.GetAllNewsResponseItem
import waslim.binar.andlima.listnews_jc.data.GettAllStaffResponseItem
import javax.inject.Inject

@HiltViewModel
class ViewModelStaff @Inject constructor(private val stafRepository: StafRepository) : ViewModel(){
    private val stafState = MutableStateFlow(emptyList<GettAllStaffResponseItem>())
    val dataState : StateFlow<List<GettAllStaffResponseItem>> get() = stafState

    init {
        viewModelScope.launch {
            val staf = stafRepository.getStaf()
            stafState.value = staf
        }
    }
}