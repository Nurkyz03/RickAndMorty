package com.geeks.hw8.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.geeks.hw8.databinding.FragmentCharacterBinding
import com.geeks.hw8.utils.Resource
import com.geeks.hw8.view.CharacterAdapter
import com.geeks.hw8.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch

class CharacterFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharacterViewModel by viewModel()
    private lateinit var charactersAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun setupObserve() {
        viewModel.getCharacters().observe(viewLifecycleOwner) { resource ->
            when (resource){
                is Resource.Success -> viewLifecycleOwner.lifecycleScope.launch {
                    binding.pgCharacter.visibility = View.GONE
                    charactersAdapter.submitData(resource.data)
                }
                is Resource.Error -> {
                    binding.pgCharacter.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), resource.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    binding.pgCharacter.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun initialize() {
        charactersAdapter = CharacterAdapter(this@CharacterFragment)
        binding.rvCharacter.adapter = charactersAdapter
    }

    override fun onClick(model: Character) {
        val action = CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(model.id)
        Log.e("TAG", "onClick: $model.id", )
        findNavController().navigate(action)
    }
}