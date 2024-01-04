package com.example.mvvmsharingdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvmsharingdata.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    //initialise viewModel way 1
//    private val viewModel:CounterViewModel by activityViewModels()

    //way2
    private lateinit var  viewModel:CounterViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        //way 2
        viewModel= ViewModelProvider(requireActivity()).get(CounterViewModel::class.java)


        //Here observe viewmodel data
        viewModel.getCounter().observe(viewLifecycleOwner, Observer {
            binding.value.text=it.toString()
        })

        binding.increament.setOnClickListener {
            viewModel.increament()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}