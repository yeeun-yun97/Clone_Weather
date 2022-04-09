package com.github.yeeun_yun97.clone.WeatherView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class CurrencyConverterFragment : Fragment() {

    private val currencyExchangeMap =
        mapOf("USD" to 1.0, "EUR" to 0.9, "JPY" to 110.0, "KRW" to 1150.0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_currency_converter, container, false)

        val calculateButton =
            view.findViewById<Button>(R.id.CurrencyConverterFragment_calculateButton)
        val amount = view.findViewById<EditText>(R.id.CurrencyConverterFragment_amountEditText)
        val result = view.findViewById<TextView>(R.id.CurrencyConverterFragment_resultTextView)
        val fromCurrencySpinner =
            view.findViewById<Spinner>(R.id.CurrencyConverterFragment_fromSpinner)
        val toCurrencySpinner = view.findViewById<Spinner>(R.id.CurrencyConverterFragment_toSpinner)

        val currencySpinnerArrayAdapter = ArrayAdapter<String>(
            view.context,
            android.R.layout.simple_spinner_item,
            ArrayList<String>(currencyExchangeMap.keys)
        )
        currencySpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromCurrencySpinner.adapter = currencySpinnerArrayAdapter
        toCurrencySpinner.adapter = currencySpinnerArrayAdapter

        val itemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result.text = calculateCurrency(
                    amount.text.toString().toDouble(),
                    fromCurrencySpinner.selectedItem.toString(),
                    toCurrencySpinner.selectedItem.toString()
                ).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        fromCurrencySpinner.onItemSelectedListener = itemSelectedListener
        toCurrencySpinner.onItemSelectedListener = itemSelectedListener
        calculateButton.setOnClickListener {
            result.text = calculateCurrency(
                amount.text.toString().toDouble(),
                fromCurrencySpinner.selectedItem.toString(),
                toCurrencySpinner.selectedItem.toString()
            ).toString()
        }

        return view
    }



    private fun calculateCurrency(amount: Double, from: String, to: String): Double {
        var USDAmount = if (from != "USD") (amount / currencyExchangeMap[from]!!) else amount
        return currencyExchangeMap[to]!! * USDAmount
    }


}