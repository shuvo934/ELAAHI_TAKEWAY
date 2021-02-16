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

import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.FlavorAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.SauceAdapter;

public class FlavorDialogue extends AppCompatDialogFragment {

    public ArrayList<RadioChoiceList> sauceItem;
    private RecyclerView sauceView;
    private SauceAdapter sauceAdapter;
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

        selectedSauce = "No Flavor Selected";

        sauceItem = new ArrayList<>();
        sauceItem.add(new RadioChoiceList("Chickpeas"));
        sauceItem.add(new RadioChoiceList("Mushroom & Peas"));
        sauceItem.add(new RadioChoiceList("Seasonal Vegetables"));


        sauceView = view.findViewById(R.id.radio_choice_list);
        sauceView.setHasFixedSize(true);
        sauceLayout = new LinearLayoutManager(getContext());
        sauceView.setLayoutManager(sauceLayout);


        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(sauceView.getContext(),DividerItemDecoration.VERTICAL);
        sauceView.addItemDecoration(dividerItemDecoration);
        sauceAdapter = new SauceAdapter(getContext(),sauceItem);
        sauceView.setAdapter(sauceAdapter);

        builder.setView(view);

        AlertDialog dialog = builder.create();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String food = FlavorAdapter.foodNameFromAdapter;
                String price = FlavorAdapter.priceFormAdapter;


                CartActivity.mainFoodList.add(new CartItem(food + "\n" + "FLAVOR:-  "+ "\n" +"(-" + selectedSauce + "-)", "1", price));
                Toast.makeText(getContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();


                dialog.dismiss();
            }
        });

        return dialog;
    }
}
