package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox;

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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.AdultElaahi;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.AppitiserElahiAdultAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SelectedElahiItem;


public class AppitiserElaahiAdultDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> appFoodItem;

    private RecyclerView apptRecyclerView;
    private AppitiserElahiAdultAdapter apptAdapter;
    private RecyclerView.LayoutManager apptLayout;
    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.appitiser_dialogue, null);

        titleName = view.findViewById(R.id.selected_ID);
        titleName.setText(AdultElaahi.titleNameadultElhi);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);


        appFoodItem = new ArrayList<>();

        appFoodItem.add(new ElaahiItem("Popadoms and Pickle Platter", "0",""));


        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new AppitiserElahiAdultAdapter(getContext(), appFoodItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < appFoodItem.size(); i++) {

            for (SelectedElahiItem item : AdultElaahi.selectedItemaptadultElhi) {
                if (item.getMyChosenItem().contains(appFoodItem.get(i).getMyElaahiItem())) {
                    appFoodItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
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

                AdultElaahi.selectedItemaptadultElhi.clear();
                for (int i = 0; i < appFoodItem.size(); i++) {
                    if (Integer.parseInt(appFoodItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        AdultElaahi.selectedItemaptadultElhi.add(new SelectedElahiItem(appFoodItem.get(i).getMyElaahiItem(),appFoodItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", appFoodItem.get(i).getMyElaahiItem());
                        Log.i("quan", appFoodItem.get(i).getMyElaahiQuantity());

                    }
                }
                int count = AppitiserElahiAdultAdapter.ton[0];
                if (count == 0) {
                    AdultElaahi.apptCountadultElhi.setText(String.valueOf(count));
                    AdultElaahi.apptCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultElaahi.apptCountadultElhi.setText(String.valueOf(count));
                    AdultElaahi.apptCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
                }

                AppitiserElahiAdultAdapter.ton[0] = 0;


                Log.i("sss", AdultElaahi.selectedItemaptadultElhi.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }

}
