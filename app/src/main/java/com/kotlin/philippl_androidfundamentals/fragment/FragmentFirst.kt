package com.kotlin.philippl_androidfundamentals.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.philippl_androidfundamentals.databinding.ActivityFragmentFirstBinding

class FragmentFirst : Fragment() {

    private var _binding: ActivityFragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.activity_fragment_first, container, false)
        _binding = ActivityFragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitFirstFragment.setOnClickListener {
            binding.tvFirstFragment.text = binding.iptTextFirstFragment.text.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}