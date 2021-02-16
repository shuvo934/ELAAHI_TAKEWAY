package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AdultFestiveCategory;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.ChildFestiveCategory;

public class ChildNumberDialogue extends AppCompatDialogFragment {

    public static TextView numberPeople;
    private Button peopleAdd;
    private Button peopleMinus;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.number_of_people, null);

        numberPeople = view.findViewById(R.id.peopleView);
        peopleAdd = view.findViewById(R.id.people_plus_button);
        peopleMinus = view.findViewById(R.id.people_minus_button);

        peopleAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = numberPeople.getText().toString();
                int n = Integer.parseInt(text);
                int add = n + 1;
                numberPeople.setText(String.valueOf(add));
            }
        });

        peopleMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = numberPeople.getText().toString();
                int n = Integer.parseInt(text);
                if (n == 1) {
                    return;
                } else {
                    int m = n - 1;
                    numberPeople.setText(String.valueOf(m));
                }
            }
        });

        builder.setView(view)
                .setTitle("ADD PEOPLE")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ChildFestiveCategory.numChild.setText(numberPeople.getText().toString());
                    }
                });

        return builder.create();
    }
}
