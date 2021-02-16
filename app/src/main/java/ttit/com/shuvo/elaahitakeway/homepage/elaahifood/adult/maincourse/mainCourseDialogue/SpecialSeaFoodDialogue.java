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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ChefSignatureAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ItemNameWithSauce;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.MainCourseElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.SpecialSeaFoodAdapter;

public class SpecialSeaFoodDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> specialSeaFoodItem;

    public static ArrayList<ItemNameWithSauce> specialSeaSauce;

    private RecyclerView apptRecyclerView;
    private SpecialSeaFoodAdapter apptAdapter;
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

        specialSeaSauce = new ArrayList<>();

        specialSeaFoodItem = new ArrayList<>();

        specialSeaFoodItem.add(new ElaahiItem("Garlic Chilli Fish New  HOT", "0","fresh fish fillet cooked with blended spices,onions, peppers, ginger, garlic and chillies. Served with a choice of curry sauce"));
        specialSeaFoodItem.add(new ElaahiItem("Salmon Tikka Mossala New  MILD", "0","Grilled Salmon fillets cooked in a mild creamy mossalla sauce"));
        specialSeaFoodItem.add(new ElaahiItem("King prawn Delight (No Shells) New  Medium", "0","Fresh fish fillets cooked with onions, tomatoes and blend of Bengali spices."));
        specialSeaFoodItem.add(new ElaahiItem("Bengal Fish Karahi (New)  HOT", "0","Fresh fish fillets cooked with onions, tomatoes and blend of Bengali spices."));
        specialSeaFoodItem.add(new ElaahiItem("Grilled Peri Peri Tiger King Prawns  Medium", "0","Grilled Tiger King Prawns stir fried in exotic mix of spices with spring onions, capsicum, fresh garlic, ginger and peri peri sauce. Served on a bed of seasonal vegetables and with a choice of curry sauce"));
        specialSeaFoodItem.add(new ElaahiItem("Grilled Peri Peri Tiger King Prawns  HOT", "0","Grilled Tiger King Prawns stir fried in exotic mix of spices with spring onions, capsicum, fresh garlic, ginger and peri peri sauce. Served on a bed of seasonal vegetables and with a choice of curry sauce"));
        specialSeaFoodItem.add(new ElaahiItem("Grilled Fish Fillets  MILD", "0","Fresh Fish Fillets marinated in a lightly spiced sauce and gently grilled."));
        specialSeaFoodItem.add(new ElaahiItem("Grilled Fish Fillets  Medium", "0","Fresh Fish Fillets marinated in a lightly spiced sauce and gently grilled."));
        specialSeaFoodItem.add(new ElaahiItem("Pan Fried Sea Bass Biraan  MILD", "0","Sea Bass grilled with selected spices. Served with a choice of curry sauce."));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new SpecialSeaFoodAdapter(getContext(), specialSeaFoodItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < specialSeaFoodItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedSpecialSeaFood) {
                if (item.getMyChosenItem().contains(specialSeaFoodItem.get(i).getMyElaahiItem())) {
                    specialSeaFoodItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }

        for (int i = 0; i< MainCourseElaahiAdult.seaFoodSauceItem.size(); i++) {
            specialSeaSauce.add(new ItemNameWithSauce(MainCourseElaahiAdult.seaFoodSauceItem.get(i).getItemSauce(),MainCourseElaahiAdult.seaFoodSauceItem.get(i).getQuantity()));
        }


        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specialSeaSauce.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainCourseElaahiAdult.seaFoodSauceItem.clear();
                MainCourseElaahiAdult.selectedSpecialSeaFood.clear();
                for (int i = 0; i < specialSeaFoodItem.size(); i++) {
                    if (Integer.parseInt(specialSeaFoodItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedSpecialSeaFood.add(new SelectedElahiItem(specialSeaFoodItem.get(i).getMyElaahiItem(), specialSeaFoodItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", specialSeaFoodItem.get(i).getMyElaahiItem());
                        Log.i("quan", specialSeaFoodItem.get(i).getMyElaahiQuantity());

                    }
                }

                for (int i = 0; i< specialSeaSauce.size(); i++) {
                    MainCourseElaahiAdult.seaFoodSauceItem.add(new ItemNameWithSauce(specialSeaSauce.get(i).getItemSauce(),specialSeaSauce.get(i).getQuantity()));
                    Log.i("FoodWithSauce", MainCourseElaahiAdult.seaFoodSauceItem.get(i).getItemSauce());
                }

 /* Need to delete this in main main course elahi adult*/

//                for (int i = 0; i< MainCourseElaahiAdult.selectedSpecialSeaFood.size(); i++) {
//                    for (ItemNameWithSauce item : MainCourseElaahiAdult.seaFoodSauceItem) {
//                        if (item.getItemSauce().contains(MainCourseElaahiAdult.selectedSpecialSeaFood.get(i).getMyChosenItem())) {
//                            Log.i("Need to Delete", item.getItemSauce());
//                            Log.i("Delete from main Food:", MainCourseElaahiAdult.selectedSpecialSeaFood.get(i).getMyChosenItem());
//                            MainCourseElaahiAdult.selectedSpecialSeaFood.remove(i);
//                        }
//                    }
//                }


//
//                MeatAdapter.ton[0] = 0;
                tandooriCount = 0;
                for (int i = 0; i< MainCourseElaahiAdult.selectedSpecialSeaFood.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedSpecialSeaFood.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(2).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(2).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedSpecialSeaFood.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }

}
