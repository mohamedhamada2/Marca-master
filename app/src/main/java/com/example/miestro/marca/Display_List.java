package com.example.miestro.marca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Display_List extends AppCompatActivity {

    RequestQueue requestQueue;
    String Json_Url ="https://newsapi.org/v2/everything?sources=marca&apiKey=f333dafbdd154086af24eb2c29d1c98c";
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contents> arrayList=new ArrayList<Contents>();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__list);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        getlist();


    }


    public void getlist(){


      final ArrayList<Contents> content_list=new ArrayList<Contents>();




        requestQueue = Volley.newRequestQueue(this);
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

                                //  textView.append("title :- "+title+"\n"+"---------------------------"+"\n"+"description:- "+description+"\n"+"---------------------------"+"\n");

                                content_list.add(new Contents(title, description, imageurl));

                            }

                            if(content_list.size()>0) {
                                adapter = new RecyclerAdapter(content_list, Display_List.this);
                                recyclerView.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }},new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley","error");
                Toast.makeText(Display_List.this,"Volley error",Toast.LENGTH_SHORT).show();
            }
        });


        requestQueue.add(jsonObjectRequest);
      //  return content_list;


    }



}
