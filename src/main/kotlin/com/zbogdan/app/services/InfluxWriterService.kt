package com.zbogdan.app.services

import com.zbogdan.app.components.InfluxWeatherComponent
import com.zbogdan.app.models.influx.measurements.WeatherCondition
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import javax.annotation.PostConstruct
import kotlin.random.Random

@Service
class InfluxWriterService {

    @Autowired
    private lateinit var influx: InfluxWeatherComponent

    @PostConstruct
    fun init() = runBlocking {
        repeat(10) {
            influx.write(
                WeatherCondition(
                    time = Instant.now(), temperature = "hourly", tempValue = Random.nextInt(-10, +30)
                )
            )
            println("Written to influxdb")
            delay(1500L)
        }
        influx.read()
    }
}