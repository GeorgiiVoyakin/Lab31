package com.example.lab31

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab31.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val personsData = assets.open("persons.json").bufferedReader().readText()
        val gson = Gson()
        val typeToken = object : TypeToken<Array<Person>>() {}.type
        val persons = gson.fromJson<Array<Person>>(personsData, typeToken)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(persons)
        binding.recyclerView.adapter = adapter

        binding.sortByName.setOnClickListener {
            persons.sortBy { it.name }
            adapter.notifyDataSetChanged()
        }
        binding.sortBySex.setOnClickListener {
            persons.sortBy { it.sex }
            adapter.notifyDataSetChanged()
        }
        binding.sortByPhoneNumber.setOnClickListener {
            persons.sortBy { it.phoneNumber }
            adapter.notifyDataSetChanged()
        }
    }
}