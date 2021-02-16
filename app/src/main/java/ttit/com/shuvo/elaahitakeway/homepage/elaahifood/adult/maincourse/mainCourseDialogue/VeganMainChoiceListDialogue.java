package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ItemNameWithSauce;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.RadioChoiceList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.TandooriAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.VeganMainDishAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.RadioButtonAdapter;

public class VeganMainChoiceListDialogue extends AppCompatDialogFragment {

    public ArrayList<RadioChoiceList> veganChoiceItem;
    private RecyclerView sauceView;
    private RadioButtonAdapter sauceAdapter;
    private RecyclerView.LayoutManager sauceLayout;
    private Button ok;
    private TextView topName;
    public static String selectedSauce;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.radio_button_dialogue, null);

        ok = view.findViewById(R.id.radio_seleceted);
        topName = view.findViewById(R.id.name_of_main_Food);
        topName.setText("Choose a Food FLAVOUR ");

        selectedSauce = "No Choice";

        veganChoiceItem = new ArrayList<>();
        veganChoiceItem.add(new RadioChoiceList("Chickpeas"));
        veganChoiceItem.add(new RadioChoiceList("Mushroom & Peas"));
        veganChoiceItem.add(new RadioChoiceList("Seasonal Vegetables"));

        sauceView = view.findViewById(R.id.radio_choice_list);
        sauceView.setHasFixedSize(true);
        sauceLayout = new LinearLayoutManager(getContext());
        sauceView.setLayoutManager(sauceLayout);


        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(sauceView.getContext(),DividerItemDecoration.VERTICAL);
        sauceView.addItemDecoration(dividerItemDecoration);
        sauceAdapter = new RadioButtonAdapter(getContext(), veganChoiceItem);
        sauceView.setAdapter(sauceAdapter);

        builder.setView(view);

        AlertDialog dialog = builder.create();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = VeganMainDishAdapter.itemsName;
                Log.i("Selected vegan Item: ",selectedSauce);
                Log.i("Selected vegan for: ",text);
                VeganMainDishDialogue.itemwithVegetable.add(new ItemNameWithSauce(text + "\n" + "(--" + selectedSauce + "--)","1"));

                for (ItemNameWithSauce items : VeganMainDishDialogue.itemwithVegetable) {
                    Log.i("ITEMSAUCE: ",items.getItemSauce());
                }
                Log.i("coooo", String.valueOf(VeganMainDishDialogue.itemwithVegetable.size()));
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
