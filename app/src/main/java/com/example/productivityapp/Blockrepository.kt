package com.example.productivityapp

import androidx.lifecycle.LiveData

class Blockrepository(private val blockDAO: BlockDAO) {
    val readAllData: LiveData<List<ProductivityBlocks>> = blockDAO.readAllData()

    fun addblock(block: ProductivityBlocks){
        blockDAO.addBlock(block)
    }

}