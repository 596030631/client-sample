package com.shuaijun.client.ui.time

import androidx.lifecycle.ViewModel

data class PersonTimeInfo(val orderId:String, val operator:String)

class TimePersonViewModel : ViewModel() {
    val dataList = mutableListOf<PersonTimeInfo>()

    init {
        dataList.add(PersonTimeInfo("001-10000000", "张三"))
        dataList.add(PersonTimeInfo("001-10000001","李四"))
        dataList.add(PersonTimeInfo("002-10000002","王五"))
        dataList.add(PersonTimeInfo("002-10000003","赵一二"))
        dataList.add(PersonTimeInfo("002-10000004","钱三四"))
    }
}