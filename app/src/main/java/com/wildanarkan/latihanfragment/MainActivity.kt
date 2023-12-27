package com.wildanarkan.latihanfragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wildanarkan.latihanfragment.databinding.ActivityMainBinding
import com.wildanarkan.latihanfragment.ui.theme.LatihanFragmentTheme


class MainActivity : AppCompatActivity() {
    private val fragHome: Fragment = HomeFragment()
    private val fragInfo: Fragment = InfoFragment()
    private val fragContact: Fragment = ContactFragment()
    private val fragCategory: Fragment = CategoryFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragHome
    private lateinit var btn_navi_view : BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_navi_view = findViewById(R.id.btn_navi_view)
        setUpNaviButton()

    }

    private fun setUpNaviButton() {
        fm.beginTransaction().add(R.id.navi_content, fragHome).show(fragHome).commit()
        fm.beginTransaction().add(R.id.navi_content, fragInfo).hide(fragInfo).commit()
        fm.beginTransaction().add(R.id.navi_content, fragContact).hide(fragContact).commit()
        fm.beginTransaction().add(R.id.navi_content, fragCategory).hide(fragCategory).commit()

        fm.beginTransaction().commit()

        menu = btn_navi_view.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true
        btn_navi_view.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.navi_home -> {
                    callFrag(0, fragHome)
                }
                R.id.navi_info -> {
                    callFrag(2, fragInfo)
                }
                R.id.navi_contact -> {
                    callFrag(3, fragContact)
                }
                R.id.navi_category -> {
                    callFrag(1, fragCategory)
                }
            }
            false
        }


    }

    private fun callFrag(i: Int, fragment: Fragment) {
            menuItem = menu.getItem(i)
            menuItem.isChecked = true

            fm.beginTransaction().hide(active).show(fragment).commit()
            active = fragment
    }


}
