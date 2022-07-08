package com.example.diffpriceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.OrderedRealmCollectionChangeListener
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        val students = realm.where<Product>().sort("Producttopic").findAll()
        adapter = ListAdapter(students)
        listview.adapter = adapter
        listview.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val intent = Intent(this, Calculate::class.java)
            this.startActivity(intent)
        }
        students.addChangeListener(changeListener)
    }
    private val changeListener =
        OrderedRealmCollectionChangeListener<RealmResults<Product>> { _,
                                                                      changeSet ->
            adapter.notifyDataSetChanged()
        }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}