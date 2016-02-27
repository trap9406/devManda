package com.devcamp.yapp.db;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.devcamp.yapp.db.DB.DBAdapter;
import com.devcamp.yapp.db.Dao.TableDao;
import com.devcamp.yapp.db.Dto.TableDto;

public class MainActivity extends AppCompatActivity {

    DBAdapter db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = DBAdapter.getDBInstance();
        db.Dao.insertData(DBAdapter.MAIN_TABLE, "dkdkdkdk", "dkshx", "dsalkj", "3jekjf", "asdkjan1", "asdkj1b",
                "asdlkfjn1", "dakljkjdaF", "asdjakldf");

        TableDto tdto = db.Dao.getData(DBAdapter.MAIN_TABLE, 1);

        System.out.println("Main Table id : " +tdto.getId());
        System.out.println("Main Table MainText : " +tdto.getMainText());
        System.out.println("Main Table SubText1 : "+tdto.getSubText1());
        System.out.println("Main Table SubText2 : "+tdto.getSubText2());
        System.out.println("Main Table SubText3 : "+tdto.getSubText3());
        System.out.println("Main Table SubText4 : "+tdto.getSubText4());
        System.out.println("Main Table SubText5 : "+tdto.getSubText5());
        System.out.println("Main Table SubText6 : "+tdto.getSubText6());
        System.out.println("Main Table SubText7 : "+tdto.getSubText7());
        System.out.println("Main Table SubText8 : "+tdto.getSubText8());
    }
}
