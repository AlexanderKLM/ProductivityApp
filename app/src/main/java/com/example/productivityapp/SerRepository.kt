package com.example.productivityapp

import androidx.lifecycle.LiveData

class SerRepository (private val serDAO: SeriousDAO) {
        val readAllDataSer: LiveData<List<SeriousBlocks>> = serDAO.readAllDataser()

        fun addSerious(blockS: SeriousBlocks){
            serDAO.addSerious(blockS)
        }

}
