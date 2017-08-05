package com.example.how.sqllitetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by How on 2017/8/5.
 */

public class MyAdapter extends BaseAdapter {
    private LayoutInflater myInflater;
    private List<UserData> userDataList;

    public MyAdapter(Context context, List<UserData> userDataList){
        myInflater =LayoutInflater.from(context);
        this.userDataList=userDataList;

    }

    private class ViewHolder{
        TextView txtTitle;
        TextView txtTime;
        TextView txtTime2;
        public ViewHolder(TextView txtTitle, TextView txtTime,TextView txtTime2){
            this.txtTitle = txtTitle;
            this.txtTime = txtTime;
            this.txtTime2 = txtTime2;
        }
    }

    @Override
    public int getCount() {
        return userDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return userDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userDataList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            convertView = myInflater.inflate(R.layout.mylist_layout, null);
            holder = new ViewHolder(
                    (TextView) convertView.findViewById(R.id.title),
                    (TextView) convertView.findViewById(R.id.time),
                    (TextView) convertView.findViewById(R.id.time2)
            );
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        UserData userData = (UserData) getItem(position);
        holder.txtTitle.setText(userData.getName());
        holder.txtTime.setText(userData.getInfo());
        holder.txtTime2.setText(userData.getDate());

        return convertView;

    }
}
