package edu.uic.cs478.spring2025.mclemproject2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

//activity is called to display selected picture
public class ImageViewActivity extends Activity {

    ArrayList<String> website_list;

    //create array of bigger image
    private ArrayList<Integer> carsIds_larger = new ArrayList<>(
            Arrays.asList(R.drawable.larger_image01, R.drawable.larger_image02, R.drawable.larger_image03,
                    R.drawable.larger_image04, R.drawable.larger_image05, R.drawable.larger_image06,  R.drawable.larger_image07,
                    R.drawable.larger_image08)
    );



    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //get intent that to start activity
        Intent intent = getIntent();

        //create layout pass it
        ImageView imageView = new ImageView(getApplicationContext());

        //get ID of th image to display and set it for the imageView
        int imageId = intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0);
        imageView.setImageResource(carsIds_larger.get(imageId));

        //initialize webList
        website_list = new ArrayList<String>(Arrays.asList("https://www.rolls-roycemotorcars.com/en_US/showroom/black-badge.html", "https://www.maserati.com/us/en/models/gt2-stradale","https://www.astonmartin.com/en-us/models/valhalla","https://www.porsche.com/usa/models/911/911-gt3-models/911-gt3/",
                "https://www.bugatti.com/en/models/tourbillon","https://www.mbusa.com/en/vehicles/model/sl/roadster/sl63r4","https://www.porsche.com/usa/models/911/carrera-cabriolet-models/911-carrera-s-cabriolet/","https://www.ferrari.com/en-EN/auto/gtc4lussot"));


        //set listener
        imageView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //create intent to open website
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website_list.get(imageId)));
                startActivity(intent);

            }

        });


        //customize imageView
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //populate screen
        setContentView(imageView);


    }

}
