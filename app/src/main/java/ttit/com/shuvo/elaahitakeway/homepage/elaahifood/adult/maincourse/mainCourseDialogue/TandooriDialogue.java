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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ItemNameWithSauce;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.MainCourseElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.TandooriAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.MeatAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterElaahiAdult;

public class TandooriDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> tandoorIMCItem;

    public static ArrayList<ItemNameWithSauce> itemNameWithSauces;


    private RecyclerView apptRecyclerView;
    private TandooriAdapter apptAdapter;
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

        itemNameWithSauces = new ArrayList<>();

        tandoorIMCItem = new ArrayList<>();

        tandoorIMCItem.add(new ElaahiItem("Tandoori Chicken", "0",""));
        tandoorIMCItem.add(new ElaahiItem("Lamb Tikka", "0",""));
        tandoorIMCItem.add(new ElaahiItem("Tandoori Mix Grill", "0","Tandoori chicken, chicken tikka, lamb tikka, onion and garlic seek kebab"));
        tandoorIMCItem.add(new ElaahiItem("Chicken tikka", "0","Grilled with onions, tomatoes & peppers."));
        tandoorIMCItem.add(new ElaahiItem("Lamb Tikka Shashlik", "0","Grilled with onions, tomatoes & peppers."));
        tandoorIMCItem.add(new ElaahiItem("Chicken Biraan  Medium", "0","Chicken breast fillet cooked with fried onions and selected spices."));
        tandoorIMCItem.add(new ElaahiItem("Mumbai Grilled Chilli Chicken  HOT", "0","Fresh chicken fillets marinated and grilled. Served with stir fried onions and crushed chillies."));
        tandoorIMCItem.add(new ElaahiItem("Tandoori King Prawns", "0",""));
        tandoorIMCItem.add(new ElaahiItem("Tandoori King Prawn Shashlick", "0","Grilled with onions, tomatoes & peppers."));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new TandooriAdapter(getContext(), tandoorIMCItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < tandoorIMCItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedTandoori) {
                if (item.getMyChosenItem().contains(tandoorIMCItem.get(i).getMyElaahiItem())) {
                    tandoorIMCItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }

        for (int i = 0; i< MainCourseElaahiAdult.tandooriItem.size(); i++) {
            itemNameWithSauces.add(new ItemNameWithSauce(MainCourseElaahiAdult.tandooriItem.get(i).getItemSauce(),MainCourseElaahiAdult.tandooriItem.get(i).getQuantity()));
        }


        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemNameWithSauces.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainCourseElaahiAdult.tandooriItem.clear();
                MainCourseElaahiAdult.selectedTandoori.clear();
                for (int i = 0; i < tandoorIMCItem.size(); i++) {
                    if (Integer.parseInt(tandoorIMCItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedTandoori.add(new SelectedElahiItem(tandoorIMCItem.get(i).getMyElaahiItem(), tandoorIMCItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", tandoorIMCItem.get(i).getMyElaahiItem());
                        Log.i("quan", tandoorIMCItem.get(i).getMyElaahiQuantity());

                    }
                }

                for (int i = 0; i< itemNameWithSauces.size(); i++) {
                    MainCourseElaahiAdult.tandooriItem.add(new ItemNameWithSauce(itemNameWithSauces.get(i).getItemSauce(),itemNameWithSauces.get(i).getQuantity()));
                }
                Log.i("tandooriii: ", String.valueOf(MainCourseElaahiAdult.tandooriItem.size()));
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
                for (int i = 0; i< MainCourseElaahiAdult.selectedTandoori.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedTandoori.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(0).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(0).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedTandoori.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
