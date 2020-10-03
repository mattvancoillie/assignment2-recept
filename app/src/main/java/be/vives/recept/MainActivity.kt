package be.vives.recept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private val benodigdhedenWaarden: benodigdhedenWaarden = benodigdhedenWaarden()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {

        super.onStart()
        //binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding.benodigdhedenWaarden = benodigdhedenWaarden
        
        
    }

    private fun addBenodigdheden(view: View) {
        

    }
}