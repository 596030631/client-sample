package com.shuaijun.client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val titleMessage = MutableLiveData<String>()
}