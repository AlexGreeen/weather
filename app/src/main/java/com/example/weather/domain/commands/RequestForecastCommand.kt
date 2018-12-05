package com.example.weather.domain.commands

import com.example.weather.data.ForecastRequest
import com.example.weather.domain.mappers.ForecastDataMapper
import com.example.weather.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper()
                        .convertFromDataModel(
                            forecastRequest.execute())
    }

}