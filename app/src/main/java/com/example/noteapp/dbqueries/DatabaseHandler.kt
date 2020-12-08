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

}