package eu.tutorials.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calculateButton = findViewById<Button>(R.id.btnCalculate)

        calculateButton.setOnClickListener() {

            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            if (validtateInput(weight, height)) {

                val bmi = weight.toFloat()/((height.toFloat()/100) * (height.toFloat()/100))
                // get result with 2dp
                val bmi2d = String.format("%.1f", bmi).toFloat()

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("BMI_RESULT", bmi2d)
                startActivity(intent)

            }

        }

    }

    private fun validtateInput(weight:String?, height:String?):Boolean{

        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }
            else -> {
                true
            }
        }

    }

}