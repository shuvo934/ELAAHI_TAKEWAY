package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SelectedElahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ClassicDishAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ItemNameWithSauce;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.MainCourseElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.VeganMainDishAdapter;

public class ClassicDishDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> classicDishItem;

    public static ArrayList<ItemNameWithSauce> itemWithClassicDish;


    private RecyclerView apptRecyclerView;
    private ClassicDishAdapter apptAdapter;
    private RecyclerView.LayoutManager apptLayout;
    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;
    public static int tandooriCount = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.appitiser_dialogue, null);

        titleName = view.findViewById(R.id.selected_ID);
        titleName.setText(MainCourseElaahiAdult.mainCourseHeader);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        itemWithClassicDish = new ArrayList<>();

        classicDishItem = new ArrayList<>();

        classicDishItem.add(new ElaahiItem("Balti Dishes  Medium", "0","A dish having a greater proportion of hotness and those spices which lend a fiery taste to its richness."));
        classicDishItem.add(new ElaahiItem("Pathia Dishes  HOT", "0","Cooked in a mild creamy sauce with yogurt, coriander and mixed spices."));
        classicDishItem.add(new ElaahiItem("Karahi Dishes  SPICY", "0","Cooked with mixed nuts and cheese."));
        classicDishItem.add(new ElaahiItem("Korma Dishes  MILD", "0","Consisting of spinach, fresh onions and tomatoes."));
        classicDishItem.add(new ElaahiItem("Dansak Dishes  Medium", "0","A sweet and sour medium curry dish consisting of lentils, coriander & pineapples."));
        classicDishItem.add(new ElaahiItem("Bhuna Dishes  Medium", "0","A medium curry dish cooked with onions and tomatoes."));
        classicDishItem.add(new ElaahiItem("Rogan Josh Dishes  SPICY", "0","Tomato based dish cooked in a spicy sauce of onions and peppers."));
        classicDishItem.add(new ElaahiItem("Garlic Bhuna Dishes  Medium", "0","Cooked with fresh garlic in a onion and tomato sauce."));
        classicDishItem.add(new ElaahiItem("South Indian Dishes  HOT", "0","Cooked in a garlic and plum tomato sauce with roasted green chillies."));
        classicDishItem.add(new ElaahiItem("Vindaloo Dishes  HOT", "0","A dish having a greater proportion of hotness and those spices which lend a fiery taste to its richness."));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new ClassicDishAdapter(getContext(), classicDishItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < classicDishItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedClassic) {
                if (item.getMyChosenItem().contains(classicDishItem.get(i).getMyElaahiItem())) {
                    classicDishItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }

        for (int i = 0; i< MainCourseElaahiAdult.classicDishWithItem.size(); i++) {
            itemWithClassicDish.add(new ItemNameWithSauce(MainCourseElaahiAdult.classicDishWithItem.get(i).getItemSauce(),MainCourseElaahiAdult.classicDishWithItem.get(i).getQuantity()));
        }


        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemWithClassicDish.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainCourseElaahiAdult.classicDishWithItem.clear();
                MainCourseElaahiAdult.selectedClassic.clear();
                for (int i = 0; i < classicDishItem.size(); i++) {
                    if (Integer.parseInt(classicDishItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedClassic.add(new SelectedElahiItem(classicDishItem.get(i).getMyElaahiItem(), classicDishItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", classicDishItem.get(i).getMyElaahiItem());
                        Log.i("quan", classicDishItem.get(i).getMyElaahiQuantity());

                    }
                }

                for (int i = 0; i< itemWithClassicDish.size(); i++) {
                    MainCourseElaahiAdult.classicDishWithItem.add(new ItemNameWithSauce(itemWithClassicDish.get(i).getItemSauce(), itemWithClassicDish.get(i).getQuantity()));
                }
                Log.i("tandooriii: ", String.valueOf(MainCourseElaahiAdult.classicDishWithItem.size()));
//                int count = MeatAdapter.ton[0];
//                if (count == 0) {
//                    AdultElaahi.startCountadultElhi.setText(String.valueOf(count));
//                    AdultElaahi.startCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
//                }else {
//                    AdultElaahi.startCountadultElhi.setText(String.valueOf(count));
//                    AdultElaahi.startCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
//                }
//
//                MeatAdapter.ton[0] = 0;
                tandooriCount = 0;
                for (int i = 0; i< MainCourseElaahiAdult.selectedClassic.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedClassic.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedClassic.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
