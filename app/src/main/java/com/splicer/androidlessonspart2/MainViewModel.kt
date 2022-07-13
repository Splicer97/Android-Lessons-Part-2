package com.splicer.androidlessonspart2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel () {
    val plant = MutableLiveData<PlantModel>()
}