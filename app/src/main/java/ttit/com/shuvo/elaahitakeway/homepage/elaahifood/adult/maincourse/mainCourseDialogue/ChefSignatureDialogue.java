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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.TandooriAdapter;

public class ChefSignatureDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> chefSigantureItem;

    private RecyclerView apptRecyclerView;
    private ChefSignatureAdapter apptAdapter;
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



        chefSigantureItem = new ArrayList<>();

        chefSigantureItem.add(new ElaahiItem("Garlic Chicken Tikka Massala  Medium", "0","Chicken Tikka cooked in garlic with a richly flavoured Massala sauce."));
        chefSigantureItem.add(new ElaahiItem("Garlic Lamb Tikka Massala  Medium", "0","Lamb Tikka cooked in garlic with a richly flavoured Massala sauce."));
        chefSigantureItem.add(new ElaahiItem("Chicken Tikka Chilli Massala  HOT", "0","Cooked with fresh green chillies, ground spices and herbs."));
        chefSigantureItem.add(new ElaahiItem("Lamb Tikka Chilli Massala  HOT", "0","Cooked with fresh green chillies, ground spices and herbs."));
        chefSigantureItem.add(new ElaahiItem("Stir Fried Peri Peri Chicken Tikka New  HOT", "0","Chicken fillets stir fried with onions, peppers & Peri peri sauce"));
        chefSigantureItem.add(new ElaahiItem("Stir Fried Peri Peri Lamb Tikka New  HOT", "0","Lamb fillets stir fried with onions, peppers & Peri peri sauce"));
        chefSigantureItem.add(new ElaahiItem("Mumbai Grilled Chilli Chicken  HOT", "0","Fresh chicken fillets marinated and grilled. Served with stir fried onions and crushed chillies."));
        chefSigantureItem.add(new ElaahiItem("Chicken Naga  HOT", "0","A fiery hot dish cooked with authentic Bangla spices and herbs using naga chillies to give a spicy hot flavour of the dish."));
        chefSigantureItem.add(new ElaahiItem("Chicken Nepal  SPICY", "0","Cooked with chunky onions and peppers in a spicy garlic and chilli Nepalese sauce."));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new ChefSignatureAdapter(getContext(), chefSigantureItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < chefSigantureItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedSignatureDish) {
                if (item.getMyChosenItem().contains(chefSigantureItem.get(i).getMyElaahiItem())) {
                    chefSigantureItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }




        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainCourseElaahiAdult.selectedSignatureDish.clear();
                for (int i = 0; i < chefSigantureItem.size(); i++) {
                    if (Integer.parseInt(chefSigantureItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedSignatureDish.add(new SelectedElahiItem(chefSigantureItem.get(i).getMyElaahiItem(), chefSigantureItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", chefSigantureItem.get(i).getMyElaahiItem());
                        Log.i("quan", chefSigantureItem.get(i).getMyElaahiQuantity());

                    }
                }


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
                for (int i = 0; i< MainCourseElaahiAdult.selectedSignatureDish.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedSignatureDish.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(1).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(1).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedSignatureDish.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }

}
