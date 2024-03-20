package com.eroglu.kotlinrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eroglu.kotlinrecyclerview.databinding.RecyclerRowBinding

// implement Members istiyor, 3 tane fonksiyonu uygalamm lazım // constructerda
class LandmarkAdapter(val landmarkList : ArrayList<Landmark>): RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() { // <VH> : view holder görünüm tutucu = yardımcı sınıf Landmarkadapterdaki landmark holder
    //class LandmarkHolder(itemView : View) : RecyclerView.ViewHolder(itemView) { // Yukarda verdiğimiz ve öyle bir sınıf olmadığı için bunu burada oluşturuyoruz
    // ViewHoldr bizden görünüm istiyor itemView, sonrada LandmarkHolderda bu görünümü istiyoruz.
    // LandmarkHolder sınıfı RecyclerView sınfından bir View Holder sınıfından kalıtım alır.
    class LandmarkHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) { // benden görünüm isteme binding iste

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LandmarkHolder { //ilk oluşturulduğunda ne olacak onu anlatıyoruz. Layout ile bağlıyoruz
        val binding = RecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ) //layoutInflater alamıyoruz çünkü activitede değiliz.from hangi contextten alacağımız
        // context , viewGroup, attachtoParent Boolean(parenta bağlıyım mı diyor yani)
        return LandmarkHolder(binding) // benden itemView istiyor görünüm istiyor, onu bindinge değiştirdim.
    }

    override fun getItemCount(): Int { // bağlandıktan sonra ne olacak
        return landmarkList.size
    }

    override fun onBindViewHolder(
        holder: LandmarkHolder,
        position: Int
    ) { // kaç tane oluşturacağız bundan
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name
        holder.itemView.setOnClickListener { // itemVİew her bir eleman manasına geliyor
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java) // intent büyük veriyi yollamakta iyi değil,400 500 kb örn
            intent.putExtra("landmark", landmarkList[position])
            //MySingleton.selectedLandmark = landmarkList.get(position))
            holder.itemView.context.startActivity(intent) // holder.itemView.context. Activityde olmadığı için itemView ile ulaşıyorum
        }

    }
}