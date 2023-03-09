package com.example.file31

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.file31.databinding.ActivityMainBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton


        binding.saveButton.setOnClickListener {
            saveData()

        }

       binding.getButton.setOnClickListener {

           getData()
       }






    }

    private fun saveData() {
val text=binding.inputEdit.text.toString()



        val file=File(getExternalFilesDir(null), FILE_NAME)



        FileOutputStream(file).use {
            val bytes=text.toByteArray()
            it.write(bytes)
        }




    }


    private fun getData(){


       val file=File(getExternalFilesDir(null), FILE_NAME)

        val data=FileInputStream(file).use {
            String(it.readBytes())

        }

        Log.d("ololo", (filesDir.toString() + FILE_NAME))


        Log.d("ololo",data.toString())


    }


}