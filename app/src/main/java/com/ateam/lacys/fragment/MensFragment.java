package com.ateam.lacys.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ateam.lacys.R;
import com.ateam.lacys.activity.BagActivity;
import com.ateam.lacys.adapter.ProductAdapter;
import com.ateam.lacys.model.BagStorage;
import com.ateam.lacys.model.ProductModel;
import com.ateam.lacys.sqlite.DatabaseHandler;
import java.sql.SQLException;
import android.app.SearchManager;
import java.util.List;


public class MensFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private DatabaseHandler dbHandler;
    private List<ProductModel> products;
    private BagStorage bg;
    private int count = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mens, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

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

        products = dbHandler.getAllProducts();

        listView = (ListView) getActivity().findViewById(R.id.list);
        ProductAdapter adapter = new ProductAdapter(getActivity(),
                R.layout.navigation_list, products);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        Button btn = (Button)getActivity().findViewById(R.id.viewBag);
        btn.setText("View Bag");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BagActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
