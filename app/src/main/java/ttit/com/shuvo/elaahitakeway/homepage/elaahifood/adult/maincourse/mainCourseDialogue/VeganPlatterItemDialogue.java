package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.CheckBoxList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ItemNameWithSauce;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.RadioChoiceList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.SpecialSeaFoodAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.VeganPlatterAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.RadioButtonAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.VeganSideAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.VeganStarterAdapter;

public class VeganPlatterItemDialogue extends AppCompatDialogFragment {

    public ArrayList<CheckBoxList> veganSideItem;
    public ArrayList<CheckBoxList> veganStarterItem;
    private RecyclerView veganSideView;
    private VeganSideAdapter veganSideAdapter;
    private RecyclerView.LayoutManager veganSidelayout;
    private RecyclerView veganStarterView;
    private VeganStarterAdapter veganStarterAdapter;
    private RecyclerView.LayoutManager veganStarterlayout;
    private Button ok;
    public static String selectedSauce;
    private Spinner foodTest;
    public static int totalSelected;
    private String foodTestName = "HOT";
    private String veganSS = "";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.vegan_platter_choice_dialogue, null);

        ok = view.findViewById(R.id.vegan_all_selected);
        foodTest = view.findViewById(R.id.test_spinner);

        selectedSauce = "No Sauce Selected";
        totalSelected = 3;

        veganSideItem = new ArrayList<>();
        veganSideItem.add(new CheckBoxList("Saag Bhaji",false));
        veganSideItem.add(new CheckBoxList("Mixed Veg Bhaji",false));
        veganSideItem.add(new CheckBoxList("Chickpeas & Potato Bhaji",false));
        veganSideItem.add(new CheckBoxList("Bombay Potato",false));
        veganSideItem.add(new CheckBoxList("Saag Sauce",false));
        veganSideItem.add(new CheckBoxList("Saag Aloo ( spinich & potatoes)",false));
        veganSideItem.add(new CheckBoxList("Tarka Dhal ( lentils)",false));
        veganSideItem.add(new CheckBoxList("Spicy Stir Fried Chick Peas",false));
        veganSideItem.add(new CheckBoxList("Garlic Mushroom Bhaji",false));
        veganSideItem.add(new CheckBoxList("Tamarind Potatoes",false));
        veganSideItem.add(new CheckBoxList("Okra & Potato Bhaji",false));
        veganSideItem.add(new CheckBoxList("Okra Bhaji",false));
        veganSideItem.add(new CheckBoxList("Bhindy Baji",false));

        veganSideView = view.findViewById(R.id.vegan_side_dish_list);
        veganSideView.setHasFixedSize(true);
        veganSidelayout = new LinearLayoutManager(getContext());
        veganSideView.setLayoutManager(veganSidelayout);


        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(veganSideView.getContext(),DividerItemDecoration.VERTICAL);
        veganSideView.addItemDecoration(dividerItemDecoration);
        veganSideAdapter = new VeganSideAdapter(getContext(), veganSideItem);
        veganSideView.setAdapter(veganSideAdapter);


        veganStarterItem = new ArrayList<>();
        veganStarterItem.add(new CheckBoxList("Stir Fried Garlic Mushrooms",false));
        veganStarterItem.add(new CheckBoxList("Stirfried Chick peas and Potaoes",false));
        veganStarterItem.add(new CheckBoxList("Vegetable Biraan",false));
        veganStarterItem.add(new CheckBoxList("Spicy Stir-fried Chickpeas",false));
        veganStarterItem.add(new CheckBoxList("Tamarind Potatoes",false));
        veganStarterItem.add(new CheckBoxList("Okra & Potato Bhaji",false));

        veganStarterView = view.findViewById(R.id.vegan_starter_list);
        veganStarterView.setHasFixedSize(true);
        veganStarterlayout = new LinearLayoutManager(getContext());
        veganStarterView.setLayoutManager(veganStarterlayout);

        DividerItemDecoration dividerItemDecorationNew =
                new DividerItemDecoration(veganStarterView.getContext(),DividerItemDecoration.VERTICAL);
        veganStarterView.addItemDecoration(dividerItemDecorationNew);
        veganStarterAdapter = new VeganStarterAdapter(getContext(), veganStarterItem);
        veganStarterView.setAdapter(veganStarterAdapter);

        List<String> categories = new ArrayList<String>();
        categories.add("HOT");
        categories.add("Medium");
        categories.add("MILD");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        foodTest.setAdapter(spinnerAdapter);



        builder.setView(view);

        AlertDialog dialog = builder.create();

        foodTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                foodTestName = parent.getItemAtPosition(position).toString();
                Log.i("SpinnerItem", foodTestName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                String item = "HOT";
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < veganSideItem.size(); i++) {
                    if (veganSideItem.get(i).getCheckedItem() == true) {
                        veganSS += "-(--" + veganSideItem.get(i).getCheckBoxItem() + "--)";
                        Log.i("Item vegan sidess", veganSS);
                        Log.i("Item vegan side", veganSideItem.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < veganStarterItem.size(); i++) {
                    if (veganStarterItem.get(i).getCheckedItem() == true) {
                        veganSS += "(--" + veganStarterItem.get(i).getCheckBoxItem() + "--)";
                        Log.i("star vegan sidess", veganSS);
                        Log.i("star vegan side", veganStarterItem.get(i).getCheckBoxItem());
                    }
                }
                if (veganSS.isEmpty()) {
                    veganSS = "No Choice Selected";
                }
                Log.i("total",veganSS);
                String text = VeganPlatterAdapter.itemsName;

                VeganPlatterDialogue.itemInVeganPlatter.add(new ItemNameWithSauce(text + "---" + foodTestName + "\n" + veganSS, "1"));

                for (ItemNameWithSauce items : VeganPlatterDialogue.itemInVeganPlatter) {
                    Log.i("ITEMSAUCE: ",items.getItemSauce());
                }
                Log.i("coooo", String.valueOf(VeganPlatterDialogue.itemInVeganPlatter.size()));
                dialog.dismiss();
            }
        });

        return dialog;
    }

}
