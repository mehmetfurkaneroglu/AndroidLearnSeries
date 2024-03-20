 package com.eroglu.kotlinlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.eroglu.kotlinlistview.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var LandmarkList :ArrayList<Landmark> // Landmark list adında bir arraylist tanımladım içinde de Landmark sınıfının ögeleri var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LandmarkList = ArrayList<Landmark>() //initialize ediyorum.
        //Data
        val ayasofya= Landmark("Ayasofya", "TR - İstanbul", R.drawable.ayasofya)
        val hadriyan= Landmark("Hadriyan", "TR - Antalya", R.drawable.hadriyan)
        val mevlana= Landmark("Mevlana", "TR - Konya", R.drawable.mevlana)
        LandmarkList.add(ayasofya)
        LandmarkList.add(hadriyan)
        LandmarkList.add(mevlana)

        //Adapter : Layout ve Data'yı bağlıyor
        //val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,LandmarkList)//(context, xml, göstereceğimiz şey)LandmarkListin hafızadaki yerleri gözüküyor.
        //Mapping : Listeleri dönüştürmeye yarıyor.
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,LandmarkList.map {landmark -> landmark.name })//landmarkı landmark.name' e dönüştürdük. Landmark name gözüküyor
        binding.listView.adapter=adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  // position kaçıncıya tıklandı
            val intent = Intent(MainActivity@this, DetailsActivity::class.java) //şuan neredeyiz ve nereye gidiyoruz. Main -> Detail'e
            /*
            intent.putExtra("landmark",LandmarkList.get(position).name) // putExtra diyerek herhangş bir değer seçip karşı tarafa yolluyoruz.
            intent.putExtra("landmark",LandmarkList.get(position).country) // bunun yerine Landmark sınıfının serileştirilebilir olması gerekiyor
            ....
             */
            intent.putExtra("landmark",LandmarkList.get(position)) // serileştirdiim sınıfı yolluyorum.
            startActivity(intent)
        }



    }
}