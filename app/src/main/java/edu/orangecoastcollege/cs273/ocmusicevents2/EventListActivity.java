package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

/**
 * EventListActivity is the first Controller that the user interacts with in the
 * Music Events 2 app.
 *
 * The one member variable is a List of MusicEvents which is populated from a JSON file.
 *
 * The onCreate method as usual is passed any savedInstanceState if the app is becoming
 * active again after having been in the background.
 *
 * In onCreate we try to populate the member variable with all the MusicEvents loaded from
 * the JSON file, or we catch and log any errors that might occur.
 *
 * These MusicEvents are then displayed as a list using setListAdapter.
 * This method creates our custom EventListAdapter to populate a customized view, which
 * can be seen in music_event_list_item.xml.
 *
 * When one of the list items are clicked, the onListItemClick method is called.
 * This method creates an Intent to pass the data pertaining to that particular MusicEvent.
 * This Intent is sent to the EventDetailsActivity class/Controller once passed into
 * the startActivity() method.
 *
 */
public class EventListActivity extends ListActivity {

    private List<MusicEvent> mAllEventsList;

    /**
     * onCreate uses a try/catch to surround our attempt to populate the List of MusicEvents
     * using the data from a JSON file.
     *
     * If the load is successful, we then call setListAdapter() by passing in a new
     * EventListAdapter object which we built to create our custom views for each
     * event in the eventList.
     *
     * @param savedInstanceState is the state of the app if it is coming back to life from
     *                           being minimized in the background.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mAllEventsList = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading from JSON", e);
        }

        setListAdapter(new EventListAdapter(this, R.layout.music_event_list_item, mAllEventsList));
    }

    /**
     * onListItemClick is called when the user taps one of the events in the event list.
     * Inside the method we create and populate an Intent which is passed to EventDetailsActivity.
     * @param l
     * @param v
     * @param position is the position of the MusicEvent the user tapped.  This allows us
     *                 to create an Intent populated using the data from the respective event.
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        MusicEvent selectedEvent = mAllEventsList.get(position);

        detailsIntent.putExtra("Title",     selectedEvent.getTitle());
        detailsIntent.putExtra("Date",      selectedEvent.getDate());
        detailsIntent.putExtra("Day",       selectedEvent.getDay());
        detailsIntent.putExtra("Time",      selectedEvent.getTime());
        detailsIntent.putExtra("Location",  selectedEvent.getLocation());
        detailsIntent.putExtra("Address1",  selectedEvent.getAddress1());
        detailsIntent.putExtra("Address2",  selectedEvent.getAddress2());
        detailsIntent.putExtra("ImageName", selectedEvent.getImageName());

        startActivity(detailsIntent);
    }
}
