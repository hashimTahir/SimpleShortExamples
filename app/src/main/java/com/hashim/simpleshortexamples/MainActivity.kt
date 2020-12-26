/*
 * Copyright (c) 2020/  12/ 26.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hashim.simpleshortexamples.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var hActivityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(hActivityMainBinding.root)

        hSetupListeners()

    }

    private fun hSetupListeners() {
        registerForContextMenu(hActivityMainBinding.hOpenMenuB)
        hActivityMainBinding.hOpenMenuB.setOnClickListener {
            openContextMenu(hActivityMainBinding.hOpenMenuB)
        }
    }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.floating_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.hItem1 -> Toast.makeText(this, "item 1,", Toast.LENGTH_LONG).show()
            R.id.hItem2 -> Toast.makeText(this, "item 2,", Toast.LENGTH_LONG).show()
            R.id.hItem3 -> Toast.makeText(this, "item 3,", Toast.LENGTH_LONG).show()
            R.id.hItem4 -> Toast.makeText(this, "item 4,", Toast.LENGTH_LONG).show()
        }
        return super.onContextItemSelected(item)
    }
}