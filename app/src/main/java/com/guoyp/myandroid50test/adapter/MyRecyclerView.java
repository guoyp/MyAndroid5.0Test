package com.guoyp.myandroid50test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guoyp.myandroid50test.R;
import com.guoyp.myandroid50test.RecyclerViewModel;

import java.util.ArrayList;

/**
 * Created by guoyp on 2016/2/25.
 */
public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {

    private ArrayList<RecyclerViewModel> data = getList();
    private MyRecyclerItemClick itemClick;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecyclerViewModel rvModel = data.get(position);
        holder.item_text.setText(rvModel.getTextString());
        holder.item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClick != null) itemClick.click(position);
            }
        });

    }

    public void setOnItemClick(MyRecyclerItemClick click){
        this.itemClick = click;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView item_text;
        private LinearLayout item_layout;
        public ViewHolder(View itemView) {
            super(itemView);
            item_text = (TextView) itemView.findViewById(R.id.item_text);
            item_layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        }
    }

    private ArrayList<RecyclerViewModel> getList(){
        ArrayList<RecyclerViewModel> list = new ArrayList<RecyclerViewModel>();
        for (int i=0;i<10;i++){
            RecyclerViewModel rm = new RecyclerViewModel();
            rm.setTextString("item "+ i);
            list.add(rm);
        }
        return list;
    }

    public interface MyRecyclerItemClick{
        void click(int position);
    }
}
