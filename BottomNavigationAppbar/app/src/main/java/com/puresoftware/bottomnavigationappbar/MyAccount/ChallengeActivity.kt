package com.puresoftware.bottomnavigationappbar.MyAccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puresoftware.bottomnavigationappbar.databinding.ActivityChallengeBinding

class ChallengeActivity : AppCompatActivity() {
    lateinit var binding:ActivityChallengeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}