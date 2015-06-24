package me.dev.bkk.ncd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cengalabs.flatui.views.FlatCheckBox;
import com.cengalabs.flatui.views.FlatTextView;

import java.util.Arrays;

import me.dev.bkk.ncd.R;

/**
 * Created by BKK on 9/6/2558.
 */
public class QuestionAdapter extends BaseAdapter {

    Context context;
    String data[];
    ViewHolder  holder;


    public QuestionAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    private class ViewHolder{
        FlatTextView flatTextView;
        FlatCheckBox flatCheckBox;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_question, parent,false);
            holder = new ViewHolder();

            holder.flatTextView = (FlatTextView) convertView.findViewById(R.id.label);
            holder.flatCheckBox = (FlatCheckBox) convertView.findViewById(R.id.check);

        }else{
            holder=(ViewHolder)convertView.getTag();
        }


            holder.flatTextView.setText(position+1 +""+data[position]);


        return convertView;
    }
}
