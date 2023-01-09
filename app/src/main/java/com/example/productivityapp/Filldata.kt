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

class Filldata : Fragment() {
    private lateinit var nBlockViewModel: BlockViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_filldata, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nBlockViewModel = ViewModelProvider(this).get(BlockViewModel::class.java)

        val Add3 = view.findViewById<Button>(R.id.f_add_block)
        Add3.setOnClickListener {
            val Rem = view.findViewById<EditText>(R.id.S3Remind)
            val r = Rem.text.toString()
            val Desc = view.findViewById<EditText>(R.id.S3Desc)
            val desc = Desc.text.toString()
            val Treq = view.findViewById<EditText>(R.id.S3TimeReq)
            var treq = Treq.text.toString()
            val prior = view.findViewById<EditText>(R.id.S3Priority).text.toString().toInt()
            val stats = "Выполняется"
            val exp = true
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val current = LocalDateTime.now().format(formatter)
            val end = view.findViewById<EditText>(R.id.S3DeadLine)
            val tend = end.text.toString()
            val type = view.findViewById<EditText>(R.id.S3Filter)
            val typer = type.text.toString()
            var starttime = view.findViewById<EditText>(R.id.S3Duration)
            var strt = starttime.text.toString()

            if (r.isEmpty() or desc.isEmpty() or tend.isEmpty() or typer.isEmpty()) {
                val hleb =
                    Toast.makeText(requireActivity(), "Заполните все поля", Toast.LENGTH_SHORT)
                hleb.show()
            } else {
                if(treq.isEmpty()) {
                    val hleb =
                        Toast.makeText(
                            requireActivity(),
                            "Заполните поле времени",
                            Toast.LENGTH_SHORT
                        )
                    hleb.show()
                } else {
                    var treq2 = treq.toInt()
                    val task = ProductivityBlocks(
                        r, desc, treq2, exp, stats, typer, prior, current, tend, strt
                    )
                    nBlockViewModel.addBlock(task)
                    val hleb =
                        Toast.makeText(requireActivity(), "Список обновлен", Toast.LENGTH_SHORT)
                    hleb.show()
                }
            }
        }
    }
}