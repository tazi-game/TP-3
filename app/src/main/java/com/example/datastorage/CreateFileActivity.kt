package com.example.datastorage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged
import java.io.File

class CreateFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_create_file)

        val files_list: ArrayList<String> = ArrayList()
        val directory = getExternalFilesDir(null)?.listFiles()
        if (directory != null) {
            for (file in directory) {
                if (file.isFile) {
                    files_list.add(file.name.toString())
                }
            }
        }

        val adapter: Adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, files_list)
        val files_listView: ListView = findViewById(R.id.files_listView)
        files_listView.adapter = adapter as ListAdapter?

        val editText: EditText = findViewById<EditText>(R.id.editable_editText)
        val okButton: Button = findViewById<Button>(R.id.ok_button)

        editText.doOnTextChanged { text, _, _, _ ->
            val file_name = text.toString().trim()
            if (file_name.isNotEmpty()) {
                okButton.setOnClickListener {
                    val file: File = File(getExternalFilesDir(null), file_name+".txt")
                    if (file.createNewFile()) {
                        files_list.add(file_name+".txt")
                    }
                }
            } else {
                val popup: AlertDialog = AlertDialog.Builder(this).create()
                popup.setTitle("Error")
                popup.setMessage("Please enter a file name")
                popup.show()
            }
        }

    }
}