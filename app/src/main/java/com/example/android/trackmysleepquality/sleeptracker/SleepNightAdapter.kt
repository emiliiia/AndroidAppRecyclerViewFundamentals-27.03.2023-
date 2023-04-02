package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight


//клас-адаптер для RecyclerView; відповідає за відображення даних SleepNight на екрані користувача
class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    //містить список елементів SleepNight, які будуть відображені у списку RecyclerView
    var data =  listOf<SleepNight>()
        //оновлення списку даних, коли він змінюється
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //повертає кількість елементів у списку data
    override fun getItemCount() = data.size

    //прив'язує дані до TextItemViewHolder
    //встановлює текст зі значенням sleepQuality SleepNight для TextView в TextItemViewHolder
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.sleepQuality.toString()

        if (item.sleepQuality <= 1) {
            holder.textView.setTextColor(Color.RED) // red
        } else {
            // reset
            holder.textView.setTextColor(Color.BLACK) // black
        }
    }

    //створює новий екземпляр TextItemViewHolder, який буде відображати один елемент списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

}