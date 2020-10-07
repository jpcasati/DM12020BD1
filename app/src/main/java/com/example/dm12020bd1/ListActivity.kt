package com.example.dm12020bd1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnAdd.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))

        }

        lstProdutos.setOnItemLongClickListener { parent, view, position, id ->

            var produto = lstProdutos.getItemAtPosition(position) as Produto
            ProdutoDatabase.getInstance(this)!!.produtoDao().excluir(produto)

            carregaLista("nome", "ASC")
            return@setOnItemLongClickListener true
        }

    }

    override fun onResume() {
        super.onResume()
        carregaLista("nome", "ASC")
    }

    private fun carregaLista(atributo: String, tipo: String) {

        val produtos : List<Produto>

        if(tipo.equals("ASC"))
            if(atributo.equals("nome"))
             produtos = ProdutoDatabase.getInstance(this)!!.produtoDao().listarNomeAsc()
            else
             produtos = ProdutoDatabase.getInstance(this)!!.produtoDao().listarValorAsc()
        else
            if(atributo.equals("nome"))
                produtos = ProdutoDatabase.getInstance(this)!!.produtoDao().listarNomeDesc()
            else
                produtos = ProdutoDatabase.getInstance(this)!!.produtoDao().listarValorDesc()


        val adp = ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos)

        lstProdutos.adapter = adp

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.ordNomeAsc -> carregaLista("nome", "ASC")
            R.id.ordNomeDesc -> carregaLista("nome", "DESC")
            R.id.ordValorAsc -> carregaLista("valor", "ASC")
            R.id.ordValorDesc -> carregaLista("valor", "DESC")
        }

        return super.onOptionsItemSelected(item)
    }
}
