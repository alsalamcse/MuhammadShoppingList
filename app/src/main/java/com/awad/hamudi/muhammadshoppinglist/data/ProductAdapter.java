package com.awad.hamudi.muhammadshoppinglist.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.awad.hamudi.muhammadshoppinglist.R;

/**
 * Created by user on 14/12/2017.
 */

public class ProductAdapter extends ArrayAdapter<product>
{
    /**
     *
     * @param context
     * @param resource the item XML file ex. R.layout.product_item
     */
    public ProductAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    /**
     * todo מספר סידןרי של הנתון (עצם) ממקור הניתונים
     * @param position the index of one item from the data (object) source. starting from zero
     * @param convertView
     * todo הממשק שיכול להציג אוסף ניתונים לדוגמה listView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.product_item,parent,false);
        TextView itmTvName= (TextView) view.findViewById(R.id.itmTvName);
        TextView itmTvPrice= (TextView) view.findViewById(R.id.itmTvPrice);
        TextView itmTAmount= (TextView) view.findViewById(R.id.itmTvAmount);
        ImageView itmImage= (ImageView) view.findViewById(R.id.itmImage);
        CheckBox itmChbIsCompleted= (CheckBox) view.findViewById(R.id.itmChbIsCompleted);
        product p=getItem(position);
        itmTvName.setText(p.getName());
        itmTvPrice.setText(p.getPrice()+"");
        itmTAmount.setText(p.getAmount()+"");
        itmChbIsCompleted.setChecked(p.iscompleted());
        return view;
    }
}