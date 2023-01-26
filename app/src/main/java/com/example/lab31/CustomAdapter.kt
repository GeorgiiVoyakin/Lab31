package com.example.lab31

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab31.databinding.PersonItemBinding


class CustomAdapter(private val dataSet: Array<Person>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(private val binding: PersonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            this.binding.name.text = person.name
            this.binding.sex.setImageResource(
                when (person.sex) {
                    Sex.Male -> R.drawable.ic_outline_male_24
                    Sex.Female -> R.drawable.ic_baseline_female_24
                    Sex.Other -> R.drawable.ic_baseline_question_mark_24
                }
            )
            this.binding.phoneNumber.text = person.phoneNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataSet[position])


    override fun getItemCount() = dataSet.size
}

