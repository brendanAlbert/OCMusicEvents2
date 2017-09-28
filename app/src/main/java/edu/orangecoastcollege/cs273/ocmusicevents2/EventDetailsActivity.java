package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * EventDetailsActivity is the Controller which helps display the View after a user taps
 * an event from the event list.
 *
 * This controller sets the content view.
 *
 * The Intent sent from EventListActivity is received in the onCreate method.
 *
 * Each of the ImageView and TextView widgets is wired up in this Controller and then
 * populated with the appropriate data.
 *
 * Take note that the way an image is retrieved and populated is a little more involved
 * than text. A try/catch is wrapped around some code that opens a stream and creates a
 * drawable.
 */
public class EventDetailsActivity extends AppCompatActivity {

    /**
     * onCreate:
     * 1) sets the content view using the activity_event_details.xml layout.
     * 2) Receives the Intent sent from EventListActivity.
     * 3) Populates the ImageView and TextViews with the data from the Intent.
     *
     * @param savedInstanceState sets the state from when the app was in the background,
     *                           if applicable.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent = getIntent();
        String imageFileName = intent.getStringExtra("ImageName");

        ImageView eventImageView       = (ImageView) findViewById(R.id.eventImageView);
        TextView eventTitleTextView    = (TextView) findViewById(R.id.eventTitleTextView);
        TextView eventDateTextView     = (TextView) findViewById(R.id.eventDateTextView);
        TextView eventTimeTextView     = (TextView) findViewById(R.id.eventTimeTextView);
        TextView eventLocationTextView = (TextView) findViewById(R.id.eventLocationTextView);
        TextView eventAddress1TextView = (TextView) findViewById(R.id.eventAddress1TextView);
        TextView eventAddress2TextView = (TextView) findViewById(R.id.eventAddress2TextView);


        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, intent.getStringExtra("Title"));
            eventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }
        eventTitleTextView.setText(intent.getStringExtra("Title"));
        eventDateTextView.setText(intent.getStringExtra("Date") + " - " + intent.getStringExtra("Day"));
        eventTimeTextView.setText(intent.getStringExtra("Time"));
        eventLocationTextView.setText(intent.getStringExtra("Location"));
        eventAddress1TextView.setText(intent.getStringExtra("Address1"));
        eventAddress2TextView.setText(intent.getStringExtra("Address2"));


    }
}
