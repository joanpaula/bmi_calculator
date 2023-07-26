package eu.tutorials.bmicalculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bmiResult = intent.getFloatExtra("BMI_RESULT", 0.0F)

        displayResult(bmiResult)
    }

    private fun displayResult(bmi:Float) {

        val resultIndex = findViewById<TextView>(R.id.tvindex)
        val resultDescription = findViewById<TextView>(R.id.rangeStatus)


        resultIndex.text = bmi.toString()

        var resultText =  ""
        var color = 0

        when {
            bmi<18.5 -> {
                resultText = "Underweight"
                color = R.color.babyblue
            }

            bmi in 18.5 .. 24.9 -> {
                resultText = "Healthy"
                color = R.color.green
            }

            bmi in 25.0 .. 29.9 -> {
                resultText = "Overweight"
                color = R.color.yellow
            }

            bmi > 30.0 -> {
                resultText = "Obese"
                color = R.color.orange
            }
        }

        resultDescription.setBackgroundResource(R.drawable.changeround)
        resultDescription.setBackgroundColor(ContextCompat.getColor(this, color))
        resultDescription.text = resultText

    }
}