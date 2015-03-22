package com.ateam.lacys.sqlite;

import java.util.ArrayList;

public class TableKeys {
	
	public static ArrayList<String>keys;

    // All tables in database
    public static final String CUSTOMER_TABLE_NAME = "Customers";
    public static final String EMPLOYEE_TABLE = "Employee";
    public static final String ORDER_DETAILS_TABLE = "Order_Details";
    public static final String ORDER_TABLE = "Orders";
    public static final String PRODUCT_RATINGS_TABLE = "Product_Ratings";
    public static final String PRODUCTS_TABLE = "Products";
    public static final String CATEGORIES_TABLE = "Categories";

    // All columns in all tables
    public static final String CUSTOMER_COLUMN_CUSTOMER_ID = "Customer_ID";
    public static final String CUSTOMER_COLUMN_FNAME = "First_Name";
    public static final String CUSTOMER_COLUMN_LNAME = "Last_Name";
    public static final String CUSTOMER_COLUMN_PWORD = "Password";

    public static final String EMPLOYEE_COLUMN_EMPLOYEE_ID = "EmployeeID";
    public static final String EMPLOYEE_COLUMN_FNAME = "First_Name";
    public static final String EMPLOYEE_COLUMN_LNAME = "Last_Name";
    public static final String EMPLOYEE_COLUMN_TITLE = "Title";
    public static final String EMPLOYEE_COLUMN_DISCOUNT = "Discount";
    public static final String EMPLOYEE_COLUMN_IMAGE = "EmpImage";
    public static final String EMPLOYEE_COLUMN_PWORD= "Password";

    public static final String CATEGORIES_COLUMN_CATEGORY_ID = "Category_ID";
    public static final String CATEGORIES_COLUMN_CATEGORY_NAME = "Category_Name";
    public static final String CATEGORIES_COLUMN_DESCRIPTION = "Description";
    public static final String CATEGORIES_COLUMN_IMAGE = "Category_Image";

    public static final String PRODUCT_COLUMN_PRODUCT_ID = "Product_ID";
    public static final String PRODUCT_COLUMN_PRODUCT_NAME = "Product_Name";
    public static final String PRODUCT_COLUMN_DESCRIPTION = "Description";
    public static final String PRODUCT_COLUMN_CATEGORY_ID = "Category_ID";
    public static final String PRODUCT_COLUMN_PRICE = "Price";
    public static final String PRODUCT_COLUMN_IN_STOCK = "InStock";
    public static final String PRODUCT_COLUMN_ON_ORDER = "OnOrder";
    public static final String PRODUCT_COLUMN_IMAGE = "Product_Image";

    public static final String ORDERS_COLUMN_ORDER_ID = "OrderID";
    public static final String ORDERS_COLUMN_PRODUCT_ID = "ProductID";
    public static final String ORDERS_COLUMN_ORDER_DATE = "OrderDate";
    public static final String ORDERS_COLUMN_FREIGHT_COST = "FreightCost";
    public static final String ORDERS_COLUMN_SHIP_ADDRESS = "ShipAddress";
    public static final String ORDERS_COLUMN_SHIP_CITY = "ShipCity";
    public static final String ORDERS_COLUMN_SHIP_POSTAL_CODE = "ShipPostalCode";

    public static final String ORDER_DETAILS_COLUMN_ORDER_ID_= "Order_ID";
    public static final String ORDER_DETAILS_COLUMN_CUSTOMER_ID = "Customer_ID";
    public static final String ORDER_DETAILS_COLUMN_EMPLOYEE_ID = "Employee_ID";
    public static final String ORDER_DETAILS_COLUMN_FREIGHT_COST = "Freight_Cost";
    public static final String ORDER_DETAILS_COLUMN_QUANTITY = "Quantity";
    public static final String ORDER_DETAILS_COLUMN_DISCOUNT = "Discount";
    public static final String ORDER_DETAILS_COLUMN_ORDER_DATE = "Order_Date";
    public static final String ORDER_DETAILS_COLUMN_SHIP_DATE = "Ship_Date";
    public static final String ORDER_DETAILS_COLUMN_SHIP_ADDRESS = "Ship_Address";
    public static final String ORDER_DETAILS_COLUMN_SHIP_POSTAL_CODE = "Ship_Postal_Code";
    public static final String ORDER_DETAILS_COLUMN_SHIP_COUNTRY = "Ship_Country";

    public static final String RATINGS_COLUMN_RATING_ID = "RatingS_ID";
    public static final String RATINGS_COLUMN_PRODUCT_ID = "Product_ID";
    public static final String RATINGS_COLUMN_RATINGS_VALUE = "Rate_Value";
    public static final String RATINGS_COLUMN_RATINGS_DATE = "Rate_Date";

	public TableKeys(){
		AddTableKeys();
	}
	
	public void AddTableKeys(){
		keys = new ArrayList<String>();
	}
}
