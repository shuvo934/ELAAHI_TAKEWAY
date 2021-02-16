package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.AdultElaahi;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ClassicDishDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ClassicDishItemListDialogue;

public class ClassicDishAdapter extends RecyclerView.Adapter<ClassicDishAdapter.ClassicDishViewHolder> {

    public static ArrayList<ElaahiItem> myClassicDishItem;
    public Context mAppContext;
    public static int[] ton = {0};
    public static String itemsName;
    //int[] total = {0};

    public ClassicDishAdapter(Context context, ArrayList<ElaahiItem> appitiserItems){
        this.mAppContext = context;
        this.myClassicDishItem = appitiserItems;
    }

    @NonNull
    @Override
    public ClassicDishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mAppContext).inflate(R.layout.appitiser_list_item, parent, false);
        ClassicDishViewHolder avh = new ClassicDishViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassicDishViewHolder holder, int position) {

        ElaahiItem appItem = myClassicDishItem.get(position);

        holder.appitisernName.setText(appItem.getMyElaahiItem());
        holder.quantity.setText(appItem.getMyElaahiQuantity());
        holder.desc.setText(appItem.getMyElaahiDescription());


        if (holder.appitisernName.getText().toString().endsWith("VE")) {

            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            Log.i("paisi",holder.appitisernName.getText().toString());

        }
        if (holder.appitisernName.getText().toString().endsWith("(V) (N)")) {

            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-7, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            Log.i("paisi",holder.appitisernName.getText().toString());

        }

        if (holder.appitisernName.getText().toString().endsWith("V")) {

            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            Log.i("paisi",holder.appitisernName.getText().toString());

        }
        if (holder.appitisernName.getText().toString().endsWith("HOT"))  {

            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            Log.i("paisi",holder.appitisernName.getText().toString());

        }

        if ( holder.appitisernName.getText().toString().endsWith("Medium")) {
            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.appitisernName.getText().toString().endsWith("SPICY")) {
            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.appitisernName.getText().toString().endsWith("MILD")) {
            String text = holder.appitisernName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-4, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.appitisernName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
    }

    @Override
    public int getItemCount() {
        return myClassicDishItem.size();
    }

    public void tonClass() {
        for (int i = 0; i< myClassicDishItem.size(); i++) {
            int hell = Integer.parseInt(myClassicDishItem.get(i).getMyElaahiQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i< MainCourseElaahiAdult.selectedSignatureDish.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedSignatureDish.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i < MainCourseElaahiAdult.selectedVeganPlatter.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedVeganPlatter.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i < MainCourseElaahiAdult.selectedVeganMain.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedVeganMain.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i < MainCourseElaahiAdult.selectedTandoori.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedTandoori.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i < MainCourseElaahiAdult.selectedBiriyani.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedBiriyani.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i < MainCourseElaahiAdult.selectedMassala.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedMassala.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
        for (int i = 0; i < MainCourseElaahiAdult.selectedSpecialSeaFood.size(); i++) {
            int hell = Integer.parseInt(MainCourseElaahiAdult.selectedSpecialSeaFood.get(i).getMyChosenQuantity());

            ton[0] = ton[0] + hell;
        }
    }

    public class ClassicDishViewHolder extends RecyclerView.ViewHolder {

        public TextView appitisernName;
        public Button foodMinusAppt;
        public Button foodAddAppt;
        public TextView quantity;
        public TextView desc;

        public ClassicDishViewHolder(@NonNull View itemView) {
            super(itemView);
            appitisernName = itemView.findViewById(R.id.appitiser_name);
            foodAddAppt = itemView.findViewById(R.id.plus_foodapt);
            foodMinusAppt = itemView.findViewById(R.id.minus_foodappt);
            quantity = itemView.findViewById(R.id.quantity_food_appt);
            desc = itemView.findViewById(R.id.description);
            desc.setVisibility(View.VISIBLE);



            ton[0] = 0;
            int no = Integer.parseInt(AdultElaahi.numadultElhi.getText().toString());

            tonClass();

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
                        itemsName = myClassicDishItem.get(getAdapterPosition()).getMyElaahiItem();
                        AppCompatActivity activity = (AppCompatActivity) v.getContext();
                        ClassicDishItemListDialogue classicDishItemListDialogue = new ClassicDishItemListDialogue();
                        classicDishItemListDialogue.show(activity.getSupportFragmentManager(),"classic");

                        String text = quantity.getText().toString();
                        int n = Integer.parseInt(text);
                        int add = n + 1;
                        quantity.setText(String.valueOf(add));
                        appitisernName.setTextColor(Color.RED);
                        myClassicDishItem.get(getAdapterPosition()).setMyElaahiQuantity(String.valueOf(add));
                        Log.i("name of food: ", myClassicDishItem.get(getAdapterPosition()).getMyElaahiItem());

                        for (ItemNameWithSauce items : ClassicDishDialogue.itemWithClassicDish) {
                            //Log.i("ITEMSAUCE: ",items.getItemSauce());
                            if (items.getItemSauce().contains(myClassicDishItem.get(getAdapterPosition()).getMyElaahiItem())) {
                                Log.i("Itemsssss:", items.getItemSauce());
                                Log.i("bal hoi na",items.toString());
                                Log.i("dekhi hoi kina", String.valueOf(ClassicDishDialogue.itemWithClassicDish.indexOf(items)));

                            }

                        }

                        ton[0] = 0;


                        tonClass();
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
                        myClassicDishItem.get(getAdapterPosition()).setMyElaahiQuantity(String.valueOf(m));

                        if (m == 0){
                            appitisernName.setTextColor(Color.BLACK);
                        }

                        int numberOfIndex = 0;
                        for (ItemNameWithSauce items : ClassicDishDialogue.itemWithClassicDish) {
                            //Log.i("ITEMSAUCE: ",items.getItemSauce());
                            if (items.getItemSauce().contains(myClassicDishItem.get(getAdapterPosition()).getMyElaahiItem())) {
                                Log.i("Itemsssss:", items.getItemSauce());
                                Log.i("bal hoi na",items.toString());
                                numberOfIndex = ClassicDishDialogue.itemWithClassicDish.indexOf(items);
                                Log.i("dekhi hoi kina", String.valueOf(ClassicDishDialogue.itemWithClassicDish.indexOf(items)));

                            }

                        }
                        ClassicDishDialogue.itemWithClassicDish.remove(numberOfIndex);
                        for (ItemNameWithSauce items : ClassicDishDialogue.itemWithClassicDish) {
                            Log.i("ITEMSAUCE: ",items.getItemSauce());
                        }

                        ton[0] = 0;
                        tonClass();

                    }

                }
            });



        }
    }
}
