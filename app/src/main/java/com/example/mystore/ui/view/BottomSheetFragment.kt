package com.example.mystore.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystore._mainBinding
import com.example.mystore.adapters.AddressAdapter
import com.example.mystore.databinding.BottomSheetDialogBinding
import com.example.mystore.repository.AddressRepository
import com.example.mystore.viewmodel.AddressViewModel
import com.example.mystore.viewmodel.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment: BottomSheetDialogFragment() {
    private var _binding: BottomSheetDialogBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AddressAdapter
    private lateinit var homeViewModel: HomeViewModel
    private val viewModel: AddressViewModel by viewModels {
        ViewModelFactory(AddressRepository())
    }

    companion object {
        const val TAG = "BottomSheetDialogFragment"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        _binding = BottomSheetDialogBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewAddress = binding.searchRV
        recyclerViewAddress.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // Наблюдение за изменениями в LiveData
        viewModel.suggestions.observe(viewLifecycleOwner) { suggestions ->
            suggestions?.let {

                adapter = AddressAdapter(it) { address ->
                    _mainBinding?.appBarMain?.tvAdress?.text = address
                   //homeViewModel._selectedData.value = address
                    dismiss()
                }
                recyclerViewAddress.adapter = adapter
            }
        }


        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    viewModel.searchAddress(it.toString()) // Ищем адрес
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


    }

    override fun onStart() {
        super.onStart()
        val bottomSheet =
            dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.layoutParams?.height = (resources.displayMetrics.heightPixels)
    }


}

class ViewModelFactory(private val repository: AddressRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddressViewModel::class.java)) {
            return AddressViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}