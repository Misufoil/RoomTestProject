package com.example.roomtestproject.screens.detail

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomtestproject.APP
import com.example.roomtestproject.R
import com.example.roomtestproject.databinding.FragmentDetailBinding
import com.example.roomtestproject.model.NoteModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            arguments?.getSerializable("note", NoteModel::class.java)!!
        else
            arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDeskDetail.text = currentNote.description

        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }


        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }

}