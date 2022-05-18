package com.example.icopaso.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.Resource
import com.example.icopaso.R
import com.example.icopaso.data.DataSource
import com.example.icopaso.data.model.Drink
import com.example.icopaso.databinding.FragmentMainBinding
import com.example.icopaso.domain.RepoImpl
import com.example.icopaso.ui.viewmodel.MainViewModel
import com.example.icopaso.ui.viewmodel.VMFactory



class MainFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by viewModels<MainViewModel>{ VMFactory(RepoImpl(DataSource())) }
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer {
            result -> when(result){
                is com.example.icopaso.vo.Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is com.example.icopaso.vo.Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvTragos.adapter = MainAdapter(requireContext(),result.data, this)
            }
                is com.example.icopaso.vo.Resource.Failure->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Ocurrió un error al traer los datos ${result.exception}", Toast.LENGTH_SHORT).show()
            }
            }
        })
    }

    private fun setupRecyclerView(){
        binding.rvTragos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onTragoClick(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("drink",drink)
        findNavController().navigate(R.id.tragosDetallesFragment)
    }

}