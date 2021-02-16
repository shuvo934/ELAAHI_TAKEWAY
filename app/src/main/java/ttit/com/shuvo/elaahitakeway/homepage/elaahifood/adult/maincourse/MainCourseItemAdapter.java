package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItemAdapter;

public class MainCourseItemAdapter extends RecyclerView.Adapter<MainCourseItemAdapter.MainCourseItemViewHolder> {


    public ArrayList<StarterItem> itemsOfMainCourse;
    public Context mainCourseContext;
    private ClickedMainCourseItem myMainCourseItem;

    public MainCourseItemAdapter(Context myContext, ArrayList<StarterItem> itemsOfMainCourse, ClickedMainCourseItem cmci) {
        this.mainCourseContext = myContext;
        this.itemsOfMainCourse = itemsOfMainCourse;
        this.myMainCourseItem = cmci;
    }

    public interface ClickedMainCourseItem {
        void onMainCourseItemClicked(int mainCourseItemPosition);
    }

    @NonNull
    @Override
    public MainCourseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mainCourseContext).inflate(R.layout.elaahi_adult_starter_item, parent, false);
        MainCourseItemViewHolder mcivh = new MainCourseItemViewHolder(v, myMainCourseItem);
        return mcivh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainCourseItemViewHolder holder, int position) {

        StarterItem mcItem = itemsOfMainCourse.get(position);

        holder.mainCourseItemName.setText(mcItem.getTypeOfFood());
        holder.mianCourseItemDescription.setText(mcItem.getFoodDescribed());
        holder.mCCount.setText(mcItem.getFoodCount());

        if (holder.mainCourseItemName.getText().toString().endsWith("V")) {

            String text = holder.mainCourseItemName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainCourseItemName.setText(ss);
            Log.i("paisi",holder.mainCourseItemName.getText().toString());

        }
    }

    @Override
    public int getItemCount() {
        return itemsOfMainCourse.size();
    }

    public class MainCourseItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mainCourseItemName;
        public TextView mianCourseItemDescription;
        private ImageView selectedItemMC;
        private TextView mCCount;
        ClickedMainCourseItem clickedMainCourseItem;

        public MainCourseItemViewHolder(@NonNull View itemView, ClickedMainCourseItem cmi) {
            super(itemView);
            mainCourseItemName = itemView.findViewById(R.id.starter_item_name);
            mianCourseItemDescription = itemView.findViewById(R.id.starter_description);
            selectedItemMC = itemView.findViewById(R.id.starter_item_selected);
            mCCount = itemView.findViewById(R.id.starterCountElahi);
            this.clickedMainCourseItem = cmi;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedMainCourseItem.onMainCourseItemClicked(getAdapterPosition());
        }
    }

}
