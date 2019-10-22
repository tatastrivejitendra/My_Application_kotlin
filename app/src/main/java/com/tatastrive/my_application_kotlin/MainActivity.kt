package com.tatastrive.my_application_kotlin

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    var sensor: Sensor? = null
    var sensorManager: SensorManager? = null

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    var isRunning = false
    var mp: MediaPlayer? = null


    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.values[0] > 30 && isRunning == false) {
            isRunning = true
            try {
                mp = MediaPlayer()
                mp!!.setDataSource("http://mr-jatt2.com/siteuploads/files/sfd78/38545/Dua%20Lipa%20&%20BLACKPINK%20-%20Kiss%20and%20Make%20Up%20128kbps(mr-jatt2.com).mp3")
                mp!!.prepare()
                mp!!.start()

            } catch (ex: Exception) {
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)

    }
}
