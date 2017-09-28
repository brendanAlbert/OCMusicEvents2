package edu.orangecoastcollege.cs273.ocmusicevents2;

/**
 * The MusicEvent class is a place holder for data corresponding to music events
 * occurring within Orange County, including title, date, day, time, location,
 * address and a corresponding image.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class MusicEvent {

    private String mTitle;
    private String mDate;
    private String mDay;
    private String mTime;
    private String mLocation;
    private String mAddress1;
    private String mAddress2;
    private String mImageName;

    /**
     *
     * @return the title of the MusicEvent
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     *
     * @param title sets the title to the title value found
     *              in the JSON file for the MusicEvent
     */
    public void setTitle(String title) {
        mTitle = title;
    }

    /**
     *
     * @return the date of the MusicEvent
     */
    public String getDate() {
        return mDate;
    }

    /**
     *
     * @param date sets the date for this date object found
     *             from the JSON file for the MusicEvent
     */
    public void setDate(String date) {
        mDate = date;
    }

    /**
     *
     * @return the day of the week of the MusicEvent
     */
    public String getDay() {
        return mDay;
    }

    /**
     *
     * @param day sets the day of the week of the MusicEvent
     */
    public void setDay(String day) {
        mDay = day;
    }

    /**
     *
     * @return return the time of the MusicEvent
     */
    public String getTime() {
        return mTime;
    }

    /**
     *
     * @param time sets the time of the MusicEvent
     */
    public void setTime(String time) {
        mTime = time;
    }

    /**
     *
     * @return the location where the MusicEvent will take place
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     *
     * @param location sets the location where the MusicEvent will take place
     */
    public void setLocation(String location) {
        mLocation = location;
    }

    /**
     *
     * @return the address1, that is, the street name and number of the MusicEvent
     */
    public String getAddress1() {
        return mAddress1;
    }

    /**
     *
     * @param address1 sets the address1, which is the street name and number for the MusicEvent
     */
    public void setAddress1(String address1) { mAddress1 = address1; }

    /**
     *
     * @return the address2, that is, the city, state and zip of the MusicEvent
     */
    public String getAddress2() {
        return mAddress2;
    }

    /**
     *
     * @param address2 sets the address2, which is, the city, state and zip of the MusicEvent
     */
    public void setAddress2(String address2) { mAddress2 = address2; }

    /**
     *
     * @return the name of the image to be displayed. This helps to choose the appropriate image
     * from the assets directory.
     */
    public String getImageName() {
        return mImageName;
    }

    /**
     *
     * @param imageName sets the name of the image to be displayed.
     */
    public void setImageName(String imageName) { mImageName = imageName; }
}
