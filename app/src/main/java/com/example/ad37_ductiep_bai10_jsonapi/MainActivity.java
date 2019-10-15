package com.example.ad37_ductiep_bai10_jsonapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String jsonApi = "{\"coord\":{\"lon\":105.85,\"lat\":21.03},\"weather\":[{\"id\":500,\"main\":\"Rain\"," +
            "\"description\":\"light rain\",\"icon\":\"10n\"}],\"base\":\"stations\",\"main\":{\"temp\":299.15," +
            "\"pressure\":1019,\"humidity\":74,\"temp_min\":299.15,\"temp_max\":299.15},\"visibility\":10000," +
            "\"wind\":{\"speed\":4.6,\"deg\":60},\"clouds\":{\"all\":20},\"dt\":1571063721,\"sys\":{\"type\":1," +
            "\"id\":9308,\"country\":\"VN\",\"sunrise\":1571007076,\"sunset\":1571049235},\"timezone\":25200," +
            "\"id\":1581130,\"name\":\"Hanoi\",\"cod\":200}";

    TextView tvjson,tvjson2;
    ScrollView scrview;
    Button btn1;
    String weatherS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvjson = findViewById(R.id.tvjson);
        tvjson2 = findViewById(R.id.tvjson2);
        scrview = findViewById(R.id.scrvjson);
        btn1 = findViewById(R.id.btn1);

        tvjson.setText(jsonApi);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONObject jsonObject = new JSONObject(jsonApi);

                    JSONObject coord = jsonObject.getJSONObject("coord");
                    double lon = coord.getDouble("lon");
                    double lat = coord.getDouble("lat");

                    String base = jsonObject.getString("base");

                    JSONObject main = jsonObject.getJSONObject("main");
                    double temp = main.getDouble("temp");
                    int pressure = main.getInt("pressure");
                    int humidity = main.getInt("humidity");
                    double tempmin = main.getDouble("temp_min");
                    double tempmax = main.getDouble("temp_max");


                    int visibility = jsonObject.getInt("visibility");

                    JSONObject wind = jsonObject.getJSONObject("wind");
                    double speed = wind.getDouble("speed");
                    int deg = wind.getInt("deg");

                    JSONObject clouds = jsonObject.getJSONObject("clouds");
                    int all = clouds.getInt("all");

                    long dt = jsonObject.getLong("dt");


                    JSONObject sys = jsonObject.getJSONObject("sys");
                    int type = sys.getInt("type");
                    int sysid = sys.getInt("id");
                    String country = sys.getString("country");
                    long sunrise = sys.getLong("sunrise");
                    long sunset = sys.getLong("sunset");

                    int timezone = jsonObject.getInt("timezone");
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    int cod = jsonObject.getInt("cod");

                    JSONArray weather = jsonObject.getJSONArray("weather");
                    for ( int i = 0 ; i < weather.length();i++){
                        JSONObject a = (JSONObject) weather.get(i);
                           int weatherid = a.getInt("id");
                           String wmain = a.getString("main");
                           String description = a.getString("description");
                           String icon = a.getString("icon");
                           weatherS += "   id: " + weatherid+"\n   main: "+wmain+"\n   Description: "+description+"\n   icon: "+icon;
                }

//                    tvjson2.setText("sdaf");
                    tvjson2.setText("Coordinate : "+
                            "\n   Lon: "+lon+
                            "\n   Lat: "+lat+
                            "\n\nWeather: "+
                            "\n"+weatherS+
                            "\n\nBase: "+base+
                            "\n\nMain: "+
                            "\n   Temp: "+temp+
                            "\n   Pressure: "+pressure+
                            "\n   Humidity: "+humidity+
                            "\n   Temp_Min: "+tempmin+
                            "\n   Temp_Max: "+tempmax+
                            "\n\nVisibility: " +visibility+
                            "\n\nWind: "+
                            "\n   Speed: "+speed+
                            "\n   Deg: "+deg+
                            "\n\nClouds: "+
                            "\n   All: "+all+
                            "\n\nDt: "+dt+
                            "\n\nSys: "+
                            "\n   Type: "+type+
                            "\n   Id: "+sysid+
                            "\n   Country: "+country+
                            "\n   Sunrise: "+sunrise+
                            "\n   Sunset: "+sunset+
                            "\n\nTimezone: "+timezone+
                            "\n\nId: "+id+
                            "\n\nName: "+name+
                            "\n\nCode: "+cod);
                    weatherS = "";

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


    }




    }


