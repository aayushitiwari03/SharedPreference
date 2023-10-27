package com.student.sharedpreference

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.student.sharedpreference.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_sign_up,
                container,
                false
        )

        val sharedPreferences = requireActivity().getSharedPreferences("SHARED_PREF",MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        binding.btnSignUp.setOnClickListener {
            editor.apply {
                putString("EMAIL",binding.signUpEmail.text.toString())
                putString("PASSWORD",binding.signUpPassword.text.toString())
                apply()
            }
            (activity as MainActivity).navigateTo(SignInFragment())
        }
        return binding.root
    }

}