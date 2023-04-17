package com.example.datastorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.File

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

        val edite_file_contents_button: Button = findViewById<Button>(R.id.edite_file_contents_button)
        edite_file_contents_button.setOnClickListener {
            val intent = Intent(this, EditableTextActivity::class.java)
            startActivity(intent)
        }

        val create_file_button: Button = findViewById<Button>(R.id.create_file_button)
        create_file_button.setOnClickListener {
            val intent = Intent(this, CreateFileActivity::class.java)
            startActivity(intent)
        }
    }
}