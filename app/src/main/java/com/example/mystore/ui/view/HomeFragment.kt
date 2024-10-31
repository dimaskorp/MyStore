package com.example.mystore.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystore.databinding.FragmentHomeBinding
import com.example.mystore.viewmodel.HomeViewModel

@SuppressLint("StaticFieldLeak")
class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerViewCategories = binding.categoriesRecView
        recyclerViewCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewBanner = binding.bannerRecView
        recyclerViewBanner.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewStock = binding.stockRecView
        recyclerViewStock.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewCatalog = binding.catalogRecView
        recyclerViewCatalog.layoutManager = GridLayoutManager(requireContext(), 3)


        homeViewModel.listCategories.observe(viewLifecycleOwner) {
            recyclerViewCategories.adapter = it
        }

        homeViewModel.listPromo.observe(viewLifecycleOwner) {
            recyclerViewBanner.adapter = it
        }

        homeViewModel.listStock.observe(viewLifecycleOwner) {
            recyclerViewStock.adapter = it
        }

        homeViewModel.listCatalog.observe(viewLifecycleOwner) {
            recyclerViewCatalog.adapter = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
