package com.example.prototipo1.eventoprototipo11;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.ItemViewHolder> {
    private Context mcontext;
    private ArrayList<ItemEvent> mitemlist;
    public OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickLister(OnItemClickListener listener){
        mlistener =listener;
    }

    public ItemAdaptor(Context context, ArrayList<ItemEvent> itemlist){
        mcontext=context;
        mitemlist=itemlist;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.items_event, viewGroup , false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        ItemEvent currentitem = mitemlist.get(i);
        String mimage= currentitem.getMimageurl();
        String mtitle=currentitem.getMtitle();
        String mlugar=currentitem.getMlugar();

        itemViewHolder.mtexttitle.setText(mtitle);
        itemViewHolder.mtextlugar.setText("lugar: "+mlugar);
        Picasso.get()
                .load(mimage)
                .fit()
                .centerInside()
                .into(itemViewHolder.mimageview);

    }

    @Override
    public int getItemCount() {
        return mitemlist.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView mimageview;
        public TextView mtexttitle;
        public TextView mtextlugar;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageview=itemView.findViewById(R.id.image_view_h);
            mtexttitle=itemView.findViewById(R.id.text_title_h);
            mtextlugar=itemView.findViewById(R.id.text_lugar_h);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mlistener != null){
                        int position =getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            mlistener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
