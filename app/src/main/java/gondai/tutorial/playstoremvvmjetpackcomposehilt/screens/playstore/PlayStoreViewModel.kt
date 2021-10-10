package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.playstore

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.category.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PlayStoreViewModel
@Inject
constructor(
    val repository: CategoryRepository
):ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow<PlayStoreState>(PlayStoreState.InProgress)

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<PlayStoreState> = _uiState
    init {
        load()
    }

    private fun load()=viewModelScope.launch {
        try{
            _uiState.value=PlayStoreState.InProgress
         val results=   withContext(viewModelScope.coroutineContext+Dispatchers
                .IO){
                repository.fetchAll()
            }
            _uiState.value=PlayStoreState.Success(results)
        }catch (ex:Throwable){
            _uiState.value=PlayStoreState.Failed(ex.localizedMessage)
        }
    }


}