package com.example.mystore

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mystore.databinding.ActivityMainBinding
import com.example.mystore.ui.view.BottomSheetFragment
import com.google.android.material.navigation.NavigationView

var _mainBinding: ActivityMainBinding? = null

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    //private lateinit var binding: ActivityMainBinding
    //private var _binding: ActivityMainBinding? = null
    private val binding get() = _mainBinding!!

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolBar: Toolbar = binding.appBarMain.toolbar
        val tvAddress: TextView = binding.appBarMain.tvAdress
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

//        navView.itemTextColor = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.black))
//        navView.setItemBackgroundResource(R.color.white)

        toolBar.title = ""

        tvAddress.setOnClickListener {
            val dialog = BottomSheetFragment()
            dialog.show(supportFragmentManager, BottomSheetFragment.TAG)
        }

        setSupportActionBar(toolBar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}