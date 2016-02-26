package com.devcamp.yapp.db.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.devcamp.yapp.db.DB.DBAdapter;
import com.devcamp.yapp.db.DB.DataSources;

/**
 * Created by Beomjun on 2016-02-27.
 */
public class TableDao {
    public static SQLiteDatabase mDB;

    public DataSources getData(String table, int id){
        DataSources temp= null;
        Cursor cursor = mDB.rawQuery("SELECT *FROM "+table+" WHERE id "+id+";",null);
        cursor.moveToFirst();
        Log.d("tag", cursor.getCount() + "");
        temp = new DataSources();

        if(cursor.getCount() == 0){
            return temp;
        }
        temp.setId(cursor.getInt(0));
        temp.setMainText(cursor.getString(1));
        temp.setSubText1(cursor.getString(2));
        temp.setSubText2(cursor.getString(3));
        temp.setSubText3(cursor.getString(4));
        temp.setSubText4(cursor.getString(5));
        temp.setSubText5(cursor.getString(6));
        temp.setSubText6(cursor.getString(7));
        temp.setSubText7(cursor.getString(8));
        temp.setSubText8(cursor.getString(9));

        return temp;
    }
    public void insertData(String table, String m, String s1, String s2, String s3, String s4,
                           String s5, String s6, String s7, String s8){
        ContentValues cv = new ContentValues();

        cv.put(DBAdapter.MAIN_OBJECT, m);
        cv.put(DBAdapter.SUB_OBJECT1, s1);
        cv.put(DBAdapter.SUB_OBJECT2, s2);
        cv.put(DBAdapter.SUB_OBJECT3, s3);
        cv.put(DBAdapter.SUB_OBJECT4, s4);
        cv.put(DBAdapter.SUB_OBJECT5, s5);
        cv.put(DBAdapter.SUB_OBJECT6, s6);
        cv.put(DBAdapter.SUB_OBJECT7, s7);
        cv.put(DBAdapter.SUB_OBJECT8, s8);

        mDB.insert(table, null, cv);
    }

    public Cursor getAllUser(String table) {
        Cursor all = mDB.query(table, null, null, null, null, null, null);
        return all;
    }

}
