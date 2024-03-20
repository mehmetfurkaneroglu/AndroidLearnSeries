 package com.eroglu.kotlinrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.eroglu.kotlinrecyclerview.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList :ArrayList<Landmark> // Landmark list adında bir arraylist tanımladım içinde de Landmark sınıfının ögeleri var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        landmarkList = ArrayList<Landmark>() //initialize ediyorum.
        //Data
        val ayasofya= Landmark("Ayasofya", "TR - İstanbul", R.drawable.ayasofya)
        val hadriyan= Landmark("Hadriyan", "TR - Antalya", R.drawable.hadriyan)
        val mevlana= Landmark("Mevlana", "TR - Konya", R.drawable.mevlana)
        landmarkList.add(ayasofya)
        landmarkList.add(hadriyan)
        landmarkList.add(mevlana)

        // Recycler View da yan yana mı yoksa alt alta mı olduguna karar vermrmiz gerkiyor.
        //Grid Layout = yan yana göster
        //LinearLayoutManager = alt alta göster
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter


        }

    }