package com.shuaijun.client.ui.time

import androidx.lifecycle.ViewModel

data class PersonTimeInfo(val orderId:String)

class TimePersonViewModel : ViewModel() {
    val dataList = mutableListOf<PersonTimeInfo>()

    init {
        dataList.add(PersonTimeInfo("10000000"))
        dataList.add(PersonTimeInfo("10000001"))
        dataList.add(PersonTimeInfo("10000002"))
        dataList.add(PersonTimeInfo("10000003"))
        dataList.add(PersonTimeInfo("10000004"))
    }
}