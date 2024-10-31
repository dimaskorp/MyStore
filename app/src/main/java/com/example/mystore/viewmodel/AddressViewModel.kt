package com.example.mystore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystore.data_models.Suggestions
import com.example.mystore.repository.AddressRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AddressViewModel(private val repository: AddressRepository) : ViewModel() {

    private val _suggestions = MutableLiveData<Suggestions?>()
    val suggestions: LiveData<Suggestions?> get() = _suggestions

    private var searchJob: Job? = null

    fun searchAddress(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300) // Задержка в 300 мс
            val result = repository.searchAddresses(query)
            if (result != null) {
                _suggestions.value = result

            }
        }
    }
}