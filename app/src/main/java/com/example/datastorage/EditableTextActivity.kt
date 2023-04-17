package com.example.datastorage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class EditableTextActivity : AppCompatActivity() {
    val file_name = "aristide_zié.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editable_layout)

        val file: File = File(getExternalFilesDir(null), file_name)
        val file_contents = file.readText()

        val editText: EditText = findViewById<EditText>(R.id.editable_editText)
        editText.setText(file_contents)

        val okButton: Button = findViewById<Button>(R.id.ok_button)
        okButton.setOnClickListener {
            val file_contents = editText.text.toString()
            file.writeText(file_contents)
        }

        val cancelButton: Button = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            val intent = Intent(this, CreateFileActivity::class.java)
            startActivity(intent)
        }
    }
}