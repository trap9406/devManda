package com.devcamp.yapp.db.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.devcamp.yapp.db.Dao.TableDao;

import javax.sql.DataSource;

/**
 * Created by Beomjun on 2016-02-26.
 */
public class DBAdapter {
    private static DBAdapter DBInstance;
    public static SQLiteDatabase mDB;
    public static DBHelper mDBHElper;
    public static TableDao Dao;
//테이블
    private static final String DATABASE_NAME = "DATABASE.db";
    private int DATABASE_VERSION = 1;

    private static final String MAIN_TABLE = "mainTable";
    private static final String SUB_TABLE1 = "subTable";
    private static final String SUB_TABLE2 = "subTable";
    private static final String SUB_TABLE3 = "subTable";
    private static final String SUB_TABLE4 = "subTable";
    private static final String SUB_TABLE5 = "subTable";
    private static final String SUB_TABLE6 = "subTable";
    private static final String SUB_TABLE7 = "subTable";
    private static final String SUB_TABLE8 = "subTable";

    public static final String MAIN_OBJECT = "main_object";
    public static final String SUB_OBJECT1 = "sub_object1";
    public static final String SUB_OBJECT2 = "sub_object2";
    public static final String SUB_OBJECT3 = "sub_object3";
    public static final String SUB_OBJECT4 = "sub_object4";
    public static final String SUB_OBJECT5 = "sub_object5";
    public static final String SUB_OBJECT6 = "sub_object6";
    public static final String SUB_OBJECT7 = "sub_object7";
    public static final String SUB_OBJECT8 = "sub_object8";


    // 싱글톤 방식
    private DBAdapter() {}

    public synchronized static DBAdapter getDBInstance() {
        if ( DBInstance == null ) {
            DBInstance = new DBAdapter();
        }
        return DBInstance;
    }
    //////////////////////////////////////------싱글톤 처리


    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){super(context, DATABASE_NAME, null, 1);}

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE IF NOT EXISTS "+MAIN_TABLE+"("+
                    "ID INTEGER PRIMARYKEY AUTOINCREMENT, "+
                    MAIN_OBJECT+" TEXT, "+
                    SUB_OBJECT1+" TEXT, "+
                    SUB_OBJECT2+" TEXT, "+
                    SUB_OBJECT3+" TEXT, "+
                    SUB_OBJECT4+" TEXT, "+
                    SUB_OBJECT5+" TEXT, "+
                    SUB_OBJECT6+" TEXT, "+
                    SUB_OBJECT7+" TEXT, "+
                    SUB_OBJECT8+" TEXT);");
            execSubDatabase(db, SUB_TABLE1);
            execSubDatabase(db, SUB_TABLE2);
            execSubDatabase(db, SUB_TABLE3);
            execSubDatabase(db,SUB_TABLE4);
            execSubDatabase(db, SUB_TABLE5);
            execSubDatabase(db,SUB_TABLE6);
            execSubDatabase(db,SUB_TABLE7);
            execSubDatabase(db, SUB_TABLE8);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLEIF EXISTS "+ MAIN_TABLE);
            db.execSQL("DROP TABLEIF EXISTS "+ SUB_OBJECT1);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT2);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT4);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT3);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT5);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT6);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT7);
            db.execSQL("DROP TABLEIF EXISTS " + SUB_OBJECT8);

            onCreate(db);
        }

    private void execSubDatabase(SQLiteDatabase db, String tableName){

        db.execSQL("CREATE TABLE IF NOT EXISTS "+tableName+"("+
                "ID INTEGER PRIMARYKEY, "+
                MAIN_OBJECT+" TEXT, "+
                SUB_OBJECT1+" TEXT, "+
                SUB_OBJECT2+" TEXT, "+
                SUB_OBJECT3+" TEXT, "+
                SUB_OBJECT4+" TEXT, "+
                SUB_OBJECT5+" TEXT, "+
                SUB_OBJECT6+" TEXT, "+
                SUB_OBJECT7+" TEXT, "+
                SUB_OBJECT8+" TEXT);");
    }
    }
    public DBAdapter open(){
        mDBHElper = new DBHelper(MyApplication.getAppContext());
        mDB = mDBHElper.getWritableDatabase();
        return this;
    }
    public void close(){
        mDB.close();
        mDBHElper.close();
    }
}
