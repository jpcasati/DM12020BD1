package com.example.dm12020bd1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnAdd.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))

        }

    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    private fun carregaLista() {

        val produtos : List<Produto> = ProdutoDatabase.getInstance(this)!!.produtoDao().listar()

        val adp = ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos)

        lstProdutos.adapter = adp

    }
}
