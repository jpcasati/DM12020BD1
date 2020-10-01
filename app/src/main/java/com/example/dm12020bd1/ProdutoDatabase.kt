package com.example.dm12020bd1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Produto::class], version = 1)
abstract class ProdutoDatabase : RoomDatabase() {

    abstract fun produtoDao() : ProdutoDAO

    companion object {

        private var database: ProdutoDatabase? = null

        private val DATABASE = "ProdutoDB"

        fun getInstance(context: Context): ProdutoDatabase? {

            if(database == null)
                return criaBanco(context)
            else
                return database

        }

        private fun criaBanco(context: Context): ProdutoDatabase {
            return Room.databaseBuilder(context, ProdutoDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }

}