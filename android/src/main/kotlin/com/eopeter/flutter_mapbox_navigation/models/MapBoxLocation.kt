package com.eopeter.flutter_mapbox_navigation.models

import android.location.Location
import com.google.gson.Gson

class MapBoxLocation(val name: String = "",
                     val latitude: Double?,
                     val longitude: Double?,
                     val speed: Float?,
                     val bearing: Float?,
                     val accuracy: Float?

) {

    constructor(location: Location) : this(
        name = "",
        latitude = location.latitude,
        longitude = location.longitude,
        speed = location.speed,
        bearing = location.bearing,
        accuracy = location.accuracy

    ) ;

    override fun toString(): String {
        return "{" +
                "  \"latitude\": $latitude," +
                "  \"longitude\": $longitude," +
                "  \"speed\": $speed," +
                "  \"bearing\": $bearing," +
                "  \"accuracy\": $accuracy," +
                "}"
    }

    fun jsonEventString(): String {
        val dataString = Gson().toJson(this)
        return "{" +
                "  \"eventType\": \"${MapBoxEvents.LOCATION_UPDATE.value}\"," +
                "  \"data\": $dataString" +
                "}"

    }

}

