package com.example.countries.ui.shared

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.countries.data.Country
import com.example.countries.data.CountryRepository

class SharedViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = CountryRepository(app)
    val countryData = dataRepo.countryData

    val selectedCountry = MutableLiveData<Country>()

    fun refreshData() {
        dataRepo.refreshData()
    }

}
