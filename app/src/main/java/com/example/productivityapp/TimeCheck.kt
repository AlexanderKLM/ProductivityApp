package com.example.productivityapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.findFragment
import com.example.productivityapp.databinding.FragmentTimeCheck2Binding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlin.properties.Delegates


class TimeCheck : Fragment() {
    var trh1: Int = 0
    var trmin1: Int = 0
    var trh2: Int = 0
    var trmin2: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_time_check2, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Instead of view.findViewById(R.id.hello) as TextView

        val sts = view.findViewById<Button>(R.id.StartTaskstep1)
        val stft = view.findViewById<Button>(R.id.startTaskstep)
        val ts1 = view.findViewById<TextView>(R.id.TaskTimeShow1)
        val ts2 = view.findViewById<TextView>(R.id.TaskTimeShow2)
        val Next = view.findViewById<Button>(R.id.Step1Next)
        ts1.setTextColor(Color.parseColor("#000000"))
        ts2.setTextColor(Color.parseColor("#000000"))

        sts.setOnClickListener {
            val mtp = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Время когда вы готовы к работе")
                .build()

            mtp.show(requireActivity().supportFragmentManager, "starttime")
            mtp.addOnPositiveButtonClickListener {
                val h = mtp.hour
                val min = mtp.minute
                trh1 =  h
                trmin1 = min
                if (h<10){
                    ts1.setText("С 0$h:$min")
                }
                if (h<10 && min < 10){
                    ts1.setText("С 0$h:0$min")
                }
                if (min<10) {
                    ts1.setText("С $h:0$min")
                }
            }
        }

        stft.setOnClickListener {
            val mtp = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Время когда вы готовы к работе")
                .build()

            mtp.show(requireActivity().supportFragmentManager, "starttime")
            mtp.addOnPositiveButtonClickListener {
                val h = mtp.hour
                val min = mtp.minute
                trh2 =  h
                trmin2 = min
                if (h<10){
                    ts2.setText("С 0$h:$min")
                }
                if (h<10 && min < 10){
                    ts2.setText("С 0$h:0$min")
                }
                if (min<10) {
                    ts2.setText("С $h:0$min")
                }
            }
        }
        Next.setOnClickListener {
            val bf = Step2BusyJob()

            if (trh1 != null && trh2 != null && trmin1 != null && trmin2 != null){
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    remove(view.findFragment())
                    replace(R.id.F_layout, bf)
                    Log.d("Значения", trh1.toString() + " " + trh2.toString())
                    commit()
            }} else {
                val hleb =Toast.makeText(requireActivity(),"Заполните все поля", Toast.LENGTH_SHORT)
                hleb.show()
            }
        }
    }
}









