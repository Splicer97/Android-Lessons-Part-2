package com.splicer.androidlessonspart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.splicer.androidlessonspart2.databinding.ContentFragmentBinding

class ContentFragment : Fragment() {
    private lateinit var binding: ContentFragmentBinding
    private val model: MainViewModel by activityViewModels()
    private var fragList = listOf(
        InfoFragment.newInstance(),
        UseCaseFragment.newInstance()
    )
    private var fragTitleList = listOf(
        "Описание",
        "Применение",
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = ContentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner){
            binding.iMain.setImageResource(it.imageId)
        }
        val adapter = VpAdapter(activity as AppCompatActivity, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tb, binding.vp2) {
                tab, pos -> tab.text = fragTitleList[pos]
        }.attach()
    }
    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}