package com.example.sqliteandgiet.Db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToDB(name: String) {
        val values = ContentValues().apply {
            put(MyDb.COLUMN_NAME_NAME, name)
        }
        db?.insert(MyDb.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDb():ArrayList<String> {
        val datalist = ArrayList<String>()
        val cursor = db?.query(MyDb.TABLE_NAME, null, null,
            null, null, null, null,)
        while (cursor?.moveToNext()!!) {
            val dataName = cursor.getString(cursor.getColumnIndex(MyDb.COLUMN_NAME_NAME))
            datalist.add(dataName)
        }
        cursor.close()
        return datalist
    }

    fun onCloseDb() {
        myDbHelper.close()
    }
}