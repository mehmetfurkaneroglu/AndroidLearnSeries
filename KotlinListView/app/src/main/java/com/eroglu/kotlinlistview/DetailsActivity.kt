package com.eroglu.kotlinlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eroglu.kotlinlistview.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // buraya gelen intenti almak için
        val intent = intent
        val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark // Casting : ben eminim bu landmark objesi
        //selectedLandmark.name.count vs ulaşamıyorum bunun için casting yapacağım.
        binding.nameText.text = selectedLandmark.name
        binding.countryText.text = selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)
    }
}