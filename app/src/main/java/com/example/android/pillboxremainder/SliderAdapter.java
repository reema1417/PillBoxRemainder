package com.example.android.pillboxremainder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Reem_ on 26/06/19.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }


    public String[] slide_desc = {"\n"+"١- يمكنك إضافة المستفيدين بالضغط على الخانة في الاسفل وتعبئة البيانات الخاصة به" + "\n"+
           "\n"+
           "٢- قم بالاتصال بعلبة الدواءالخاصة بالمستفيد الذي تريده وذلك بالضغط على خانة الاتصال بعلبة الدواء واختيار علبتك" ,
                    "\n" +
                            "٣- اختر المستفيد لترى التقسيمات الخاصة به ، اضغط على الجزء الذي ينتمي إليه الدواء ثم أضف الدواء\n" +
                            "\n" +
                            "\n" +
                            "٤- ادخل بيانات الدواء وموعد أخذه ثم أضفه بالضغط على اضافة\n"  };

    @Override
    public int getCount() {

        return slide_desc.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return view == (RelativeLayout) o;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);


        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int postion, Object object) {
        container.removeView((RelativeLayout) object);
    }
}