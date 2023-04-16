package com.example.datastorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    val file_name = "aristide_zié.txt"
    val teatcher_name = "Feuillatre"
    var fileContents = "Hello $teatcher_name!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_file_contents_label)

        val file: File = File(getExternalFilesDir(null), file_name)
        file.writeText(fileContents)
        file.createNewFile()

        val file_contents: String = file.readText()

        val fileContentsTextView: TextView = findViewById<TextView>(R.id.file_contents_textView)
        fileContentsTextView.text = file_contents
    }
}