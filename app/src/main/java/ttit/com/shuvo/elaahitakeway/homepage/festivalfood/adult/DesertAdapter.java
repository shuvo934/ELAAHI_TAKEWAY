package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;

public class DesertAdapter extends RecyclerView.Adapter<DesertAdapter.DesertViewHolder> {

    public ArrayList<AppitiserItem> myAppItem;
    public Context mAppContext;
    public static int[] ton = {0};
    //int[] total = {0};

    public DesertAdapter(Context context, ArrayList<AppitiserItem> appitiserItems){
        this.mAppContext = context;
        this.myAppItem = appitiserItems;
    }

    @NonNull
    @Override
    public DesertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mAppContext).inflate(R.layout.appitiser_list_item, parent, false);
        DesertViewHolder avh = new DesertViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull DesertViewHolder holder, int position) {

        AppitiserItem appItem = myAppItem.get(position);

        holder.appitisernName.setText(appItem.getMyAppitiserItem());
        holder.quantity.setText(appItem.getMyApptQuantity());
        holder.desc.setText(appItem.getMyItemDescription());
        if (holder.appitisernName.getText().toString().endsWith("VE")) {

            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            Log.i("paisi",holder.appitisernName.getText().toString());

        }

    }

    @Override
    public int getItemCount() {
        return myAppItem.size();
    }

    public  class DesertViewHolder extends RecyclerView.ViewHolder {

        public TextView appitisernName;
        public Button foodMinusAppt;
        public Button foodAddAppt;
        public TextView quantity;
        public TextView desc;


        public DesertViewHolder(@NonNull View itemView) {
            super(itemView);
            appitisernName = itemView.findViewById(R.id.appitiser_name);
            foodAddAppt = itemView.findViewById(R.id.plus_foodapt);
            foodMinusAppt = itemView.findViewById(R.id.minus_foodappt);
            quantity = itemView.findViewById(R.id.quantity_food_appt);
            desc = itemView.findViewById(R.id.description);
            desc.setVisibility(View.VISIBLE);



            ton[0] = 0;
            int no = Integer.parseInt(AdultFestiveCategory.num.getText().toString());

            for (int i = 0; i< myAppItem.size(); i++) {
                int hell = Integer.parseInt(myAppItem.get(i).getMyApptQuantity());

                ton[0] = ton[0] + hell;

            }

            Log.i("number of People", String.valueOf(no));
            //Log.i("number of total", String.valueOf(total[0]));
            Log.i("number of ton", String.valueOf(ton[0]));
            //total[0] = no;


            foodAddAppt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("number of People", String.valueOf(no));
                    //Log.i("number of total", String.valueOf(total[0]));
                    Log.i("number of ton", String.valueOf(ton[0]));

                    if (ton[0] == no) {
                        Toast.makeText(mAppContext,"Quantity Full",Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        String text = quantity.getText().toString();
                        int n = Integer.parseInt(text);
                        int add = n + 1;
                        quantity.setText(String.valueOf(add));
                        appitisernName.setTextColor(Color.RED);
                        myAppItem.get(getAdapterPosition()).setMyApptQuantity(String.valueOf(add));

                        ton[0] = 0;


                        for (int i = 0; i< myAppItem.size(); i++) {
                            int hell = Integer.parseInt(myAppItem.get(i).getMyApptQuantity());

                            ton[0] = ton[0] + hell;


                        }
                        Log.i("Total", String.valueOf(ton[0]));



                    }

                }
            });

            foodMinusAppt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = quantity.getText().toString();
                    int n = Integer.parseInt(text);

                    if (ton[0] == 0 && n == 0) {
                        return;
                    }else if (ton[0] != 0 && n == 0) {
                        return;
                    }else if (ton[0] <= no  && n != 0) {
                        int m = n - 1;
                        quantity.setText(String.valueOf(m));
                        myAppItem.get(getAdapterPosition()).setMyApptQuantity(String.valueOf(m));

                        if (m == 0){
                            appitisernName.setTextColor(Color.BLACK);
                        }
                        ton[0] = 0;
                        for (int i = 0; i< myAppItem.size(); i++) {
                            int hell = Integer.parseInt(myAppItem.get(i).getMyApptQuantity());

                            ton[0] = ton[0] + hell;


                        }

                    }

                }
            });


        }
    }
}
