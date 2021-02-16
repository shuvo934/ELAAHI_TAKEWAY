package ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.AppitiserMainMenuAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.SeaFoodAnotherAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMealAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem.SeaFood;

public class QuantityDialogue extends AppCompatDialogFragment {


    private TextView quantityView;
    private TextView food;
    private Button addButton;
    private Button minusButton;
    public String foodPrice;
    public static int qunatityValue;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.qunatity_dialog, null);
        quantityView = view.findViewById(R.id.quantityView_normal);
        addButton = view.findViewById(R.id.plus_button_normal);
        minusButton = view.findViewById(R.id.minus_button_normal);
        food = view.findViewById(R.id.food_name_normal);
        if (qunatityValue == 1) {
            food.setText(SeaFoodAnotherAdapter.foodNameFromAdapter);
            foodPrice= SeaFoodAnotherAdapter.priceFormAdapter;
        } else if (qunatityValue == 0){
            food.setText(AppitiserMainMenuAdapter.foodNameFromAdapter);
            foodPrice = AppitiserMainMenuAdapter.priceFormAdapter;
        } else if (qunatityValue == 2) {
            food.setText(SetMealAdapter.foodNameFromAdapter);
            foodPrice = SetMealAdapter.priceFormAdapter;
        }

        if (food.getText().toString().endsWith("VE")) {

            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            Log.i("paisi",food.getText().toString());

        }
        if (food.getText().toString().endsWith("(V) (N)")) {

            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-7, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            Log.i("paisi",food.getText().toString());

        }

        if (food.getText().toString().endsWith("V")) {

            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            Log.i("paisi",food.getText().toString());

        }
        if (food.getText().toString().endsWith("HOT"))  {

            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            Log.i("paisi",food.getText().toString());

        }

        if ( food.getText().toString().endsWith("Medium")) {
            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( food.getText().toString().endsWith("SPICY")) {
            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( food.getText().toString().endsWith("MILD")) {
            String text = food.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-4, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            food.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = quantityView.getText().toString();
                int num = Integer.parseInt(text);
                int add = num + 1;
                quantityView.setText(String.valueOf(add));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = quantityView.getText().toString();
                int num = Integer.parseInt(text);
                if (num == 1) {
                    return;
                }else {
                    int minus = num -1;
                    quantityView.setText(String.valueOf(minus));
                }
            }
        });

        builder.setView(view)
                .setTitle("ADD QUANTITY")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (food.getText().toString().endsWith("VE")) {
                            String text = food.getText().toString();
                            food.setText(text.substring(0, text.length()-2));
                        }
                        CartActivity.mainFoodList.add(new CartItem(food.getText().toString(), quantityView.getText().toString(), foodPrice));
                        Toast.makeText(getContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    }
                });


        return builder.create();
    }
}
