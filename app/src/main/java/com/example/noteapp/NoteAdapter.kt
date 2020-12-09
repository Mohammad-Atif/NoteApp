package com.example.noteapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.dbqueries.Notes
import kotlinx.android.synthetic.main.layout_note_card.view.*
import java.util.ArrayList

class NoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var noteslist: MutableList<Notes> = mutableListOf<Notes>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return notesviewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_note_card,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is notesviewholder -> {
                holder.bind(noteslist.get(position))
//                holder.itemView.removenotebtn.setOnClickListener {
//                    noteslist=noteslist.drop(position)
//                    notifyDataSetChanged()
//                }
            }

        }
    }


    override fun getItemCount(): Int {
        return noteslist.size
    }

    fun submitList(notlists: MutableList<Notes>){
        noteslist = notlists
    }


    inner class notesviewholder constructor(itemview : View) :RecyclerView.ViewHolder(itemview){
        val notestitle=itemview.Titletextview
        val notestext=itemview.notetxtview
        val checkboxes=itemview.notecheckbox
        val doneview=itemview.donetxtview
        val rembtn=itemview.removenotebtn

        init {
            rembtn.setOnClickListener {
                val p=adapterPosition
                Toast.makeText(itemview.context,"you clicke on $p position",Toast.LENGTH_SHORT).show()
                noteslist.removeAt(p)
                notifyItemRemoved(p)
            }
        }

        fun bind(note:Notes)
        {
            notestitle.setText(note.title)
            notestext.setText(note.Note)

        }

    }

}