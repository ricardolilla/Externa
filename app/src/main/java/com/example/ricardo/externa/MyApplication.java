package com.example.ricardo.externa;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;
import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by ricardo on 09/03/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new Migration() {
            @Override
            protected void onPreMigrate() {
                // do nothing
            }

            @Override
            protected void doMigration(SQLiteDatabase db) {
                db.execSQL(
                        "CREATE TABLE Externas (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                "Cliente TEXT,"+
                                "KmIni TEXT,"+
                                "KmFinal TEXT,"+
                                "HoraIni TEXT,"+
                                "HoraSaida TEXT,"+
                                "Data TEXT"+
                                ")"
                );
            }

            @Override
            protected void onPostMigrate() {
                // do nothing
            }
        });
    }

}