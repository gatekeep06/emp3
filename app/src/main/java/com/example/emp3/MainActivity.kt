package com.example.emp3

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast


class MainActivity : Activity() {
    var products: ArrayList<Product> = ArrayList<Product>()
    var boxAdapter: BoxAdapter? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // создаем адаптер
        fillData()
        boxAdapter = BoxAdapter(this, products)

        // настраиваем список
        val lvMain = findViewById<View>(R.id.listViewMain) as ListView
        lvMain.adapter = boxAdapter
    }

    // генерируем данные для адаптера
    fun fillData() {
        for (i in 1..20) {
            products.add(
                Product(
                    "Product $i", i * 1000,
                    com.google.android.gms.base.R.drawable.googleg_standard_color_18, false
                )
            )
        }
    }

    // выводим информацию о корзине
    open fun showResult(v: View?) {
        var result = "Товары в корзине:"
        for (p in boxAdapter!!.getBox()!!) {
            if (p.box) result += """
     
     ${p.name}
     """.trimIndent()
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }
}