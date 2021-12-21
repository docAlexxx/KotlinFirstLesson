package com.example.kotlinfirstlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myTag: String = "myLog"

        val cat = Animal("Cat", 5, "Barsik")
        val dog = cat.copy("Dog", 7, "Tuzik")
        val horse = dog.copy("Horse", 15, "Kon")

        val animalArray = arrayOf<Animal>(cat, dog, horse)

        for (i in 0 until animalArray.size) {
            Log.d(myTag, animalArray[i].kind + "'s name is " + animalArray[i].name)
        }


    }


}