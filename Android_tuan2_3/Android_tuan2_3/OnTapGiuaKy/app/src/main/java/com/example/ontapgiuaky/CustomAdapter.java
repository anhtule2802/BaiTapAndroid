package com.example.ontapgiuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class CustomAdapter extends ArrayAdapter<NhanVien> {
    private Context context;
    private int resource;
    public ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listNV = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.customlistview,parent,false);
            viewHolder.imgGender = convertView.findViewById(R.id.imgGender);
            viewHolder.tvMaTen = convertView.findViewById(R.id.tvMaTen);
            viewHolder.cbDelete = convertView.findViewById(R.id.cbDelete);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NhanVien nv = listNV.get(position);
        viewHolder.tvMaTen.setText(nv.getId()+"-"+nv.getName());
        if (nv.isGender())
        {
            viewHolder.imgGender.setImageResource(R.drawable.icongirl);
        }
        else
        {
            viewHolder.imgGender.setImageResource(R.drawable.iconboy);
        }
        return convertView;
    }

    public class ViewHolder{
        ImageView imgGender;
        TextView tvMaTen;
        CheckBox cbDelete;
    }
}
