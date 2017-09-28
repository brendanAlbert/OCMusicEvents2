package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * EventListAdapter is used to build our custom layout for each item in the EventList.
 * The three member variables are:
 *
 *  1) mContent which will be the Activity where we want our EventList to display.
 *      In this case  EventListActivity will call setListAdapter and pass in a new
 *      EventListAdapter which takes "this" for its context.
 *
 *  2) mResource is the .xml file which contains the custom layout we want to display,
 *      music_event_list_item.xml, for each event in the EventList.
 *
 *  3) mAllEventsList is a list of MusicEvents which will contain all the events loaded
 *      in from the JSON file by the helper class, JSONLoader.
 *
 * Created by balbert on 9/26/2017.
 */

public class EventListAdapter extends ArrayAdapter<MusicEvent> {

    private Context mContext;
    private int mResource;
    private List<MusicEvent> mAllEventsList;

    /**
     * EventListAdapter is a constructor with three parameters.
     * This constructor is used to create a new EventListAdapter object
     * which is passed into the SetListAdapter method in EventListActivity.java.
     *
     * @param context = Activity that uses the adapter (EventListActivity)
     * @param resource = layout file to inflate (R.layout.music_event_list_item)
     * @param allMusicEvents allMusicEvents = List<MusicEvent>
     */
    public EventListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MusicEvent> allMusicEvents) {
        super(context, resource, allMusicEvents);
        mContext = context;
        mResource = resource;
        mAllEventsList = allMusicEvents;
    }

    /**
     *
     * When creating a custom view for each object, our Adapter class extends ArrayAdapter.
     * And we must override the getView method so we can inflate our custom view.
     *
     * @param position is the particular MusicEvent event tapped on by the user.
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Use "Inflater" to inflate the custom layout we just made (R.layout.music_event_list_item)
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // Inflating the custom layout for one single item in the list (repeated multiple times)
        View listItemView = inflater.inflate(mResource, null);

        ImageView listItemImageView = (ImageView) listItemView.findViewById(R.id.listItemImageView);
        TextView listItemTitleTextView = (TextView) listItemView.findViewById(R.id.listItemTitleTextView);
        TextView listItemDateTextView = (TextView) listItemView.findViewById(R.id.listItemDateTextView);

        MusicEvent selectedEvent = mAllEventsList.get(position);
        listItemTitleTextView.setText(selectedEvent.getTitle());
        listItemDateTextView.setText(selectedEvent.getDate());

        // Use the AssetManager to retrieve the image
        AssetManager am = mContext.getAssets();

        try {
            InputStream stream = am.open(selectedEvent.getImageName());
            Drawable image = Drawable.createFromStream(stream, selectedEvent.getTitle());
            listItemImageView.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listItemView;
    }
}
