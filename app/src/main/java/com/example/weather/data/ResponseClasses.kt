package com.example.weather.data

data class ForecastResult(val city: City, val list: List<Forecast>)

data class Forecast(
    val clouds: Int, val deg: Int, val dt: Long, val humidity: Int, val pressure: Double, val rain: Double,
    val speed: Double, val temperature: Temperature, val weather: List<Weather>
)

data class Temperature(
    val day: Double, val eve: Double, val max: Double,
    val min: Double, val morn: Double, val night: Double
)

data class Weather(val description: String, val icon: String, val id: Long, val main: String)

data class City(
    val coord: Coord, val country: String, val id: Long,
    val name: String, val population: Int
)

data class Coord(val lat: Double, val lon: Double)