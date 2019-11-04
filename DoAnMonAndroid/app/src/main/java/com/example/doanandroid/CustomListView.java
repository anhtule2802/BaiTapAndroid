package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListView extends ArrayAdapter<DetailTable> {
    private Context context;
    private int resource;
    private ArrayList<DetailTable> listDetail = new ArrayList<DetailTable>();
    public CustomListView(@NonNull Context context, int resource, @NonNull ArrayList<DetailTable> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listDetail = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_custom_list_view,parent,false);
            viewHolder.tvContent = convertView.findViewById(R.id.tvContent);
            viewHolder.tvTime = convertView.findViewById(R.id.tvTime);
            viewHolder.tvID = convertView.findViewById(R.id.tvID);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        DetailTable dt = listDetail.get(position);
        viewHolder.tvTime.setText(dt.getTime());
        viewHolder.tvContent.setText(dt.getContentDetail());
        viewHolder.tvID.setText(String.valueOf(dt.getMaDetail()));
        return convertView;
    }
    public class ViewHolder{
        TextView tvContent;
        TextView tvTime;
        TextView tvID;
    }
}
