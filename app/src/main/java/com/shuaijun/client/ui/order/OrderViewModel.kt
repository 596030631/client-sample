package com.shuaijun.client.ui.order

import androidx.lifecycle.ViewModel

data class OrderInfo(var id: String, var name: String, var list: MutableList<ItemInfo>) {
    data class ItemInfo(var name: String)
}

data class OrderPredictInfo(var id: String, var name: String, var list: MutableList<ItemInfo>) {
    data class ItemInfo(var name: String)
}


class OrderViewModel : ViewModel() {

    val orderList = mutableListOf<OrderInfo>()
    val orderDetailList = mutableListOf<OrderInfo.ItemInfo>()

    val orderPredict = mutableListOf<OrderPredictInfo>()
    val orderPredictDetailList = mutableListOf<OrderPredictInfo.ItemInfo>()

    init {
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第二个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第三个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第四个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第五个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第六个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))
        orderList.add(OrderInfo("订单号:001-000001", "订单名称:这是第一个订单", mutableListOf()))

        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第二个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第三个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第四个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第五个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第六个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))
        orderPredict.add(OrderPredictInfo("订单号:001-000001", "订单名称:这是第一个订单预测", mutableListOf()))

        orderDetailList.add(OrderInfo.ItemInfo("这是第一个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第二个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第三个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第四个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第五个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第六个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第七个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第八个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第九个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
        orderDetailList.add(OrderInfo.ItemInfo("这是第十个检测内容项目"))
    }
}