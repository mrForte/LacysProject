package com.ateam.lacys.sqlite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ateam.lacys.model.ProductModel;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHandler {

	private Database dataHelper;
	SQLiteDatabase database;
	String table;
    private TableKeys tableKeys;

	public DatabaseHandler(Context context){
		dataHelper = new Database(context);
	}

	public void open()throws SQLException{
		database = dataHelper.getReadableDatabase();
	}

	public void close(){
		dataHelper.close();
	}

	public ArrayList<String>getAllTableKeys(){

		ArrayList<String>tableName = new ArrayList<String>();
		
		for(int i=0; i< TableKeys.keys.size(); i++){
			tableName.add(TableKeys.keys.get(i));
		}

		return tableName;
	}
	
	public void setTableName(String table){
		this.table = table;
	}
	
	public List<ProductModel>getAllProducts(){

        String products = "Products";

		ArrayList<ProductModel> productArray = new ArrayList<ProductModel>();
		
		String query = "SELECT * FROM " + products;
		Cursor cursor = database.rawQuery(query, null);
		
		ProductModel productModel = null;
		
		if(cursor.moveToFirst()){
			
			do{
				productModel = new ProductModel();
				productModel.setId(cursor.getInt(0));
				productModel.setBrand(cursor.getString(1));
                productModel.setCategory_id(cursor.getString(2));
                productModel.setInStock(cursor.getInt(3));
                byte[] blob = cursor.getBlob(cursor.getColumnIndex("Product_Image"));
                productModel.setImg(blob);
                productModel.setDesc(cursor.getString(6));
                productModel.setPrice(cursor.getString(7));
				productArray.add(productModel);
			}while(cursor.moveToNext());

			//cursor.close();
		}
		return productArray;
	}
	
	public int getRowCount() {
	    String countQuery = "SELECT * FROM " + table;
	    Cursor cursor = database.rawQuery(countQuery, null);
	    int cnt = cursor.getCount();
	    cursor.close();
	    return cnt;
	}
}
