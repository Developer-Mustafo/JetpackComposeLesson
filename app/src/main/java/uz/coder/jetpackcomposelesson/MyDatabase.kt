package uz.coder.jetpackcomposelesson

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.Int

class MyDatabase(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION),DatabaseService{
        companion object{
            const val DATABASE_NAME = "Notes_App_2023"
            const val DATABASE_VERSION = 1
            const val TABLE_NAME = "notes"
            const val STR = "str"
        }

    override fun onCreate(db: SQLiteDatabase?) {
        val a = "create table $TABLE_NAME ($STR text not null)"
        db?.execSQL(a)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun add(str: String) {
        val readableDatabase: SQLiteDatabase = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(STR, str)
        readableDatabase.insert(TABLE_NAME, null, contentValues)
    }

        override fun allList(): List<String> {
            val strList = arrayListOf<String>()
            val database: SQLiteDatabase = this.writableDatabase
            val query = "SELECT * FROM notes"
            @SuppressLint("Recycle") val cursor = database.rawQuery(query, null)
            if (cursor.moveToFirst()) {
                do {
                    val str = cursor.getString(0)
                    strList.add(str)
                } while (cursor.moveToNext())
            }
            return strList
        }
    }