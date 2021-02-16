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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.BiriyaniAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.MainCourseElaahiAdult;


public class BiriyaniDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> biriyaniItem;

    private RecyclerView apptRecyclerView;
    private BiriyaniAdapter apptAdapter;
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



        biriyaniItem = new ArrayList<>();

        biriyaniItem.add(new ElaahiItem("Meat", "0",""));
        biriyaniItem.add(new ElaahiItem("Chicken", "0",""));
        biriyaniItem.add(new ElaahiItem("Prawn", "0",""));
        biriyaniItem.add(new ElaahiItem("Chicken tikka", "0",""));
        biriyaniItem.add(new ElaahiItem("Lamb Tikka", "0",""));
        biriyaniItem.add(new ElaahiItem("Mixed", "0",""));
        biriyaniItem.add(new ElaahiItem("Vegetable", "0",""));
        biriyaniItem.add(new ElaahiItem("Vegan", "0",""));



        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new BiriyaniAdapter(getContext(), biriyaniItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < biriyaniItem.size(); i++) {

            for (SelectedElahiItem item : MainCourseElaahiAdult.selectedBiriyani) {
                if (item.getMyChosenItem().contains(biriyaniItem.get(i).getMyElaahiItem())) {
                    biriyaniItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
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


                MainCourseElaahiAdult.selectedBiriyani.clear();
                for (int i = 0; i < biriyaniItem.size(); i++) {
                    if (Integer.parseInt(biriyaniItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        MainCourseElaahiAdult.selectedBiriyani.add(new SelectedElahiItem(biriyaniItem.get(i).getMyElaahiItem(), biriyaniItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", biriyaniItem.get(i).getMyElaahiItem());
                        Log.i("quan", biriyaniItem.get(i).getMyElaahiQuantity());

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
                for (int i = 0; i< MainCourseElaahiAdult.selectedBiriyani.size(); i++) {
                    tandooriCount = tandooriCount + Integer.parseInt(MainCourseElaahiAdult.selectedBiriyani.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(tandooriCount));
                MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).setFoodCount(String.valueOf(tandooriCount));
                MainCourseElaahiAdult.mainCourseAdapter.notifyDataSetChanged();
                Log.i("Adapter", MainCourseElaahiAdult.myMCItems.get(MainCourseElaahiAdult.adpaterPosition).getFoodCount());


                Log.i("sss", MainCourseElaahiAdult.selectedBiriyani.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
