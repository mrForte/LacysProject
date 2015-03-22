package com.ateam.lacys.sqlite;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database extends SQLiteAssetHelper {

	private static final String DATABASE_NAME = "lacys_ateam_db.sqlite";
    private static final int DATABASE_VERSION = 1;
    
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

}
