package com.project.cat;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;

public class BreedActivity extends AppCompatActivity {
    public static String KEY = "key";
    private ImageView image;
    private Cat item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed);
        item = (Cat) getIntent().getSerializableExtra(KEY);
        image = findViewById(R.id.image);
        TextView tvcontent = findViewById(R.id.tv_content);
        Button btColl = findViewById(R.id.btcoll);
        btColl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String data =  new Gson().toJson(item);
                SharedPreferences sp = getSharedPreferences("coll", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString(item.getId(),data);
                edit.commit();
            }
        });
        tvcontent.setText(
                "Name:"+item.getName()+"\n"
                +"Temperament:"+item.getTemperament()+"\n"
                +"Origin:"+item.getOrigin()+"\n"
                +"Description:"+item.getDescription()+"\n"
                +"Life span:"+item.getLife_span()+"\n"
                +"Weight:"+item.getWeight().metric+"\n"
                +"Dog friendliness level:"+item.getDog_friendly()+"\n"
                +"Wikipedia url:"+item.getWikipedia_url()+"\n"
        );


    makeSimpleRequest();


    }

    private void makeSimpleRequest(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://api.thecatapi.com/v1/images/search?breed_ids="+item.getId(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr = new JSONArray(response);
                            JSONObject obj = arr.getJSONObject(0);
                           String imageUrl =  obj.getString("url");
                           getImage(imageUrl);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BreedActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }
    private void getImage(String url){
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                image.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(request);
    }
}
