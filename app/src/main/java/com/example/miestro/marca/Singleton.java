package com.example.miestro.marca;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by MIESTRO on 01/02/2018.
 */

public class Singleton {

    private static Singleton mInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private Singleton(Context mcontext){

        context = mcontext;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue(){

        if (requestQueue==null){

            requestQueue = Volley.newRequestQueue(context.getApplicationContext());

        }

        return requestQueue;
    }

    public static synchronized Singleton getInstance(Context context){

        if(mInstance==null){

            mInstance = new Singleton(context);

        }

        return mInstance;
    }

    public<T> void addToRequestqueue(Request<T> request){
        requestQueue.add(request);
    }



}
