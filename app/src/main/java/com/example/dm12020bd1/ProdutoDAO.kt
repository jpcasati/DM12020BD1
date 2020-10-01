package com.example.dm12020bd1

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert

@Dao
interface ProdutoDAO {

    @Insert
    fun salvar(produto: Produto)

    @Query("select * from Produto")
    fun listar(): List<Produto>
}