package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox;

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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AppitiserItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.ChildFestiveCategory;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.DessertChildAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.MainCourseChildAdapter;

public class DessertChildDialogue extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> dessChildItem;

    private RecyclerView apptRecyclerView;
    private DessertChildAdapter apptAdapter;
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
        titleName.setText(ChildFestiveCategory.titleNameChild);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);




        dessChildItem = new ArrayList<>();

        dessChildItem.add(new AppitiserItem("Christmas Pudding", "0","With cream"));
        dessChildItem.add(new AppitiserItem("Chocolate Fudge Cake", "0","With cream"));
        dessChildItem.add(new AppitiserItem("Vanilla Cheese Cake", "0","Drizzled with coulis"));
        dessChildItem.add(new AppitiserItem("Chocolate & Raspberry Torte VE", "0",""));
        dessChildItem.add(new AppitiserItem("Gulab Jaman & Ice Cream", "0",""));





        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new DessertChildAdapter(getContext(), dessChildItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < dessChildItem.size(); i++) {

            for (SelectedItem item : ChildFestiveCategory.selectedItemDesertChild) {
                if (item.getMyChosenItem().contains(dessChildItem.get(i).getMyAppitiserItem())) {
                    dessChildItem.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                ChildFestiveCategory.selectedItemDesertChild.clear();
                for (int i = 0; i < dessChildItem.size(); i++) {
                    if (Integer.parseInt(dessChildItem.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        ChildFestiveCategory.selectedItemDesertChild.add(new SelectedItem(dessChildItem.get(i).getMyAppitiserItem(), dessChildItem.get(i).getMyApptQuantity()));
                        Log.i("Food", dessChildItem.get(i).getMyAppitiserItem());
                        Log.i("quan", dessChildItem.get(i).getMyApptQuantity());

                    }
                }
                int count = DessertChildAdapter.ton[0];
                if (count == 0) {
                    ChildFestiveCategory.desCountChild.setText(String.valueOf(count));
                    ChildFestiveCategory.desCountChild.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    ChildFestiveCategory.desCountChild.setText(String.valueOf(count));
                    ChildFestiveCategory.desCountChild.setBackgroundResource(R.drawable.ic_circle_red);
                }

                DessertChildAdapter.ton[0] = 0;


                Log.i("sss", ChildFestiveCategory.selectedItemMCChild.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
