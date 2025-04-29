package edu.uic.cs478.spring2025.mclemproject2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.view.ContextMenu;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class GridLayoutActivity extends AppCompatActivity {
    protected static final String EXTRA_RES_ID = "POS";
    protected static final String CONTEXT_OPTION1 = "View Image";

    //array for car images
    private ArrayList<Integer> carsIds = new ArrayList<>(
            Arrays.asList(R.drawable.image01, R.drawable.image02, R.drawable.image03,
                    R.drawable.image04, R.drawable.image05, R.drawable.image06,  R.drawable.image07,
                    R.drawable.image08)
    );


    ArrayList<String> website_list = new ArrayList<String>(Arrays.asList("https://www.rolls-roycemotorcars.com/en_US/showroom/black-badge.html", "https://www.maserati.com/us/en/models/gt2-stradale","https://www.astonmartin.com/en-us/models/valhalla","https://www.porsche.com/usa/models/911/911-gt3-models/911-gt3/",
            "https://www.bugatti.com/en/models/tourbillon","https://www.mbusa.com/en/vehicles/model/sl/roadster/sl63r4","https://www.porsche.com/usa/models/911/carrera-cabriolet-models/911-carrera-s-cabriolet/","https://www.ferrari.com/en-EN/auto/gtc4lussot"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //array for car models
        String[] modelsIds_lst = getResources().getStringArray(R.array.modelsIds);
        ArrayList<String> modelsIds = new ArrayList<String>(Arrays.asList(modelsIds_lst));


        //create GridView and attach gridview layout
        GridView gridView = (GridView) findViewById(R.id.gridview);

        //instantiate and bind ImageAdapter to gridView
        gridView.setAdapter(new ImageAdapter(this, modelsIds ,carsIds));


        //define and attach event listener for each cell/item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
                intent.putExtra(EXTRA_RES_ID, (int) position);
                startActivity(intent);
            }

        });

        //register items for context menus
        registerForContextMenu(gridView);

    }



    //create context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        //inflate menu,
        getMenuInflater().inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        //get info about selected car
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        //handle menu item selected
        if(item.getItemId() == R.id.view_image) {
            Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
            intent.putExtra(EXTRA_RES_ID, (int) info.position);
            startActivity(intent);
            return true;

        } else if (item.getItemId() == R.id.view_website){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website_list.get(info.position)));
            startActivity(intent);
            return true;
        }
        else {

            //create listview
            Intent intent = new Intent(GridLayoutActivity.this, ListActivity.class);
            intent.putExtra(EXTRA_RES_ID, (int) info.position);
            startActivity(intent);


            return true;

        }
    }



}




