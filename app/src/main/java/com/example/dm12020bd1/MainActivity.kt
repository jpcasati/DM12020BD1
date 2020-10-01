package com.example.dm12020bd1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menuSalvarProduto -> {
                salvar()
                finish()
            }
            R.id.menuVoltar -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun salvar() {
        val p = Produto(edtNome.text.toString(),
        edtValor.text.toString().toFloat())

        val pDAO = ProdutoDatabase.getInstance(this)!!.produtoDao()

        pDAO.salvar(p)
    }
}
