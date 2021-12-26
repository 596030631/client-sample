package com.shuaijun.client

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.iterator
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.shuaijun.client.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        mainModel.titleMessage.observe(this) {
            binding.toolbar.title = it

        }

        mainModel.showMenu.observe(this) {
            for ((i, j) in it.withIndex()) {
                menu.getItem(i).isVisible = j
            }
        }

        binding.toolbar.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.container)

        navView.setupWithNavController(navController)

        drawerToggle = ActionBarDrawerToggle(
            this,
            binding.layoutDrawer, binding.toolbar, R.string.app_name, R.string.app_name
        )
        drawerToggle.syncState()


        binding.layoutDrawer.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.d(TAG, "onDrawerOpened")

            }

            override fun onDrawerClosed(drawerView: View) {
                Log.d(TAG, "onDrawerClosed")
                drawerToggle.syncState()
            }

            override fun onDrawerStateChanged(newState: Int) {

            }

        })
    }

    override fun onCreateOptionsMenu(_menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, _menu)
        this.menu = _menu
        for (i in menu) {
            i.isVisible = false
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_back) {
            Navigation.findNavController(this, R.id.container).popBackStack()
        } else if (item.itemId == R.id.action_save) {
            Snackbar.make(binding.layoutFragment, "提交单据<开放中>", Snackbar.LENGTH_SHORT).show()
        } else if (item.itemId == R.id.action_add) {
            Snackbar.make(binding.layoutFragment, "新增单据<开放中>", Snackbar.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}