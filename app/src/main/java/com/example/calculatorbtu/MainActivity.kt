package com.example.calculatorbtu

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberClick(view: View) {
        if (view is TextView) {
            val symbol = view.text.toString();

            if (symbol.equals("=")) {
                val evalResult = ExpressionBuilder(input.text.toString()).build().evaluate()

                if (evalResult % 1.0 != 0.0) {
                    result.text = evalResult.toString()
                } else {
                    result.text = evalResult.toInt().toString()
                }

                input.text = ""
            } else {
                input.text = input.text.toString() + symbol
            }
        }
    }

    fun clearClick(view: View) {
        if (view is TextView) {
            input.text = ""
            result.text = ""
        }
    }

    fun delClick(view: View) {
        if (view is TextView) {
            input.text = input.text.subSequence(0, input.text.length - 1)
        }
    }

}
