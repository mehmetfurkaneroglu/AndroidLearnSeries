package com.example.navigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationkotlin.databinding.FragmentFirstBinding
import com.example.navigationkotlin.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
private lateinit var binding: FragmentSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = FragmentSecondBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        //fragmentda binding böyle kullanılıyor --->
        binding = FragmentSecondBinding.bind(inflater.inflate(R.layout.fragment_second, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val kullaniciAdi = SecondFragmentArgs.fromBundle(it).username
            //println(kullaniciAdi) //logcat
            binding.textFragment2.text=kullaniciAdi
        }

        binding.fragmentButton2.setOnClickListener{
            Navigation.findNavController(it).navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())

        }
    }


}