package com.example.retrofit_multiple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_multiple.Model.Model;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Model> modelArrayList = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Model model = modelArrayList.get(position);

        holder.id.setText(model.getId().toString());
        holder.name.setText(model.getName());
        holder.username.setText(model.getUsername());
        holder.email.setText(model.getEmail());
        holder.street.setText(model.getAddress().getStreet());
        holder.suite.setText(model.getAddress().getSuite());
        holder.city.setText(model.getAddress().getCity());
        holder.zipcode.setText(model.getAddress().getZipcode());
        holder.lat.setText(model.getAddress().getGeo().getLat());
        holder.lng.setText(model.getAddress().getGeo().getLng());
        holder.phone.setText(model.getPhone());
        holder.website.setText(model.getWebsite());
        holder.company_name.setText(model.getCompany().getName());
        holder.catchPhrase.setText(model.getCompany().getCatchPhrase());
        holder.bs.setText(model.getCompany().getBs());


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, username, email, street, suite, city, zipcode, lat, lng, phone, website, company_name, catchPhrase, bs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            street = itemView.findViewById(R.id.street);
            suite = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipcode);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            company_name = itemView.findViewById(R.id.company_name);
            catchPhrase = itemView.findViewById(R.id.catchPhrase);
            bs = itemView.findViewById(R.id.bs);



        }
    }
}