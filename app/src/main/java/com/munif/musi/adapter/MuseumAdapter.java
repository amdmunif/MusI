package com.munif.musi.adapter;

/**
 * Created by Ahmad Munif on 7/15/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.munif.musi.R;
import com.munif.musi.model.Museum;

import java.util.List;


public class MuseumAdapter extends ArrayAdapter<Museum> {

    private List<Museum> museums;
    private Context mContext;

    public MuseumAdapter(@NonNull Context context, @NonNull List<Museum> museums) {
        super(context, R.layout.museum_item);
        this.museums = museums;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.museum_item,parent,false);
            holder = new ViewHolder();
            holder.nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
            holder.alamatTxt = (TextView) convertView.findViewById(R.id.alamatTxt);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Museum c = this.getItem(position);
        holder.nameTxt.setText(c.getName());
        holder.alamatTxt.setText(c.getAlamat());
        return convertView;
    }

    @Nullable
    @Override
    public Museum getItem(int position) {
        return museums.get(position);
    }

    @Override
    public int getCount() {
        return museums.size();
    }

    static class ViewHolder {
        TextView nameTxt;
        TextView alamatTxt;
    }
}
