package com.example.dm12020bd1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Produto(val nome: String,
                   val valor: Float,
                   @PrimaryKey(autoGenerate = true)
                   val id: Int = 0) {

    override fun toString(): String {
        return id.toString() + " - " + nome + " (R$ " + valor.toString() + ")"
    }
}