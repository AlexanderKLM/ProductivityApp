package com.example.productivityapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SerViewModel (application: Application): AndroidViewModel(application){
        val readAllData: LiveData<List<SeriousBlocks>>
        private val repository: SerRepository

        init {
            val serDAO = SeriousDB.getDB(application).SeriousDAO()
            repository = SerRepository(serDAO)
            readAllData = repository.readAllDataSer

        }

        fun addBlock(blockS: SeriousBlocks){
            viewModelScope.launch(Dispatchers.IO){
                repository.addSerious(blockS)
            }
        }
        fun addSerious(blockS: SeriousBlocks){
            viewModelScope.launch(Dispatchers.IO){
                repository.addSerious(blockS)
            }
        }
 }
