package com.example.weather.ui.utils


import kotlin.IllegalStateException
import kotlin.reflect.KProperty


object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

/*  This delegate can work over any non-nullable type. It will recieve a reference
    of an object of any type, and use T as the type of the getter and the setter.   */

class NotNullSingleValueVar<T> {

    private var value:T? = null

    // The getter will return a value if it's assigned, otherwise it will throw an exception.
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?: throw IllegalStateException("${property.name} not initialized.")

    // The settir will assign the value if it still null, otherwise it will throw an exception.
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
            else throw IllegalStateException("${property.name} already initialized")
    }
}
