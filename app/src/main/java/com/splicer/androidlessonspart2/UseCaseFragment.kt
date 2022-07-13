package com.splicer.androidlessonspart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.splicer.androidlessonspart2.databinding.InfoFragmentBinding
import com.splicer.androidlessonspart2.databinding.UseCaseFragmentBinding

class UseCaseFragment : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private lateinit var binding: UseCaseFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UseCaseFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner){
            binding.tvUseCase.text = it.useCase
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = UseCaseFragment()
    }
}