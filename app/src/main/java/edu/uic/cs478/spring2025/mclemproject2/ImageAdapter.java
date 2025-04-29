package edu.uic.cs478.spring2025.mclemproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


//implementation of adapter
public class ImageAdapter extends BaseAdapter {

    private static final int PADDING = 0;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Context mContext;
    private List<Integer> carsIds;
    private List<String> modelsIds;


    //constructor
    public ImageAdapter(Context c, List<String> textIds, List<Integer> imageIds){
        mContext = c;
        this.carsIds = imageIds;
        this.modelsIds = textIds;
    }

    //implement abstract methods

    @Override
    public int getCount() { return carsIds.size(); }

    //returns image object
    @Override
    public Object getItem(int position) { return carsIds.get(position); }

    //returns id of image resource
    @Override
    public long getItemId(int position) { return carsIds.get(position); }

    //return imageview
    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        //check if convertView is null
        if(convertView == null) {
            //create and attach grid_item layout
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        //get reference to ImageView and TextView in grid item layout
        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_text);

        //customize grid cell params
        convertView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
        convertView.setPadding(PADDING, PADDING, PADDING, PADDING);

        //customize imageView
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //set image and text of current item
        imageView.setImageResource(carsIds.get(position));
        textView.setText(modelsIds.get(position));

        //register item for context menu



        //return view to be displayed
        return convertView;

    }



}
