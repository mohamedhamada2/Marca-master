package com.example.miestro.marca;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MIESTRO on 01/02/2018.
 */

public class BackgroundTask {
    Context context;
    ArrayList<Contents> arrayList = new ArrayList<>();
    String Json_Url ="https://newsapi.org/v2/everything?sources=marca&apiKey=f333dafbdd154086af24eb2c29d1c98c";
    String x="";
    RequestQueue requestQueue;

    public BackgroundTask(Context context){

        this.context = context;

    }




    public ArrayList getList(){


        requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,Json_Url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");

                            for(int i=0;i<jsonArray.length();i++){

                                JSONObject respons = jsonArray.getJSONObject(i);
                                String title=respons.getString("title");
                                String description=respons.getString("description");
                                String imageurl=respons.getString("urlToImage");


                                arrayList.add(new Contents(title,description,imageurl));

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }},new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley","error");
                Toast.makeText(context,"Volley error",Toast.LENGTH_SHORT).show();
            }
        });



        requestQueue.add(jsonObjectRequest);
        return arrayList;
    }



}
