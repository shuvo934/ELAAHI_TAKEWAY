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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.VeganPlatterItemss;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.VeganNewStarterAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.FullCourseDialogue;

public class VeganStarterSMAdapter extends RecyclerView.Adapter<VeganStarterSMAdapter.VSSMViewHolder> {

    private ArrayList<CheckBoxList> myVeganStarterItem;
    private Context myContext;

    private int lastSelectedPosition = -1;

    public VeganStarterSMAdapter(Context context, ArrayList<CheckBoxList> mRadio) {
        this.myContext = context;
        this.myVeganStarterItem = mRadio;
    }

    @NonNull
    @Override
    public VSSMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.checkbox_item, parent,false);
        VSSMViewHolder rbv = new VSSMViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull VSSMViewHolder holder, int position) {
        CheckBoxList checkBoxList = myVeganStarterItem.get(position);

        holder.veganStarterName.setText(checkBoxList.getCheckBoxItem());
        holder.selectedBox.setChecked(checkBoxList.getCheckedItem());

        if (holder.veganStarterName.getText().toString().endsWith("(V) (N)")) {

            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-7, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            Log.i("paisi",holder.veganStarterName.getText().toString());

        }

        if (holder.veganStarterName.getText().toString().endsWith("VE")) {

            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            Log.i("paisi",holder.veganStarterName.getText().toString());

        }
        if (holder.veganStarterName.getText().toString().endsWith("V")) {

            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            Log.i("paisi",holder.veganStarterName.getText().toString());

        }
        if (holder.veganStarterName.getText().toString().endsWith("HOT"))  {

            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            Log.i("paisi",holder.veganStarterName.getText().toString());

        }

        if ( holder.veganStarterName.getText().toString().endsWith("Medium")) {
            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.veganStarterName.getText().toString().endsWith("SPICY")) {
            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.veganStarterName.getText().toString().endsWith("MILD")) {
            String text = holder.veganStarterName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-4, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.veganStarterName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }

    }

    @Override
    public int getItemCount() {
        return myVeganStarterItem.size();
    }

    public class VSSMViewHolder extends RecyclerView.ViewHolder {
        public TextView veganStarterName;
        public CheckBox selectedBox;

        public VSSMViewHolder(@NonNull View itemView) {
            super(itemView);
            veganStarterName = itemView.findViewById(R.id.checkbox_name);
            selectedBox = itemView.findViewById(R.id.checkbox_selected);

            selectedBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedBox.isChecked() == true && FullCourseDialogue.totalSelected != 0) {
                        selectedBox.setChecked(true);
                        Log.i("true",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        FullCourseDialogue.totalSelected -= 1;
                        Log.i("number of selection", String.valueOf(FullCourseDialogue.totalSelected));
                        myVeganStarterItem.get(getAdapterPosition()).setCheckedItem(true);
                    } else if (selectedBox.isChecked() == false && FullCourseDialogue.totalSelected >= 0) {
                        selectedBox.setChecked(false);
                        Log.i("false",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        FullCourseDialogue.totalSelected += 1;
                        Log.i("number of selection", String.valueOf(FullCourseDialogue.totalSelected));
                        myVeganStarterItem.get(getAdapterPosition()).setCheckedItem(false);
                    } else if (selectedBox.isChecked() == true && FullCourseDialogue.totalSelected == 0) {
                        selectedBox.setChecked(false);
                        Log.i("hobe na kisu",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        Log.i("number of selection", String.valueOf(FullCourseDialogue.totalSelected));
                    }
                }
            });


        }
    }
}
