package com.example.dm12020bd1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert

@Dao
interface ProdutoDAO {

    @Insert
    fun salvar(produto: Produto)

    @Query("SELECT * FROM Produto ORDER BY nome ASC")
    fun listarNomeAsc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY nome DESC")
    fun listarNomeDesc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY valor ASC")
    fun listarValorAsc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY valor DESC")
    fun listarValorDesc(): List<Produto>

    @Delete
    fun excluir(produto: Produto)
}