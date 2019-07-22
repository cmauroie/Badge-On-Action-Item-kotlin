package com.cmauroieitemcounticommerce

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

//https://stackoverflow.com/questions/43194243/notification-badge-on-action-item-android

class MainActivity : AppCompatActivity() {

    var mCartItemCount = 10
    lateinit var cartBadge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        var menuItem = menu!!.findItem(R.id.action_cart)
        var actionView = menuItem.actionView
        cartBadge = actionView.findViewById(R.id.cart_badge)
        setupBadge()
        actionView.setOnClickListener {
            onOptionsItemSelected(menuItem)
        }
        return true
    }

    fun setupBadge() {
        cartBadge?.let {
            if (mCartItemCount == 0) {
                if (cartBadge.visibility != GONE) cartBadge.visibility = GONE
            } else {
                cartBadge.text = Random.nextInt(0, mCartItemCount).toString()
                if (cartBadge.visibility != VISIBLE) cartBadge.visibility = VISIBLE
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_cart -> {
                cartBadge.text = Random.nextInt(0, mCartItemCount).toString()
                Log.i("MainActivity", "Open Activity")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

/** let toma el resultado asignado para realizar alguna tarea

var name : String? = "Kotlin let null check"
name?.let { println(it) } //prints Kotlin let null check
name = null
name?.let { println(it) } //nothing happens

 * */

/** run toma el resultado y se puede modificar
var tutorial = "This is Kotlin Tutorial"
println(tutorial) //This is Kotlin Tutorial
tutorial = run {
val tutorial = "This is run function"
tutorial
}
println(tutorial) //This is run function
 * */


/*
    var p : String? = null
    p?.let { println("p is $p") } ?: run { println("p was null. Setting default value to: ")
        p = "Kotlin"}


* */
