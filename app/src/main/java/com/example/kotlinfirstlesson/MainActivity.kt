package com.example.kotlinfirstlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var buttonPrev: Button
    lateinit var buttonNext: Button
    lateinit var etKind: EditText
    lateinit var etName: EditText
    lateinit var etAge: EditText
    var currentIndex = -1

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

        initViews()

    }

    fun initViews() {
        buttonPrev = findViewById(R.id.button_prev)
        buttonNext = findViewById(R.id.button_next)
        etKind = findViewById(R.id.et_animalKind)
        etName = findViewById(R.id.et_animalName)
        etAge = findViewById(R.id.et_animalAge)
    }
}