package com.student.sharedpreference

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.student.sharedpreference.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_sign_in,
                container,
                false
        )
        val sharedPreferences = requireActivity().getSharedPreferences("SHARED_PREF",android.content.Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("EMAIL","")
        val password = sharedPreferences.getString("PASSWORD","")
        binding.btnSignIn.setOnClickListener {
            if (email == binding.signInEmail.text.toString() && password == binding.signInPassword.text.toString()) {
                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}