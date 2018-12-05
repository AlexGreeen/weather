package com.example.weather.domain.mappers

import com.example.weather.data.Forecast
import com.example.weather.data.ForecastResult
import com.example.weather.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.weather.domain.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList {
        return ForecastList(
            forecastResult.city.name,
            forecastResult.city.country,
            convertForecastListToDomain(forecastResult.list)
        )
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { index, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(index.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }

    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
            convertDate(forecast.dt),
            forecast.weather[0].description,
            forecast.temperature.max.toInt(),
            forecast.temperature.min.toInt()
        )
    }

    private fun convertDate(date: Long): String {
        val dt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dt.format(date)
    }
}