package be.vives.recept

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set
import androidx.databinding.DataBindingUtil
import be.vives.recept.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val IngredientWaarden: IngredientWaarden = IngredientWaarden()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {

        super.onStart()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.ingredientWaarden = IngredientWaarden

        binding.omzettenButton.setOnClickListener(){
            addIngredientWaarden(it)
        }
    }

    private fun addIngredientWaarden(view: View) {
        //invoerveld nummer
        var numberEditText: EditText = binding.editTextNumber

        // Textview van de ingredient waarden
        var textViewRoom: TextView = binding.textViewRoom;
        var textViewMelk: TextView = binding.textViewMelk;
        var textViewVanille: TextView = binding.textViewVanille;
        var textViewEi: TextView = binding.textViewEi;
        var textViewKSuiker: TextView = binding.textViewKSuiker;
        var textViewBSuiker: TextView = binding.textViewBSuiker;
        var textViewKSuikerEL: TextView = binding.textViewKSuikerEL;

        if (binding.editTextNumber.text.isNotBlank()) {
            binding.apply {
                IngredientWaarden?.room = numberEditText.text.toString().toInt()
                IngredientWaarden?.melk = numberEditText.text.toString().toInt()
                IngredientWaarden?.vanillestokje = numberEditText.text.toString().toDouble()
                IngredientWaarden?.eieren = numberEditText.text.toString().toInt()
                IngredientWaarden?.kristalSuiker = numberEditText.text.toString().toInt()
                IngredientWaarden?.bruineSuiker = numberEditText.text.toString().toDouble()
                IngredientWaarden?.kristalSuikerAfwerking = numberEditText.text.toString().toDouble()

                numberEditText.visibility = View.GONE
                omzettenButton.visibility = View.GONE

                textViewRoom.visibility = View.VISIBLE
                textViewMelk.visibility = View.VISIBLE
                textViewVanille.visibility = View.VISIBLE
                textViewEi.visibility = View.VISIBLE
                textViewKSuiker.visibility = View.VISIBLE
                textViewBSuiker.visibility = View.VISIBLE
                textViewKSuikerEL.visibility = View.VISIBLE
            }

            val inputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        } else {
            Toast.makeText(this, "Ingredient waarden moeten ingevuld worden", Toast.LENGTH_LONG).show()
        }
        

    }
}