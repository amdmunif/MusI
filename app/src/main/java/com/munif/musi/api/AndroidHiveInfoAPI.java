package com.munif.musi.api;

/**
 * Created by Ahmad Munif on 7/15/2017.
 */

import com.munif.musi.model.Museum;
import com.munif.musi.util.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class AndroidHiveInfoAPI implements MuseumAPI {

    private String url = "http://jendela.data.kemdikbud.go.id/api/index.php/CcariMuseum/searchGET?nama=museum";

    @Override
    public List<Museum> GetAllMuseum() {
        List<Museum> museums = new ArrayList<Museum>();
        HttpHandler h = new HttpHandler();
        String result = h.makeServiceCall(url);

        if(result != null) {
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(result);

                // Getting JSON Array node
                JSONArray museumsArray = jsonObj.getJSONArray("data");

                for(int i = 0; i < museumsArray.length(); i++) {
                    JSONObject obj = museumsArray.getJSONObject(i);

                    Museum c = new Museum();
                    c.setId(obj.getString("museum_id"));
                    c.setName(obj.getString("nama"));
                    c.setAlamat(obj.getString("alamat_jalan"));

                    museums.add(c);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return museums;
    }
}