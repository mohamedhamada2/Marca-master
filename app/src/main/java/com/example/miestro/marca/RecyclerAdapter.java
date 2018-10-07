package com.example.miestro.marca;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MIESTRO on 01/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

    ArrayList<Contents> arrayList = new ArrayList<>();
    Context mcontext;


    public RecyclerAdapter(ArrayList<Contents> arrayList,Context context){

        this.mcontext=context;
        this.arrayList=arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view, this.mcontext, this.arrayList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.title.setText(arrayList.get(position).getTitle());
        //holder.image.set
        Picasso.with(mcontext).load(arrayList.get(position).getUrltoimage()).into(holder.image);

      /*  holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,position+"",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(mcontext,Details.class);
                intent.putExtra("title",arrayList.get(position).getTitle());
                intent.putExtra("description",arrayList.get(position).getDescription());
                intent.putExtra("image",arrayList.get(position).getUrltoimage());




            }
        });

*/
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView image;
        CardView cardView;
        Context context;
        ArrayList<Contents> contentses = new ArrayList<Contents>();
        public MyViewHolder(View itemView,Context context,ArrayList<Contents> contentses) {
            super(itemView);
            this.contentses=contentses;
            this.context=context;
            itemView.setOnClickListener(this);
            title=(TextView)itemView.findViewById(R.id.text_list);
            image = (ImageView)itemView.findViewById(R.id.image_list);
            cardView = (CardView)itemView.findViewById(R.id.cardview);

        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Contents content=this.contentses.get(position);
            Intent intent=new Intent(this.context,Details.class);
            intent.putExtra("title",content.getTitle());
            intent.putExtra("description",content.getDescription());
            intent.putExtra("image",content.getUrltoimage());


            this.context.startActivity(intent);

        }
    }

}
