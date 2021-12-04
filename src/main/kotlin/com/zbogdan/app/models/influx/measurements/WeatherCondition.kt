package com.zbogdan.app.models.influx.measurements

import com.influxdb.annotations.Column
import com.influxdb.annotations.Measurement
import java.time.Instant

@Measurement(name = "weather")
data class WeatherCondition(
    @Column(timestamp = true, name = "time") val time: Instant?,
    @Column(tag = true, name = "temperature") val temperature: String?,
    @Column val tempValue: Int?
)