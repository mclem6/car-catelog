package edu.uic.cs478.spring2025.mclemproject2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    private ArrayList<String> dealership_0 = new ArrayList<>(
            Arrays.asList("Rolls-Royce Motor Cars Gold Coast\n" +
                    "834 North Rush Street, Chicago, Illinois, 60611\n",
                    "Rolls-Royce Motor Cars Northbrook\n" +
                    "100 N.Skokie Blvd, Northbrook, Illinois, 60062")
    );
    private ArrayList<String> dealership_1 = new ArrayList<>(
            Arrays.asList("Maserati of Chicago\n" +
                    "834 North Rush Street, Chicago, Illinois, 60611\n",
                    "Maserati of Glenview\n" +
                    "301 Waukegan RD, Glenview, Illinois, 60025")
    );

    private ArrayList<String> dealership_2 = new ArrayList<>(
            Arrays.asList("Napleton's Aston Martin of Chicago Dealership\n" +
                    "570 W Monroe StChicago, IL 60661\n",
                    "Aston Martin Glenview\n" +
                    "301 Waukegan RD, Glenview, Illinois, 60025")
    );

    private ArrayList<String> dealership_3 = new ArrayList<>(
            Arrays.asList("Porsche Downtown Chicago\n" +
                    "217 Ogden Avenue, Downers Grove, 60515\n",
                    "Porsche Exchange\n" +
                    "2300 Skokie Valley Road, Highland Park, IL 60035")
    );

    private ArrayList<String> dealership_4 = new ArrayList<>(
            Arrays.asList("BUGATTI Gold Coast\n" +
                    "834 North Rush Street, Chicago, IL 60611\n",
                    "Perillo Downers Grove\n" +
                    "330 Ogden Ave Downers Grove, IL 60515")
    );

    private ArrayList<String> dealership_5 = new ArrayList<>(
            Arrays.asList("Loeber Motors\n" +
                    "4255 W. Touhy Avenue, Lincolnwood, IL, 60712\n",
                    "Mercedes-Benz of Chicago\n" +
                     "1520 W. North Avenue, Chicago, IL, 60642")
    );

    private ArrayList<String> dealership_6 = new ArrayList<>(
            Arrays.asList("Porsche Downtown Chicago\n" +
                    "217 Ogden Avenue, Downers Grove, 60515\n",
                    "Porsche Exchange\n" +
                    "2300 Skokie Valley Road, Highland Park, IL 60035")
    );

    private ArrayList<String> dealership_7 = new ArrayList<>(
            Arrays.asList("Continental Autosports\n" +
                    "006120, 420 E OGDEN AVE., HINSDALE, IL, 60521\n",
                    "Ferrari Lake Forest\n" +
                    "990, North Shore Drive, Lake Bluff, IL, 60044")
    );



    private ArrayList<ArrayList<String>> dealership_array = new ArrayList<>(
            Arrays.asList(dealership_0, dealership_1, dealership_2, dealership_3, dealership_4,
                    dealership_5, dealership_6, dealership_7)
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dealership_list);

        //get intent that to start activity
        Intent intent = getIntent();

        ListView listview = (ListView) findViewById(R.id.dealership);

        //get id
        int id = intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0);

        //create and set adapter
        listview.setAdapter(new ArrayAdapter<String>( this, R.layout.dealership_item, R.id.dealership_info, dealership_array.get(id)));

    }
}
