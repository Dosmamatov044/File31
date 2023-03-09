package com.example.file31

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.file31.databinding.ActivityMainBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun saveData() {
val text=binding.inputEdit.text.toString()


        Files.createDirectories(Paths.get(getExternalFilesDir(null)?.path+ "/Новая/"))
       val file=File(getExternalFilesDir(null), "Новая/$FILE_NAME")



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