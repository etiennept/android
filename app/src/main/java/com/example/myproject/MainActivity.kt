package com.example.myproject

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment

        navHostFragment.navController.apply {

            graph = createGraph(nav_graph.id, nav_graph.dest.firstFragmentId) {
                fragment<FirstFragment>(nav_graph.dest.firstFragmentId) {
                    label = getString(R.string.hello_first_fragment)
                    action(nav_graph.action.firstFragment_to_secondFragment) {
                        destinationId = nav_graph.dest.secondFragment
                    }


                }
                fragment<SecondFragment>(nav_graph.dest.secondFragment) {
                    label = getString(R.string.hello_second_fragment)
                    action(nav_graph.action.secondFragment_to_firstFragment) {
                        destinationId = nav_graph.dest.firstFragmentId
                    }
                    argument(nav_graph.args.plant_id) {
                        type = NavType.StringType
                    }
                }

            }
        NavHostFragment.create(R.navigation.nav_graph)

            fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }




}
