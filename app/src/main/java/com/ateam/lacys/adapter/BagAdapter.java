package com.ateam.lacys.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ateam.lacys.R;
import com.ateam.lacys.model.BagStorage;
import com.ateam.lacys.model.ProductModel;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Gary on 3/28/2015.
 */
public class BagAdapter extends BaseAdapter{

    private Context context;
    private static List<ProductModel> list;
    LayoutInflater inflater;

    public BagAdapter(Context context, List<ProductModel> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(this.context);        // only context can also be used
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BagViewHolder bViewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.bag_item, null);
            bViewHolder = new BagViewHolder();

            //bViewHolder.id = (TextView)convertView.findViewById(R.id.bagId);
            bViewHolder.brand = (TextView)convertView.findViewById(R.id.textBrand);
            bViewHolder.desc = (TextView)convertView.findViewById(R.id.textDesc);
            bViewHolder.price = (TextView)convertView.findViewById(R.id.textPrice);
            bViewHolder.inStock = (TextView)convertView.findViewById(R.id.textViewInStock);
            bViewHolder.img = (ImageView)convertView.findViewById(R.id.bagImage);

            convertView.setTag(bViewHolder);
        } else {
            bViewHolder = (BagViewHolder) convertView.getTag();
        }

        //bViewHolder.id.setText(list.get(0).getBrand());
        for(int i=0;i<list.size();i++) {

            bViewHolder.brand.setText(list.get(i).getBrand());
            bViewHolder.desc.setText(list.get(i).getDesc());
            bViewHolder.price.setText("Price $" + list.get(i).getPrice());
            bViewHolder.inStock.setText("In-Stock " + Integer.toString(list.get(i).getInStock()));

            byte[] outImage = list.get(i).getImg();
            ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
            Bitmap theImage = BitmapFactory.decodeStream(imageStream);
            bViewHolder.img.setImageBitmap(theImage);

        }
        return convertView;
    }

    private class BagViewHolder{
        ImageView img;
        TextView id,brand,desc,price,inStock;
    }
}
