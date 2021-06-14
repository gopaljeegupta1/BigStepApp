package com.gopal.bigstepapp.ui.tabs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gopal.bigstepapp.adapter.ListAdapter
import com.gopal.bigstepapp.data.entities.Results
import com.gopal.bigstepapp.databinding.FragmentListBinding
import com.gopal.bigstepapp.ui.main.InfoActivity
import com.gopal.bigstepapp.ui.vm.ListViewModel
import com.gopal.bigstepapp.utils.Resource
import com.gopal.bigstepapp.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(), ListAdapter.ItemListener {

    private var binding: FragmentListBinding by autoCleared()
    private val viewModel: ListViewModel by viewModels()
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = ListAdapter(this)
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.listFrmApi.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data.let { adapter.setItems(ArrayList(it?.results)) }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedCharacter(items: Results) {
        val intent = Intent(activity, InfoActivity::class.java)
        intent.putExtra("DATA", items)
        activity?.startActivity(intent)

        viewModel.savelistToLocal(items)
    }
}
