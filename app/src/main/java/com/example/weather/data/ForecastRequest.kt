package com.example.weather.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL


class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "e77d8a3c5143787f60f61fcf1571d3ed"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?&mode=json&units=metrics&count=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)

        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}