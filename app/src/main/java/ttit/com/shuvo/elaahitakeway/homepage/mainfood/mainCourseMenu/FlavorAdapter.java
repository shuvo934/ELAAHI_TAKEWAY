package ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.FlavorDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.SauceDialogueforMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

public class FlavorAdapter extends RecyclerView.Adapter<FlavorAdapter.FlavorViewHolder> {

    public ArrayList<SubCategoryItemTag> myNormalFoodItem;
    public static String foodNameFromAdapter;
    public static String priceFormAdapter;
    public Context myContext;

    public FlavorAdapter(Context context, ArrayList<SubCategoryItemTag> normalFoodItems) {
        this.myContext = context;
        this.myNormalFoodItem = normalFoodItems;
    }

    @NonNull
    @Override
    public FlavorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(myContext).inflate(R.layout.fooditem, parent, false);
        FlavorViewHolder ammvh = new FlavorViewHolder(v);
        return ammvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FlavorViewHolder holder, int position) {

        SubCategoryItemTag nFI = myNormalFoodItem.get(position);

        holder.mainFoodName.setText(nFI.getfName() + " " + nFI.getfTag()+ " " + nFI.getfTest());
        holder.mainFoodDesc.setText(nFI.getfNote());
        holder.mainFoodPrice.setText("£" + nFI.getfRate());

        if (holder.mainFoodName.getText().toString().contains("null")) {
            String name = holder.mainFoodName.getText().toString().replace("null","");
            holder.mainFoodName.setText(name);
        }


        if (holder.mainFoodDesc.getText().toString().contains("null")) {
            holder.mainFoodDesc.setText("");
        }

        if (holder.mainFoodName.getText().toString().endsWith("VE ")) {

            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            Log.i("paisi",holder.mainFoodName.getText().toString());

        }
        if (holder.mainFoodName.getText().toString().endsWith("V ")) {

            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            Log.i("paisi",holder.mainFoodName.getText().toString());

        }
        if (holder.mainFoodName.getText().toString().endsWith("HOT"))  {

            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            Log.i("paisi",holder.mainFoodName.getText().toString());

        }

        if ( holder.mainFoodName.getText().toString().endsWith("Medium")) {
            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.mainFoodName.getText().toString().endsWith("SPICY")) {
            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.mainFoodName.getText().toString().endsWith("MILD")) {
            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
    }

    @Override
    public int getItemCount() {
        return myNormalFoodItem.size();
    }

    public class FlavorViewHolder extends RecyclerView.ViewHolder {

        public TextView mainFoodName;
        public TextView mainFoodDesc;
        public TextView mainFoodPrice;
        public Button addButtonToCart;

        public FlavorViewHolder(@NonNull View itemView) {
            super(itemView);

            mainFoodName = itemView.findViewById(R.id.foodName_normal);
            mainFoodDesc = itemView.findViewById(R.id.desc_normal);
            mainFoodPrice = itemView.findViewById(R.id.price_normal);
            addButtonToCart = itemView.findViewById(R.id.add_button_normal);

            addButtonToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foodNameFromAdapter = myNormalFoodItem.get(getAdapterPosition()).getfName();
                    priceFormAdapter = "£" + myNormalFoodItem.get(getAdapterPosition()).getfRate();
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    FlavorDialogue flavorDialogue = new FlavorDialogue();
                    flavorDialogue.show(activity.getSupportFragmentManager(),"Flavor");
                }
            });
        }
    }
}
