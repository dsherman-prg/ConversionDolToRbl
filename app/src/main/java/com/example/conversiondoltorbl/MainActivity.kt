package com.example.conversiondoltorbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbRblToDol = findViewById<RadioButton>(R.id.idRBRblToDol)
        val rbDolToRbl = findViewById<RadioButton>(R.id.idRBDolToRbl)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener {
            val currency = DecimalFormat("###,###.00")
            val dblValue = convertNum.text.toString().toDouble()
            val dolToRblConversionRate = 72.4802
            val rblToDolConversionRate = 0.0137969
            var convertAmountNum: Double?

            if (rbDolToRbl.isChecked){
                if (dblValue < 10000){
                    convertAmountNum = dblValue * dolToRblConversionRate
                    txtResult.text = currency.format(convertAmountNum) + "₽"
                }else{
                    Toast.makeText(this@MainActivity, "Dollars to be converted must be less than $10,000", Toast.LENGTH_LONG).show()
                }
            }

            if (rbRblToDol.isChecked){
                if (dblValue < 724477){
                    convertAmountNum = dblValue * rblToDolConversionRate
                    txtResult.text = "$" + currency.format(convertAmountNum)
                }else{
                    Toast.makeText(this@MainActivity, "Rubles to be converted must be less than 724,477₽", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}