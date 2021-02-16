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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.VeganMainDishAdapter;

public class VeganMainDishDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> veganMainItem;

    public static ArrayList<ItemNameWithSauce> itemwithVegetable;


    private RecyclerView apptRecyclerView;
    private VeganMainDishAdapter apptAdapter;
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

        itemwithVegetable = new ArrayList<>();

        veganMainItem = new ArrayList<>();

        veganMainItem.add(new ElaahiItem("Vegetable Balti  Medium", "0",""));
        veganMainItem.add(new ElaahiItem("Chickpeas Balti  Medium", "0",""));
        veganMainItem.add(new ElaahiItem("Vegetable Pathia", "0",""));
        veganMainItem.add(new ElaahiItem("Vegetable Karahi", "0",""));
        veganMainItem.add(new ElaahiItem("Vegan Korma", "0","(HOT includes cocunut milk)"));
        veganMainItem.add(new ElaahiItem("Vegan Mossalla", "0","(Mild includes cocunut milk)"));
        veganMainItem.add(new ElaahiItem("Vegan Dansak  Medium", "0",""));
        veganMainItem.add(new ElaahiItem("Vegan Bhuna", "0",""));
        veganMainItem.add(new ElaahiItem("Vegan Rogan Josh", "0",""));
        veganMainItem.add(new ElaahiItem("Vegan Garlic Bhuna Medium", "0",""));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new VeganMainDishAdapter(getContext(), veganMainItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < veganMainItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedVeganMain) {
                if (item.getMyChosenItem().contains(veganMainItem.get(i).getMyElaahiItem())) {
                    veganMainItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }

        for (int i = 0; i< MainCourseElaahiAdult.veganMainItemWithChoice.size(); i++) {
            itemwithVegetable.add(new ItemNameWithSauce(MainCourseElaahiAdult.veganMainItemWithChoice.get(i).getItemSauce(),MainCourseElaahiAdult.veganMainItemWithChoice.get(i).getQuantity()));
        }


        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemwithVegetable.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainCourseElaahiAdult.veganMainItemWithChoice.clear();
                MainCourseElaahiAdult.selectedVeganMain.clear();
                for (int i = 0; i < veganMainItem.size(); i++) {
                    if (Integer.parseInt(veganMainItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedVeganMain.add(new SelectedElahiItem(veganMainItem.get(i).getMyElaahiItem(), veganMainItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", veganMainItem.get(i).getMyElaahiItem());
                        Log.i("quan", veganMainItem.get(i).getMyElaahiQuantity());

                    }
                }

                for (int i = 0; i< itemwithVegetable.size(); i++) {
                    MainCourseElaahiAdult.veganMainItemWithChoice.add(new ItemNameWithSauce(itemwithVegetable.get(i).getItemSauce(), itemwithVegetable.get(i).getQuantity()));
                }
                Log.i("tandooriii: ", String.valueOf(MainCourseElaahiAdult.veganMainItemWithChoice.size()));
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
                for (int i = 0; i< MainCourseElaahiAdult.selectedVeganMain.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedVeganMain.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedVeganMain.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
