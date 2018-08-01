package com.example.prateek.youttubeapp.ui

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prateek.youttubeapp.MainFragment
import com.example.prateek.youttubeapp.R

class SplashFragment : MainFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fargment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            getMainActivity()?.switchFragment(LoginFragment(),false,null,false)
        }, 1500)
    }
}