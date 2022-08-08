package com.erkumardevender.githubdemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkumardevender.githubdemo.data.models.PullRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import com.erkumardevender.githubdemo.domain.FetchClosedPRUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitRepoPRViewModel @Inject constructor(private val fetchClosedPRUseCase: FetchClosedPRUseCase):ViewModel(){

    private var _closedPRList=MutableStateFlow(emptyList<PullRequest>())
    val closedPRList: StateFlow<List<PullRequest>> get() = _closedPRList

    private val _loading=MutableStateFlow(false)
    val loading:StateFlow<Boolean> get()=_loading

    fun fetchClosedPRs(onPRsFetched:(List<PullRequest>)->Unit){
        viewModelScope.launch {
            fetchClosedPRUseCase.getClosedPRs()
                .onStart {
                    _loading.value=true
                }
                .catch {
                    _loading.value=false
                }
                .collect{
                    _closedPRList.value=it
                    onPRsFetched(it)
                    _loading.value=false
                }
        }
    }
}