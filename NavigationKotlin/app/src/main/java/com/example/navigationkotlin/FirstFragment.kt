package com.example.navigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationkotlin.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

private lateinit var binding: FragmentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = FragmentFirstBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.bind(inflater.inflate(R.layout.fragment_first, container, false))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentButton1.setOnClickListener {
            //Navigation.findNavController(it).navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("iremnurgunes")
            Navigation.findNavController(it).navigate(action)

        }
    }

}