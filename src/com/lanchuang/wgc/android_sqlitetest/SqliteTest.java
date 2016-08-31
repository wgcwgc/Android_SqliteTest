package com.lanchuang.wgc.android_sqlitetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SqliteTest extends Activity
{
	private Button createD , updateD , insert , update , query = null;

	@Override
	public void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		createD = (Button) findViewById(R.id.createD);
		updateD = (Button) findViewById(R.id.updateD);
		update = (Button) findViewById(R.id.update);
		insert = (Button) findViewById(R.id.insert);
		query = (Button) findViewById(R.id.query);

		createD.setOnClickListener(new CreateD_Listener());
		updateD.setOnClickListener(new UpdateD_Listener());
		insert.setOnClickListener(new Insert_Listener());
		update.setOnClickListener(new Update_Listener());
		query.setOnClickListener(new Query_Listener());
	}

	class CreateD_Listener implements OnClickListener
	{

		@Override
		public void onClick(View arg0 )
		{
			// TODO Auto-generated method stub
			DataBaseHelper helper = new DataBaseHelper(SqliteTest.this , "test_db");
			@SuppressWarnings("unused")
			SQLiteDatabase database = helper.getReadableDatabase();
		}

	}

	class UpdateD_Listener implements OnClickListener
	{

		@Override
		public void onClick(View arg0 )
		{
			// TODO Auto-generated method stub
			DataBaseHelper helper = new DataBaseHelper(SqliteTest.this , "test_db" , 1);
			@SuppressWarnings("unused")
			SQLiteDatabase database = helper.getReadableDatabase();
		}

	}

	class Update_Listener implements OnClickListener
	{

		@Override
		public void onClick(View arg0 )
		{
			// TODO Auto-generated method stub
			ContentValues value = new ContentValues();
			value.put("name" ,"update_thinkpad");
			DataBaseHelper helper = new DataBaseHelper(SqliteTest.this , "test_db");
			SQLiteDatabase database = helper.getWritableDatabase();
			database.update("user" ,value ,"id=?" ,new String []
			{ "2012" });
		}

	}

	class Insert_Listener implements OnClickListener
	{

		@Override
		public void onClick(View arg0 )
		{
			// TODO Auto-generated method stub
			ContentValues value = new ContentValues();
			value.put("id" ,2012);
			value.put("name" ,"thinkpad");
			DataBaseHelper helper = new DataBaseHelper(SqliteTest.this , "test_db");
			SQLiteDatabase database = helper.getWritableDatabase();
			database.insert("user" ,null ,value);
		}

	}

	class Query_Listener implements OnClickListener
	{

		@Override
		public void onClick(View arg0 )
		{
			// TODO Auto-generated method stub
			DataBaseHelper helper = new DataBaseHelper(SqliteTest.this , "test_db");
			SQLiteDatabase database = helper.getReadableDatabase();
			Cursor cursor = database.query("user" ,new String []
			{ "id", "name" } ,"id=?" ,new String []
			{ "2012" } ,null ,null ,null);
			while(cursor.moveToNext())
			{
				String name = cursor.getString(cursor.getColumnIndex("name"));
				System.out.println("query---" + name);
			}
		}

	}
}
