package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.NameWithDesc;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NameWithDesc> myItem;

    public CustomAdapter(Context myContext, ArrayList<NameWithDesc> myItem) {
        this.context = myContext;
        this.myItem = myItem;
    }

    @Override
    public int getCount() {
        return myItem.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.full_course, parent,false);
        TextView firstName = (TextView) convertView.findViewById(R.id.course_name_spin);
        TextView secondName = (TextView) convertView.findViewById(R.id.desc_spin);

        firstName.setText(myItem.get(position).getName());
        secondName.setText(myItem.get(position).getDescription());

        if (firstName.getText().toString().endsWith("(V) (N)")) {

            String text = firstName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-7, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            firstName.setText(ss);
            Log.i("paisi",firstName.getText().toString());

        }
        return convertView;
    }
}
