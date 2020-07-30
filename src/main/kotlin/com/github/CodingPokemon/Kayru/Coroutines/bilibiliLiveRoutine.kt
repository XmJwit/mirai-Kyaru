package com.github.CodingPokemon.Kayru.Coroutines

import com.alibaba.fastjson.JSONObject
import com.github.CodingPokemon.Kayru.Utils.HttpUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.mamoe.mirai.Bot

suspend fun liveroutine(bilibiliuid:String){
    withContext(Dispatchers.IO){
//        var bot: Bot? = null
//        try {
//            bot = Bot.getInstance(qqnumber.toLong())
//        } catch (e: NoSuchElementException) {
//            e.printStackTrace()
//        }
//        val group = bot!!.getGroup(groupnum.toLong())
        val `object`: JSONObject = HttpUtil.getBlibiliLiveStatus(bilibiliuid)
        val data = `object`["data"] as JSONObject?
        val status = data!!.getString("liveStatus")
        println(status)
    }
}

fun main() {
    GlobalScope.launch {
       liveroutine("169837")
       liveroutine("145149047")
    }
    Thread.sleep(10000)
}