package com.pang.howwasyourday

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_ENTRIES)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyDB"
        private const val TABLE_NAME = "AskAnswer"
        private const val COL_ID = "id"
        private const val COL_DAY = "day"
        private const val COL_ASK = "ask"
        private const val COL_ANSWER = "answer"

    private const val SQL_ENTRIES = "create table $TABLE_NAME ("+
        "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$COL_DAY VARCHAR(20)," +
            "$COL_ASK VARCHAR(100)," +
            "$COL_ANSWER VARCHAR(200))"
    }
}