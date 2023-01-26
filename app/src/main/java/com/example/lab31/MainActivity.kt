package com.example.lab31

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab31.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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

        binding.recyclerView.adapter = CustomAdapter(persons)

        binding.sortByName.setOnClickListener {
            binding.recyclerView.adapter =
                CustomAdapter(persons.sortedBy { it.name }.toTypedArray())
        }
        binding.sortBySex.setOnClickListener {
            binding.recyclerView.adapter =
                CustomAdapter(persons.sortedBy { it.sex }.toTypedArray())
        }
        binding.sortByPhoneNumber.setOnClickListener {
            binding.recyclerView.adapter =
                CustomAdapter(persons.sortedBy { it.phoneNumber }.toTypedArray())
        }
    }
}