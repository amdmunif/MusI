package com.munif.musi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.munif.musi.adapter.MuseumAdapter;
import com.munif.musi.api.AndroidHiveInfoAPI;
import com.munif.musi.api.MuseumAPI;
import com.munif.musi.model.Museum;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MuseumAPI api;
    private ListView lv;
    private List<Museum> museums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.museumListView);
        new GetMuseum().execute();
    }

    private class GetMuseum extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                api = new AndroidHiveInfoAPI();
                museums = api.GetAllMuseum();
            }catch (final Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            MuseumAdapter adapter = new MuseumAdapter(MainActivity.this, museums);
            lv.setAdapter(adapter);
        }
    }
}
