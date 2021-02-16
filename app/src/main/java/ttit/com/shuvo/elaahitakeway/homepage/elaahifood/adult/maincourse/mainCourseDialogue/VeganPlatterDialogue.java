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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.VeganPlatterAdapter;

public class VeganPlatterDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> veganplatterItem;

    public static ArrayList<ItemNameWithSauce> itemInVeganPlatter;


    private RecyclerView apptRecyclerView;
    private VeganPlatterAdapter apptAdapter;
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

        itemInVeganPlatter = new ArrayList<>();

        veganplatterItem = new ArrayList<>();

        veganplatterItem.add(new ElaahiItem("Vegan-Platter", "0","(100% Vegan). Choose any three vegan dishes, and the spice strength you want, from the pop-up that appears"));





        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new VeganPlatterAdapter(getContext(), veganplatterItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < veganplatterItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedVeganPlatter) {
                if (item.getMyChosenItem().contains(veganplatterItem.get(i).getMyElaahiItem())) {
                    veganplatterItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }

        for (int i = 0; i< MainCourseElaahiAdult.veganPlatterWithItem.size(); i++) {
            itemInVeganPlatter.add(new ItemNameWithSauce(MainCourseElaahiAdult.veganPlatterWithItem.get(i).getItemSauce(),MainCourseElaahiAdult.veganPlatterWithItem.get(i).getQuantity()));
        }


        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemInVeganPlatter.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainCourseElaahiAdult.veganPlatterWithItem.clear();
                MainCourseElaahiAdult.selectedVeganPlatter.clear();
                for (int i = 0; i < veganplatterItem.size(); i++) {
                    if (Integer.parseInt(veganplatterItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedVeganPlatter.add(new SelectedElahiItem(veganplatterItem.get(i).getMyElaahiItem(), veganplatterItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", veganplatterItem.get(i).getMyElaahiItem());
                        Log.i("quan", veganplatterItem.get(i).getMyElaahiQuantity());

                    }
                }

                for (int i = 0; i< itemInVeganPlatter.size(); i++) {
                    MainCourseElaahiAdult.veganPlatterWithItem.add(new ItemNameWithSauce(itemInVeganPlatter.get(i).getItemSauce(), itemInVeganPlatter.get(i).getQuantity()));
                }
                Log.i("tandooriii: ", String.valueOf(MainCourseElaahiAdult.veganPlatterWithItem.size()));
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
                for (int i = 0; i< MainCourseElaahiAdult.selectedVeganPlatter.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedVeganPlatter.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedVeganPlatter.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
