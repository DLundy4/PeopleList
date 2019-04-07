package com.example.peoplelist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    Activity mActivity;
    MyFriends myFriends;

    public PersonAdapter(Activity mActivity, MyFriends myFriends) {
        this.mActivity = mActivity;
        this.myFriends = myFriends;
    }

    @Override
    public int getCount() {
        return myFriends.getMyFriendsList().size();
    }

    @Override
    public Person getItem(int position) {
        return myFriends.getMyFriendsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_age = onePersonLine.findViewById(R.id.tv_age);
        ImageView iv_icon = onePersonLine.findViewById(R.id.iv_icon);

        Person p = this.getItem(position);

        tv_name.setText(p.getName());
        tv_age.setText(Integer.toString(p.getAge()));

        int icon_resource_numbers [] = {
                R.drawable.person1,
                R.drawable.person2,
                R.drawable.person3,
                R.drawable.person4,
                R.drawable.person5,
                R.drawable.person6,
                R.drawable.person7,
                R.drawable.person8,
                R.drawable.person9
        };

        iv_icon.setImageResource(icon_resource_numbers[position]);

        return onePersonLine;
    }
}
