package com.example.productivityapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BlockViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<ProductivityBlocks>>
    private val repository: Blockrepository

    init {
        val blockDAO = BlockDB.getDB(application).BlockDAO()
        repository = Blockrepository(blockDAO)
        readAllData = repository.readAllData

    }

    fun addBlock(block: ProductivityBlocks){
        viewModelScope.launch(Dispatchers.IO){
            repository.addblock(block)
        }
    }

}