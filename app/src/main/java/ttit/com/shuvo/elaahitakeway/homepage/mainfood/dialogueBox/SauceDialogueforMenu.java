package ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.ItemNameWithSauce;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.RadioChoiceList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.TandooriAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.RadioButtonAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.TandooriDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MCItemAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.SauceAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.SeaFoodAnotherAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem.SeaFood;

public class SauceDialogueforMenu extends AppCompatDialogFragment {

    public ArrayList<RadioChoiceList> sauceItem;
    private RecyclerView sauceView;
    private SauceAdapter sauceAdapter;
    private RecyclerView.LayoutManager sauceLayout;
    private Button ok;
    public static String selectedSauce;
    public static int sauceValue;

    String food ;
    String price ;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.radio_button_dialogue, null);

        ok = view.findViewById(R.id.radio_seleceted);

        selectedSauce = "No Sauce Selected";

        sauceItem = new ArrayList<>();
        sauceItem.add(new RadioChoiceList("Vegetable Curry Sauce"));
        sauceItem.add(new RadioChoiceList("Balti Sauce"));
        sauceItem.add(new RadioChoiceList("Pathia Sauce"));
        sauceItem.add(new RadioChoiceList("Karahi Sauce"));
        sauceItem.add(new RadioChoiceList("Saag Sauce"));
        sauceItem.add(new RadioChoiceList("Jalfezi Sauce"));
        sauceItem.add(new RadioChoiceList("Passanda Sauce"));
        sauceItem.add(new RadioChoiceList("Shaheen Sauce"));
        sauceItem.add(new RadioChoiceList("Dupiaza Sauce"));
        sauceItem.add(new RadioChoiceList("Korma Sauce"));
        sauceItem.add(new RadioChoiceList("Dansak Sauce"));
        sauceItem.add(new RadioChoiceList("Bhuna Sauce"));
        sauceItem.add(new RadioChoiceList("Rogan Sauce"));

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
                if (sauceValue == 1) {
                    food = SeaFoodAnotherAdapter.foodNameFromAdapter;
                    price = SeaFoodAnotherAdapter.priceFormAdapter;
                }else if (sauceValue == 0){
                     food = MCItemAdapter.foodNameFromAdapter;
                     price = MCItemAdapter.priceFormAdapter;
                }



                CartActivity.mainFoodList.add(new CartItem(food + "\n" + "SAUCE:-  "+ "\n" +"(-" + selectedSauce + "-)", "1", price));
                Toast.makeText(getContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();


                dialog.dismiss();
            }
        });

        return dialog;
    }
}
