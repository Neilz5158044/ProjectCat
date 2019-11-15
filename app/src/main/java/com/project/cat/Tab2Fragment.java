package com.project.cat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tab2Fragment extends Fragment {
    private RecyclerView result;
    private ArrayList<Cat> datas;
    private RVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2,container,false);
        result = view.findViewById(R.id.result);
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

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp = getActivity().getSharedPreferences("coll", Context.MODE_PRIVATE);
        Map<String,String> map=(Map<String, String>)sp.getAll();
        datas.clear();
        for(Map.Entry<String,String> entry :map.entrySet()){
            Cat cat = new Gson().fromJson(entry.getValue(),Cat.class);
            datas.add(cat);

        }
        adapter.refresh(datas);
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
