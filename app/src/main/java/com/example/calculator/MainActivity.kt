package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_0.setOnClickListener{ setTextFields("0")}
        bt_1.setOnClickListener{setTextFields("1")}
        bt_2.setOnClickListener{setTextFields("2")}
        bt_3.setOnClickListener{setTextFields("3")}
        bt_4.setOnClickListener{setTextFields("4")}
        bt_5.setOnClickListener{setTextFields("5")}
        bt_6.setOnClickListener{setTextFields("6")}
        bt_7.setOnClickListener{setTextFields("7")}
        bt_8.setOnClickListener{setTextFields("8")}
        bt_9.setOnClickListener{setTextFields("9")}
        bt_min.setOnClickListener{setTextFields("-")}
        bt_plus.setOnClickListener{setTextFields("+")}
        bt_mult.setOnClickListener{setTextFields("*")}
        bt_disivion.setOnClickListener{setTextFields("/")}

        bt_open.setOnClickListener{setTextFields("(")}
        bt_close.setOnClickListener{setTextFields(")")}
        bt_point.setOnClickListener{setTextFields(".")}
        bt_back.setOnClickListener{
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)
            result_text.text =""

        }

        bt_equal.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble()){
                    result_text.text = longRes.toString()
                }
                else
                    result_text.text = result.toString()
            }
            catch (e:Exception){
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }


        }
        bt_clear.setOnClickListener{math_operation.text=""
            math_operation.text = ""
            result_text.text =""
        }
    }
    fun setTextFields (str: String) {
        if(result_text.text!=""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }
}