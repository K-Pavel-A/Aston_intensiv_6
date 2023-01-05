package ru.aston.astonintensiv5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactList = ContactListFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, contactList)
            .commit()
    }

}