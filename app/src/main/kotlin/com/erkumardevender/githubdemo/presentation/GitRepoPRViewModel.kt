package com.erkumardevender.githubdemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.erkumardevender.githubdemo.domain.FetchClosedPRUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitRepoPRViewModel @Inject constructor(private val fetchClosedPRUseCase: FetchClosedPRUseCase):ViewModel(){

    fun fetchClosedPRs(){
        viewModelScope.launch {
            fetchClosedPRUseCase.getClosedPRs()
                .onStart {

                }
                .catch {

                }
                .collect{

                }
        }
    }
}