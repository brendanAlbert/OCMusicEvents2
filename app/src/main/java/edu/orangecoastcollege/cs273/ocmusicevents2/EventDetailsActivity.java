package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static edu.orangecoastcollege.cs273.ocmusicevents2.R.id.eventImageView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);


        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String imageName = intent.getStringExtra("ImageName");
        String date = intent.getStringExtra("Date");
        String day = intent.getStringExtra("Day");
        String time = intent.getStringExtra("Time");
        String location = intent.getStringExtra("Location");
        String address1 = intent.getStringExtra("Address1");
        String address2 = intent.getStringExtra("Address2");

        //String imageFileName = title.replace(" ", "") + ".jpeg";
        String imageFileName = 

        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);
        TextView eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView eventDateTextView = (TextView) findViewById(R.id.eventDateTextView);
        TextView eventDayTextView = (TextView) findViewById(R.id.eventDayTextView);
        TextView eventTimeTextView = (TextView) findViewById(R.id.eventTimeTextView);


        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }
        eventTitleTextView.setText(title);
        eventDateTextView.setText(date);
        eventDayTextView.setText(day);
        eventTimeTextView.setText(time);
        eventTitleTextView.setText(title);
        eventDateTextView.setText(date);


    }

    protected void goBackToList(View v)
    {
        finish();
    }
}
