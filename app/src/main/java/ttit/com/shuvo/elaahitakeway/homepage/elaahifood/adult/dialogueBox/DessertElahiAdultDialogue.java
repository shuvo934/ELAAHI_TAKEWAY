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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.DessertElahiAdultAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SelectedElahiItem;


public class DessertElahiAdultDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> dessertElahiAdultItem;

    private RecyclerView apptRecyclerView;
    private DessertElahiAdultAdapter apptAdapter;
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


        dessertElahiAdultItem = new ArrayList<>();

        dessertElahiAdultItem.add(new ElaahiItem("Christmas Pudding", "0","With cream"));
        dessertElahiAdultItem.add(new ElaahiItem("Chocolate Fudge Cake", "0","With cream"));
        dessertElahiAdultItem.add(new ElaahiItem("Vanilla Cheese Cake", "0","Drizzled with coulis"));
        dessertElahiAdultItem.add(new ElaahiItem("Chocolate & Raspberry Torte VE", "0",""));
        dessertElahiAdultItem.add(new ElaahiItem("Gulab Jaman & Ice Cream ", "0",""));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new DessertElahiAdultAdapter(getContext(), dessertElahiAdultItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < dessertElahiAdultItem.size(); i++) {

            for (SelectedElahiItem item : AdultElaahi.selectedItemDesertadultElhi) {
                if (item.getMyChosenItem().contains(dessertElahiAdultItem.get(i).getMyElaahiItem())) {
                    dessertElahiAdultItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
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

                AdultElaahi.selectedItemDesertadultElhi.clear();
                for (int i = 0; i < dessertElahiAdultItem.size(); i++) {
                    if (Integer.parseInt(dessertElahiAdultItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        AdultElaahi.selectedItemDesertadultElhi.add(new SelectedElahiItem(dessertElahiAdultItem.get(i).getMyElaahiItem(), dessertElahiAdultItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", dessertElahiAdultItem.get(i).getMyElaahiItem());
                        Log.i("quan", dessertElahiAdultItem.get(i).getMyElaahiQuantity());

                    }
                }
                int count = DessertElahiAdultAdapter.ton[0];
                if (count == 0) {
                    AdultElaahi.desCountadultElhi.setText(String.valueOf(count));
                    AdultElaahi.desCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultElaahi.desCountadultElhi.setText(String.valueOf(count));
                    AdultElaahi.desCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
                }

                DessertElahiAdultAdapter.ton[0] = 0;


                Log.i("sss", AdultElaahi.selectedItemDesertadultElhi.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
