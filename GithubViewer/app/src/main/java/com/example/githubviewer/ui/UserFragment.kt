package com.example.githubviewer.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.githubviewer.R
import com.example.githubviewer.databinding.FragmentUserBinding
import com.example.githubviewer.model.User
import com.example.githubviewer.viewmodel.UserViewModel
import java.lang.Exception
import java.text.DecimalFormat

class UserFragment : Fragment() {

    lateinit private var binding : FragmentUserBinding
    lateinit private var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater , container, false)
        userViewModel = ViewModelProvider(this).get( UserViewModel::class.java)

        binding.svUser.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if( query.isNullOrEmpty() && query != null)
                {
                    userViewModel.buscarUser( query )

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               return false
            }

        })

        userViewModel.user.observe(viewLifecycleOwner, {
            try{
                setUser(it)
            }catch( ex : Exception ){
                Log.e("MI_ERROR", ex.message.toString())
                Toast.makeText(context,"Usuario no existe", Toast.LENGTH_SHORT).show()
            }
        })



        return binding.root
    }

    private fun setUser( newUser : User)
    {
        val formatter = DecimalFormat("###,###.##")
        with(binding){
            lblLogin.text = newUser.login
            lblBio.text = newUser.bio
            tvLocation.text = newUser.location
            lblFollowing.text = formatter.format(newUser.following).replace(",",".")
            lblFollowers.text = formatter.format(newUser.followers).replace(",",".")
            lblRepos.text = formatter.format(newUser.public_repos).replace(",",".")
            Glide.with(this@UserFragment).load(newUser.avatar_url).into(ivAvatar)
        }
    }


}