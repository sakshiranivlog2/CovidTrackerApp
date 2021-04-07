package com.example.stateapi2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stateapi2.PojoLinear;
import com.example.stateapi2.R;

import java.util.ArrayList;


public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {
    private Context context;
    private ArrayList<PojoLinear> pojoLinears;


    public AdapterRecycler(Context context, ArrayList<PojoLinear> pojoLinears) {
        this.context = context;
        this.pojoLinears = pojoLinears;
    }


    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.custom_list, parent, false );
        return new MyHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder,  int position) {
        myHolder.codeName.setText( pojoLinears.get( position ).getCodeName() );
        myHolder.image.setImageResource( pojoLinears.get( position ).getImages() );
        myHolder.codenumber.setText( pojoLinears.get( position ).getCodenumber() );



    }


    @Override
    public int getItemCount() {
        return pojoLinears.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView codeName,codenumber;
        ImageView image;



      public  MyHolder(@NonNull View itemView) {
            super( itemView );
            codeName = itemView.findViewById( R.id.code_name );
            codenumber= itemView.findViewById( R.id.code_number );
            image = itemView.findViewById( R.id.Img1 );
           // custom_list = itemView.findViewById( R.id.custom_list );


        }


    }
}

