package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapp.dbqueries.DatabaseHandler
import com.example.noteapp.dbqueries.Notes
import kotlinx.android.synthetic.main.activity_noteadding.*

class noteadding : AppCompatActivity() {

    private lateinit var noteadapter:NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noteadding)

        addnotebtn.setOnClickListener {
            if(titletxt.text.toString().length>0 && notetxt.text.toString().length>0)
            {
                val note= Notes(titletxt.text.toString(),notetxt.text.toString())
                val db=DatabaseHandler(this)
                db.insertdata(note)
                titletxt.text.clear()
                notetxt.text.clear()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Enter in the both fields",Toast.LENGTH_SHORT).show()
            }
        }
    }


}
