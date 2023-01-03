package kr.co.ky.weggle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kr.co.ky.navigation.*
import kr.co.ky.weggle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),   NavigationBarView.OnItemSelectedListener{
    private lateinit var binding: ActivityMainBinding

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

        when (p0.itemId) {
            R.id.home -> {
                val homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, homeFragment).commit()
                return true
            }
            R.id.brand -> {
                val brandFragment = BrandFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, brandFragment).commit()
                return true
            }
            R.id.video -> {
                val weggleFragment = WeggleFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, weggleFragment).commit()
                return true
            }
            R.id.weggler -> {
                val wegglerBlankFragment = WegglerBlankFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, wegglerBlankFragment).commit()
                return true
            }
            R.id.my -> {
                val myFragment = MyFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, myFragment).commit()
                return true
            }

        }
        return false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.bottomNavigationView.setOnItemSelectedListener(this)

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame, WegglerBlankFragment()).commit()

    }
}
