package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/* loads a list of earthquakes by using an AsyncTask
 * to perform the network request to the given URL */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    /* query URL */
    private String mUrl;

    /**
     * Constructs a new EarthquakeLoader
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        Log.i(LOG_TAG, "TEST: onStartLoading() called...");

        forceLoad();
    }

    /* this is on a background thread */
    @Override
    public List<Earthquake> loadInBackground() {

        Log.i(LOG_TAG, "TEST: loadInBackground() called...");

        if (mUrl == null) {
            return null;
        }

        /* Perform the network request, parse the response and extract a list of earthquakes */
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
