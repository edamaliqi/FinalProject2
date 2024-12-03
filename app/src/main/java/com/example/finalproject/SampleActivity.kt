package com.example.finalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.finalproject.R
import com.example.finalproject.R.id.switchButton

class SampleActivity : AppCompatActivity() {

    private var isFragmentAVisible = true // Track which fragment is currently displayed

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        // Set initial fragment (FragmentA)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, FragmentA()) // Add FragmentA to the container
            .commit()

        // Handle button click to switch between FragmentA and FragmentB
        val switchButton: Button = findViewById(switchButton)
        switchButton.setOnClickListener {
            switchFragment()
        }
    }

    // Function to switch between FragmentA and FragmentB
    private fun switchFragment() {
        val fragment: Fragment = if (isFragmentAVisible) {
            FragmentB() // Switch to FragmentB
        } else {
            FragmentA() // Switch to FragmentA
        }

        // Perform the fragment transaction
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment) // Replace the current fragment
            .commit()

        // Toggle the current fragment state
        isFragmentAVisible = !isFragmentAVisible
    }
}