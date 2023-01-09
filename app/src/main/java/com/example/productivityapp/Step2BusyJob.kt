package com.example.productivityapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Step2BusyJob : Fragment() {
    private lateinit var SViewModel: SerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step2_busy_job, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SViewModel= ViewModelProvider(this).get(SerViewModel::class.java)

        val Add = view.findViewById<Button>(R.id.S2Add)
        Add.setOnClickListener {
        val Rem = view.findViewById<EditText>(R.id.BusyTaskNameStep2)
        val r = Rem.text.toString()
        val Desc = view.findViewById<EditText>(R.id.BusyTaskDescriptionStep2)
        val desc = Desc.text.toString()
        val Date = view.findViewById<EditText>(R.id.BusyTaskDateStep3)
        val date = Date.text.toString()
        val Treq = view.findViewById<EditText>(R.id.busyTaskTimeRequired)
        var treq = Treq.text.toString()
        val stats = "Постоянное"
        val exp = true
        val prior = 9
        val type = "Обязательное"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val current = LocalDateTime.now().format(formatter)
        val end = view.findViewById<EditText>(R.id.S2DEADL).text.toString()

            if (r.isEmpty() or date.isEmpty() or end.isEmpty()) {
                val hleb =
                    Toast.makeText(requireActivity(), "Заполните все поля", Toast.LENGTH_SHORT)
                hleb.show()
            } else {
                if(treq.isEmpty()){
                    val hleb =
                        Toast.makeText(requireActivity(), "Заполните поле времени", Toast.LENGTH_SHORT)
                    hleb.show()
                }else {
                    var treq2 = treq.toInt()
                    val task = SeriousBlocks(
                        r, desc, treq2, exp, stats, type, prior, current, end, date
                    )
                    SViewModel.addSerious(task)
                    val hleb =
                        Toast.makeText(requireActivity(), "Список обновлен", Toast.LENGTH_SHORT)
                    hleb.show()
                }
            }
        }
    }
}