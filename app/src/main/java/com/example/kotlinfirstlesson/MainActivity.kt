package com.example.kotlinfirstlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cat = Animal("Cat", 5, "Barsik")
        val dog = cat.copy("Dog", 7, "Tuzik")
        val horse = dog.copy("Horse", 15, "Kon")

        val animalArray = arrayOf<Animal>(cat,dog,horse)
    }


}