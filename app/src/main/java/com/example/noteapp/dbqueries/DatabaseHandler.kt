package com.example.noteapp.dbqueries

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME="notesdb"
val TABLE_NAME="notestable"
val COL_TITLE="notetitle"
val COL_NOTE="thenote"

class DatabaseHandler (var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val CreateTable="create table "+ TABLE_NAME+"("+ COL_TITLE+" text,"+ COL_NOTE +" text);"
        db?.execSQL(CreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
     //to implement
    }
    fun insertdata(notes:Notes)
    {
        val dab=this.writableDatabase
        val contentvalues=ContentValues()
        contentvalues.put(COL_TITLE,notes.title)
        contentvalues.put(COL_NOTE,notes.Note)
        val result=dab.insert(TABLE_NAME,null,contentvalues)
        if(result==0.toLong())
            Toast.makeText(context,"FAILED",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"SUCCESFULLY ADDED",Toast.LENGTH_SHORT).show()
    }

    fun readdata():MutableList<Notes>
    {
        val newnotes:MutableList<Notes> = mutableListOf<Notes>()
        val db=this.readableDatabase
        val query="select * from "+ TABLE_NAME+";"
        val result=db.rawQuery(query,null)
        if(result.moveToFirst())
        {
            do {
                val newnote=Notes()
                newnote.title=result.getString(result.getColumnIndex(COL_TITLE))
                newnote.Note=result.getString(result.getColumnIndex(COL_NOTE))
                newnotes.add(newnote)
            }while(result.moveToNext())
        }
        result.close()
        db.close()
        return newnotes
    }

    fun deletedata(title_del:String)
    {
        val db=this.writableDatabase
        val whr="delete from "+ TABLE_NAME+" where "+ COL_TITLE + "= '" + title_del +"';"
        db.execSQL(whr)

        db.close()

    }

}