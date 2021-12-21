package com.example.kotlinfirstlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
        var voice =""

        val cat = Animal("Cat", 5, "Barsik")
        val dog = cat.copy("Dog", 7, "Tuzik")
        val horse = dog.copy("Horse", 15, "Kon")

        val animalArray = arrayOf<Animal>(cat, dog, horse)

        for (i in 0 until animalArray.size) {
            voice = when (animalArray[i].kind){
                "Cat" -> "Meow"
                "Dog" -> "Gau-Gau"
                "Horse" -> "Igo-go"
                else -> ""
            }
            Log.d(myTag, animalArray[i].kind + "'s name is " + animalArray[i].name + ". And it says \"" + voice + "\"")
        }

        initViews()

        buttonPrev.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                etKind.setText(animalArray[currentIndex].kind)
                etName.setText(animalArray[currentIndex].name)
                etAge.setText(animalArray[currentIndex].age.toString())
            } else {
                Toast.makeText(
                    applicationContext,
                    "there isn't any previous animal",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonNext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (currentIndex < animalArray.size - 1) {
                    currentIndex++
                    etKind.setText(animalArray[currentIndex].kind)
                    etName.setText(animalArray[currentIndex].name)
                    etAge.setText(animalArray[currentIndex].age.toString())
                } else {
                    Toast.makeText(
                        applicationContext,
                        "there isn't any next animal",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        })


    }

    fun initViews() {
        buttonPrev = findViewById(R.id.button_prev)
        buttonNext = findViewById(R.id.button_next)
        etKind = findViewById(R.id.et_animalKind)
        etName = findViewById(R.id.et_animalName)
        etAge = findViewById(R.id.et_animalAge)
    }
}