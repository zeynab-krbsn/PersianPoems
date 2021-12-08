package com.example.persianpoems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Items> items;
    private  Context context;

    public interface OnItemClickListener {
        void onOnItemClick(int position);
    }

    public RecyclerAdapter(Context ct,ArrayList<Items> items) {

        this.items=items;
        context = ct ;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewPoem;
        private TextView textViewPoet;
        private TextView textViewGenre;
        private ImageButton imageButtonCopy;
        private ImageButton imageButtonShare;


        public MyViewHolder(final View view) {
            super(view);
            textViewPoem=view.findViewById(R.id.textViewPoem);
            textViewPoet=view.findViewById(R.id.textViewPoet);
            textViewGenre=view.findViewById(R.id.textViewGenre);
            imageButtonCopy=view.findViewById(R.id.imageButtonCopy);
            imageButtonShare=view.findViewById(R.id.imageButtonShare);

            imageButtonCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
                    clipboardManager.setText(textViewPoem.getText().toString());
                    Toast.makeText(context.getApplicationContext(),"Copied",Toast.LENGTH_SHORT).show();
                }
            });

            imageButtonShare.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,textViewPoem.getText().toString());
                    Intent intent1=Intent.createChooser(intent,"Share");
                    view.getContext().startActivity(intent1);
                }
            });



        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String poem = items.get(position).getPoem();
        String poet = items.get(position).getPoet();
        String genre = items.get(position).getGenre();

        holder.textViewPoem.setText(poem);
        holder.textViewPoet.setText(poet);
        holder.textViewGenre.setText(genre);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
