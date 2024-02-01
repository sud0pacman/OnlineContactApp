package com.example.onlinecontact.presentation.ui.screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlinecontact.R
import com.example.onlinecontact.data.global.response.ContactResponse
import com.example.onlinecontact.databinding.ScreenContactListBinding
import com.example.onlinecontact.presentation.ui.adapter.ContactAdapter
import com.example.onlinecontact.utils.myApply

class ContactScreen : Fragment(R.layout.screen_contact_list) {
    private val binding by viewBinding(ScreenContactListBinding::bind)
    private val viewModel by viewModels<ContactsViewModel>()
    private val adapter by lazy { ContactAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        Log.d("TTT", "onCreate view")
        contactList.adapter = adapter
//        addBtn.setOnClickListener { viewModel.openAddScreen }

        viewModel.loadContacts()
        viewModel.contactsLiveData.observe(viewLifecycleOwner, contactObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner, progressObserver)
//        viewModel.isEmpty.observe(viewLifecycleOwner, isEmptyObserver)
//        viewModel.error.observe(viewLifecycleOwner, errorObserver)
    }

    private val contactObserver = Observer<List<ContactResponse>> {
        Log.d("TTT", "${it.size}")
        adapter.submitList(it)
    }

    private val progressObserver = Observer<Boolean> {
        if (it) binding.progress.show()
        else binding.progress.hide()
    }

//    private val isEmptyObserver = Observer<Boolean> {
//        if (it) binding.empty.visibility = View.VISIBLE
//        else binding.empty.visibility = View.GONE
//    }
//
//    private val errorObserver = Observer<String> {
//        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
//        Log.d("TTT", it)
//    }


}
