package com.fdhasna21.androidstudio_dicoding_myfaves

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rowAdapter = RowAdapter(Groups.listData, this)
        recycler_view.addItemDecoration(object : DividerItemDecoration(this, DividerItemDecoration.VERTICAL){})
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = rowAdapter


        rowAdapter.setOnItemClickCallback(object : RowAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Group) {
                selectedRow = data
                startActivity(Intent(this@MainActivity, GroupDetailActivity::class.java))
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_about -> {
                startActivity(Intent(this, AboutMeActivity::class.java)) //AboutMeActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}