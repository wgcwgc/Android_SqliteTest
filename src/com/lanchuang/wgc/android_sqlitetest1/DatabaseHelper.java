package com.lanchuang.wgc.android_sqlitetest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
	// ��û��ʵ����,�ǲ����������๹�����Ĳ���,��������Ϊ��̬
	private static final String name = "count"; // ���ݿ�����

	private static final int version = 1; // ���ݿ�汾

	public DatabaseHelper(Context context)
	{
		// ����������CursorFactoryָ����ִ�в�ѯʱ���һ���α�ʵ���Ĺ�����,����Ϊnull,����ʹ��ϵͳĬ�ϵĹ�����
		super(context , name , null , version);
	}

	@Override
	public void onCreate(SQLiteDatabase db )
	{
		db.execSQL("CREATE TABLE IF NOT EXISTS person (personid integer primary key autoincrement, name varchar(20), age INTEGER)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion )
	{

		db.execSQL("ALTER TABLE person ADD phone VARCHAR(12)"); // ����������һ��

	}
}

