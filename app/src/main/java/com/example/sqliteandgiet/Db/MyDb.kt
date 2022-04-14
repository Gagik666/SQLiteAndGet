package com.example.sqliteandgiet.Db

import android.provider.BaseColumns

object MyDb {
    const val TABLE_NAME = "uswer_table"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_REALNAME = "real_name"


    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "user.db"

    const val  CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_NAME TEXT, $COLUMN_NAME_REALNAME TEXT)"


    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}