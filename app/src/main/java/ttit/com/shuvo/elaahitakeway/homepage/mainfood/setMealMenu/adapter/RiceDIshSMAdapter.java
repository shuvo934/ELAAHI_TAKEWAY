package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.CheckBoxList;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.FullCourseDialogue;

public class RiceDIshSMAdapter extends RecyclerView.Adapter<RiceDIshSMAdapter.RiceSMViewHolder> {


    private ArrayList<CheckBoxList> myRiceSMItem;
    private Context myContext;


    public RiceDIshSMAdapter(Context context, ArrayList<CheckBoxList> mRadio) {
        this.myContext = context;
        this.myRiceSMItem = mRadio;
    }

    @NonNull
    @Override
    public RiceSMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.checkbox_item, parent,false);
        RiceSMViewHolder rbv = new RiceSMViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull RiceSMViewHolder holder, int position) {
        CheckBoxList checkBoxList = myRiceSMItem.get(position);

        holder.veganSideName.setText(checkBoxList.getCheckBoxItem());
        holder.selectedBox.setChecked(checkBoxList.getCheckedItem());

        if (holder.veganSideName.getText().toString().endsWith("(V) (N)")) {

            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-7, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            Log.i("paisi",holder.veganSideName.getText().toString());

        }

        if (holder.veganSideName.getText().toString().endsWith("VE")) {

            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            Log.i("paisi",holder.veganSideName.getText().toString());

        }
        if (holder.veganSideName.getText().toString().endsWith("V")) {

            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            Log.i("paisi",holder.veganSideName.getText().toString());

        }
        if (holder.veganSideName.getText().toString().endsWith("HOT"))  {

            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            Log.i("paisi",holder.veganSideName.getText().toString());

        }

        if ( holder.veganSideName.getText().toString().endsWith("Medium")) {
            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.veganSideName.getText().toString().endsWith("SPICY")) {
            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.veganSideName.getText().toString().endsWith("MILD")) {
            String text = holder.veganSideName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-4, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganSideName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }

    }

    @Override
    public int getItemCount() {
        return myRiceSMItem.size();
    }

    public class RiceSMViewHolder extends RecyclerView.ViewHolder {
        public TextView veganSideName;
        public CheckBox selectedBox;

        public RiceSMViewHolder(@NonNull View itemView) {
            super(itemView);
            veganSideName = itemView.findViewById(R.id.checkbox_name);
            selectedBox = itemView.findViewById(R.id.checkbox_selected);

            selectedBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedBox.isChecked() == true && FullCourseDialogue.riceDishSelected != 0) {
                        selectedBox.setChecked(true);
                        Log.i("true", myRiceSMItem.get(getAdapterPosition()).getCheckBoxItem());
                        FullCourseDialogue.riceDishSelected -= 1;
                        Log.i("number of selection", String.valueOf(FullCourseDialogue.riceDishSelected));
                        myRiceSMItem.get(getAdapterPosition()).setCheckedItem(true);
                    } else if (selectedBox.isChecked() == false && FullCourseDialogue.riceDishSelected >= 0) {
                        selectedBox.setChecked(false);
                        Log.i("false", myRiceSMItem.get(getAdapterPosition()).getCheckBoxItem());
                        FullCourseDialogue.riceDishSelected += 1;
                        Log.i("number of selection", String.valueOf(FullCourseDialogue.riceDishSelected));
                        myRiceSMItem.get(getAdapterPosition()).setCheckedItem(false);
                    } else if (selectedBox.isChecked() == true && FullCourseDialogue.riceDishSelected == 0) {
                        selectedBox.setChecked(false);
                        Log.i("hobe na kisu", myRiceSMItem.get(getAdapterPosition()).getCheckBoxItem());
                        Log.i("number of selection", String.valueOf(FullCourseDialogue.riceDishSelected));
                    }
                }
            });

        }
    }
}
