package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.dbqueries.Notes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteadapter:NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addbtn.setOnClickListener {
            val intent=Intent(this,noteadding::class.java)
            startActivity(intent)
        }
//        Handler().postDelayed(
//            {
//                val intent = Intent(this, noteadding::class.java)
//                startActivity(intent)
//            },2000
//        )
        initrecyclerview()
        adddata()

    }

    private fun initrecyclerview()
    {
        recyclerviewmain.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            noteadapter= NoteAdapter()
            val topspace=Topspacingdecoration(20)
            addItemDecoration(topspace)
            adapter=noteadapter
        }
    }

    private fun createdummydatas():MutableList<Notes>
    {
        val notesdata= mutableListOf<Notes>()
        notesdata.add(Notes("Meeting","Hey i have a very important meeting tommorow"))
        notesdata.add(Notes("test","Hey this is for test blogging can be seen as a form of social networking service. Indeed, bloggers not only produce content to post on their blogs but also often build social relations with their reade"))
        notesdata.add(Notes("dummy","this is a dummy data"))
        notesdata.add(Notes("dmmy","this isdfsfgdummy data"))
        notesdata.add(Notes("dmdmy","this isdfsfg sdfgdummy data"))
        notesdata.add(Notes("Recycler view","A blog (a truncation of \"weblog\")[1] is a discussion or informational website published on the World Wide Web consisting of discrete, often informal diary-style text entries (posts). Posts are typically displayed in reverse chronological order, so that the most recent post appears first, at the top of the web page. Until 2009, blogs were usually the work of a single individual,[citation needed] occasionally of a small group, and often covered a single subject or topic."))
        notesdata.add(Notes("Recyfw","hey this isadfdf dof  test for recycler view"))
        return notesdata
    }

    private fun adddata()
    {
        val data=createdummydatas()
        noteadapter.submitList(data)
    }

}
