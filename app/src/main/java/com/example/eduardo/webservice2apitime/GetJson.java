package com.example.eduardo.webservice2apitime;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by eduardo on 28/03/18.
 */

class GetJson extends AsyncTask<Void,Void,Void>{
    String data ="";
    String [] ciudad = {"Amsterdam", "Oslo"};
    String [] pais = {"Netherlands", "Norway"};
    String [] dataParsed = new String[ciudad.length];

    @Override
    protected Void doInBackground(Void... voids) {
        for(int i = 0; i<ciudad.length; i++) {
            data="";
            try {
                URL url = new URL("");
                HttpURLConnection httpURLConnection = (HttpURLConnection)
                        url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new
                        InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }

                JSONObject JO = new JSONObject(data);
                dataParsed [i]= "Ciudad: " + JO.getJSONArray("locations").getJSONObject(0).getJSONObject("geo").get("name") + "\n"
                              + "Pais: " +  pais[i] + "\n"
                              + "Hora: " + JO.getJSONArray("locations").getJSONObject(0).getJSONObject("time").getJSONObject("datetime").get("hour") + ":" +
                                            JO.getJSONArray("locations").getJSONObject(0).getJSONObject("time").getJSONObject("datetime").get("minute");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        MainActivity.amsterdam.setText(this.dataParsed[0]);
        MainActivity.oslo.setText(this.dataParsed[1]);
    }
}
