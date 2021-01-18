package com.example.hamza.earth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RecAdapterr extends RecyclerView.Adapter<RecAdapterr.v> {


    private ArrayList<Model> model = new ArrayList<>();
    Context context;
    private ItemListner listner;

    public RecAdapterr(ArrayList<Model> models, Context context) {
        this.model = models;
    }



    @Override
    public v onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item, parent, false);


        return new v(v);
    }

    public void setListner(ItemListner listner) {
        this.listner = listner;
    }
    @Override
    public void onBindViewHolder( RecAdapterr.v holder, int position) {
        holder.str.setText( formatMagnitude(model.get(position).getStr()));
        holder.loc.setText(model.get(position).getLocation());
        holder.date.setText(model.get(position).getDate());


/*
        GradientDrawable magnitudeCircle = (GradientDrawable) holder.str.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor =  (getMagnitudeColor( model.get(position).getStr()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);*/
    }

    @Override
        public int getItemCount () {
            return model.size();
        }


    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    public ArrayList<Model> getItem() {
        return model;
    }
    /*private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
       int magnitudeFloor= (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(context, magnitudeColorResourceId);
    }*/

        class v extends RecyclerView.ViewHolder {
        TextView str,loc,date;
            v(View itemView) {
                super(itemView);
                str= (TextView) itemView.findViewById(R.id.str);
                loc= (TextView) itemView.findViewById(R.id.location);
                date= (TextView) itemView.findViewById(R.id.date);
                itemView.setOnClickListener((e) -> {
                    listner.onItemCLicked(getAdapterPosition());
                });



            }
        }
    }