package ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.RadioChoiceList;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.FlavorAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MeatSelectionAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MeatwithPriceAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.SauceAdapter;

public class MeatSelectionDialogue extends AppCompatDialogFragment {

    public ArrayList<NormalFoodItem> sauceItem;
    private RecyclerView sauceView;
    private MeatwithPriceAdapter sauceAdapter;
    private RecyclerView.LayoutManager sauceLayout;
    private Button ok;
    private TextView topName;
    public static String selectedSauce;
    public static String selectedPrice;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.radio_button_dialogue, null);

        ok = view.findViewById(R.id.radio_seleceted);
        topName = view.findViewById(R.id.name_of_main_Food);
        topName.setText("Classic Dish Meat Selection");

        selectedPrice = "";
        selectedSauce = "No Flavor Selected";

        sauceItem = new ArrayList<>();
        sauceItem.add(new NormalFoodItem("Chicken","","£5.85"));
        sauceItem.add(new NormalFoodItem("Meat","","£5.85"));
        sauceItem.add(new NormalFoodItem("Prawn","","£6.30"));
        sauceItem.add(new NormalFoodItem("Chicken Tikka","","£5.85"));
        sauceItem.add(new NormalFoodItem("Lamb Tikka","","£6.40"));
        sauceItem.add(new NormalFoodItem("Mixed","","£6.05"));
        sauceItem.add(new NormalFoodItem("King Prawn","","£8.10"));
        sauceItem.add(new NormalFoodItem("Vegetable","","£5.05"));


        sauceView = view.findViewById(R.id.radio_choice_list);
        sauceView.setHasFixedSize(true);
        sauceLayout = new LinearLayoutManager(getContext());
        sauceView.setLayoutManager(sauceLayout);


        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(sauceView.getContext(),DividerItemDecoration.VERTICAL);
        sauceView.addItemDecoration(dividerItemDecoration);
        sauceAdapter = new MeatwithPriceAdapter(getContext(),sauceItem);
        sauceView.setAdapter(sauceAdapter);

        builder.setView(view);

        AlertDialog dialog = builder.create();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPrice == "") {
                    Toast.makeText(getContext(),"Please Select Your Meal Accurately", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    String food = MeatSelectionAdapter.foodNameFromAdapter;

                    CartActivity.mainFoodList.add(new CartItem(food + "\n" +"(-" + selectedSauce + "-)", "1", selectedPrice));
                    Toast.makeText(getContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();


                    dialog.dismiss();
                }

            }
        });

        return dialog;
    }
}
