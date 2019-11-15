package com.project.cat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tab1Fragment extends Fragment {
    public static final String url = "https://api.thecatapi.com/v1/breeds/search";
    private EditText etGo;
    private RecyclerView result;
    private ArrayList<Cat> datas;
    private RVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1,container,false);
        etGo = view.findViewById(R.id.et_go);
        result = view.findViewById(R.id.result);
        Button go = view.findViewById(R.id.bt_go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeSimpleRequest();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        datas = new ArrayList<>();
        result.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RVAdapter();
        result.setAdapter(adapter);
    }

    private void makeSimpleRequest(){
       RequestQueue queue = Volley.newRequestQueue(getActivity());
        String go = etGo.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url+"?q="+go,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("tag",response);
                        Gson gson = new Gson();
                        Cat[] objectsArray = gson.fromJson(response, Cat[].class);
                        List<Cat> dataList = Arrays.asList(objectsArray);
                        adapter.refresh(dataList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }
    class RVAdapter extends RecyclerView.Adapter{

        List<Cat> data = new ArrayList();
        private void refresh(  List<Cat> datas){
            this.data = datas;
            notifyDataSetChanged();
        }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.cat,parent,false);
            return new RvViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
           RvViewHolder rvViewHolder = (RvViewHolder) holder;
            final Cat item = data.get(position);
           rvViewHolder.textView.setText(item.getName());
           rvViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(getActivity(),BreedActivity.class);
                   intent.putExtra(BreedActivity.KEY,item);
                   startActivity(intent);
               }
           });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
    class RvViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text1);
        }
    }
}
