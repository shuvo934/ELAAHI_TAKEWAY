package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter;

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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.CheckBoxListNew;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.TandooriSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.CheFsMeal2;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.NewYearMeal;

public class VeganNYAdapter extends RecyclerView.Adapter<VeganNYAdapter.VeganNYViewHolder> {

    private ArrayList<CheckBoxListNew> myVeganSideItem;
    private Context myContext;


    public VeganNYAdapter(Context context, ArrayList<CheckBoxListNew> mRadio) {
        this.myContext = context;
        this.myVeganSideItem = mRadio;
    }

    @NonNull
    @Override
    public VeganNYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.sub_course_item, parent,false);
        VeganNYViewHolder rbv = new VeganNYViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull VeganNYViewHolder holder, int position) {
        CheckBoxListNew checkBoxList = myVeganSideItem.get(position);

        holder.veganSideName.setText(checkBoxList.getCheckBoxItem());
        holder.selectedBox.setChecked(checkBoxList.getCheckedItem());
        holder.descName.setText(checkBoxList.getCheckBoxDesc());
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
        return myVeganSideItem.size();
    }

    public class VeganNYViewHolder extends RecyclerView.ViewHolder {
        public TextView veganSideName;
        public CheckBox selectedBox;
        public TextView descName;

        public VeganNYViewHolder(@NonNull View itemView) {
            super(itemView);
            veganSideName = itemView.findViewById(R.id.sub_course_name);
            selectedBox = itemView.findViewById(R.id.sub_course_selected);
            descName = itemView.findViewById(R.id.sub_course_desc);

            selectedBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedBox.isChecked() == true && NewYearMeal.totalSelected != 0) {
                        selectedBox.setChecked(true);
                        Log.i("true",myVeganSideItem.get(getAdapterPosition()).getCheckBoxItem());
                        NewYearMeal.totalSelected -= 1;
                        Log.i("number of selection", String.valueOf(NewYearMeal.totalSelected));
                        myVeganSideItem.get(getAdapterPosition()).setCheckedItem(true);
                    } else if (selectedBox.isChecked() == false && NewYearMeal.totalSelected >= 0) {
                        selectedBox.setChecked(false);
                        Log.i("false",myVeganSideItem.get(getAdapterPosition()).getCheckBoxItem());
                        NewYearMeal.totalSelected += 1;
                        Log.i("number of selection", String.valueOf(NewYearMeal.totalSelected));
                        myVeganSideItem.get(getAdapterPosition()).setCheckedItem(false);
                    } else if (selectedBox.isChecked() == true && NewYearMeal.totalSelected == 0) {
                        selectedBox.setChecked(false);
                        Log.i("hobe na kisu",myVeganSideItem.get(getAdapterPosition()).getCheckBoxItem());
                        Log.i("number of selection", String.valueOf(NewYearMeal.totalSelected));
                    }
                }
            });

        }
    }
}
