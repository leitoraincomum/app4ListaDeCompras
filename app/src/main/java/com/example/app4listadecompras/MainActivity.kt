package com.example.app4listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewProduto = findViewById<ListView>(R.id.listViewProdutos)


        listViewProdutos.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if(produto.isNotEmpty()){
                produtosAdapter.add(produto)
                txtProduto.text.clear()
            } else{
                txtProduto.error = "Coloque um Produto"
            }

        }

        listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

        }
    }
}