package com.ateam.lacys.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ateam.lacys.R;
import com.ateam.lacys.model.ProductModel;
import com.ateam.lacys.sqlite.DatabaseHandler;
import com.ateam.lacys.sqlite.TableKeys;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MensFragment extends Fragment {

    private String tableName;
    private String userChoiceKey;
    private DatabaseHandler dbHandler;
    private List<ProductModel> productArray;
    private static final String TAG = "MENS FRAGMENT PRODUCTS";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mens, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dbHandler = new DatabaseHandler(getActivity());

        try {
            dbHandler.open();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<ProductModel> products = null;
        products = dbHandler.getAllProducts();

        for(int i=0; i<products.size();i++) {
            if (products.get(i).getCategory_id().equals("1")) {
                System.out.println(products.get(i).getId());
                System.out.println(products.get(i).getBrand());
                System.out.println(products.get(i).getCategory_id());
                System.out.println(products.get(i).getInStock());
                //System.out.println(products.get(i).getImg());
                System.out.println(products.get(i).getDesc());
                System.out.println(products.get(i).getPrice());
            } else {
                continue;
            }
        }

        /*LayoutInflater inflater = getActivity().getLayoutInflater();
        View child = inflater.inflate(R.layout.navigation_list,null);

        FrameLayout frame = (FrameLayout)getActivity().findViewById(R.id.container);
        frame.addView(child);*/

        /*RecyclerView list = (RecyclerView)getActivity().findViewById(R.id.cardlist);
        list.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(llm);
        //list.setItemAnimator(new DefaultItemAnimator());*/


        //adapter = new MyAdapter();
        //list.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        dbHandler.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //dbHandler.close();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
}
