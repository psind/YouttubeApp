package com.example.prateek.youttubeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import com.example.prateek.youttubeapp.ui.LoginFragment
import com.example.prateek.youttubeapp.ui.SplashFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragment(SplashFragment(),false,null,false)
    }

    /**
     * This method switch fragment using frame layout without a constant toolbar
     *
     * @param fragment               Target Fragment
     * @param addToBackStack         boolean
     * @param bundle                 Bundle
     * @param hasTransitionAnimation Animate fragment transition
     * @param addFragment            If true, fragment will be added instead of replacing
     * @param tag                    addToBackStack tag name
     * @param transitionType         1 = Bottom to Top, 2 = Left to Right, 3 = Right to Left
     */
    fun switchFragment(fragment: Fragment, addToBackStack: Boolean, bundle: Bundle?, addFragment: Boolean) {
        val backStateName = fragment.javaClass.name

        var fragmentPopped = false
        try {

            fragmentPopped = supportFragmentManager.popBackStackImmediate(backStateName, 0)
        } catch (ignored: IllegalStateException) {
            // There's no way to avoid getting this if saveInstanceState has already been called.
        }

        if (!fragmentPopped) {

            // fragment does not exist in back stack
            // create checked fragment
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            if (bundle != null) {
                fragment.arguments = bundle
            }

            if (addToBackStack) {
                fragmentTransaction.addToBackStack(backStateName)
            }
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)

            if (addFragment) {
                fragmentTransaction.add(R.id.frame_container, fragment).commitAllowingStateLoss()
            } else {
                fragmentTransaction.replace(R.id.frame_container, fragment).commitAllowingStateLoss()
            }
        }
    }
}
