package com.zbogdan.app.components

import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.kotlin.InfluxDBClientKotlinFactory
import com.influxdb.client.write.Point
import com.zbogdan.app.models.influx.measurements.WeatherCondition
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Component

@Component
class InfluxWeatherComponent {
    companion object {
        val url = "http://192.168.0.144:8086"
        val token: String = "YwtPfIEw24965tPFyiB_K7WKoxf6Cg_4RDMhJsWdDpLUhU8hTFmJquxV2h-w0skjWMIyp2QWt_VWaUpINhRq9Q=="
        val org: String = "self"
        val bucket: String = "bogdan"

        fun influx() = InfluxDBClientKotlinFactory.create(url, token.toCharArray(), org, bucket)
    }

    fun write(record: String) = runBlocking {
        influx().getWriteKotlinApi().writeRecord(record, WritePrecision.NS)
    }

    fun write(point: Point) = runBlocking {
        influx().getWriteKotlinApi().writePoint(point)
    }

    fun write(measurement: WeatherCondition) = runBlocking {
        influx().getWriteKotlinApi().writeMeasurement(measurement, WritePrecision.NS)
    }

    suspend fun read() {
        val query: String = """
            from (bucket: "bogdan")
            |> range(start: -1d)
            |> filter(fn: (r) => 
                r._field == "tempValue"
            )
        """.trimIndent()
        influx().getQueryKotlinApi().query(query).consumeAsFlow().collect {
            println("time=${it.time}; ${it.field} |> ${it.value}")
        }
    }
}