package ttit.com.shuvo.elaahitakeway.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.ElahiActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.FestivalActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainCategoryMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainMenuActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;

import static ttit.com.shuvo.elaahitakeway.homepage.OracleConnection.createConnection;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.ClickedItem, ConnectivityReceiver.ConnectivityReceiverListener {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CategoryItem> categoryItems;
    public static ArrayList<CategoryItem> mainCategoryName;
    public static ArrayList<CategoryItem> offerCategoryName;
    public static ArrayList<NormalFoodItem> festiveCategory;
    public static ArrayList<NormalFoodItem> elaahiCategory;

//    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
//    private static final String DEFAULT_URL = "jdbc:oracle:thin:@192.168.1.5:1521:TT";
//    private static final String DEFAULT_USERNAME = "ecomfood_demo";
//    private static final String DEFAULT_PASSWORD = "TTI";
    private Connection connection;
    private ProgressBar pppbar;

    private String message = null;
    private Boolean conn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("1","OFFER MENU"));
        categoryItems.add(new CategoryItem("2","MAIN MENU"));
        pppbar = findViewById(R.id.progressBar);
        pppbar.setVisibility(View.INVISIBLE);
//        pppbar.animate();
//        pppbar.clearAnimation();

        mainCategoryName = new ArrayList<>();
        offerCategoryName = new ArrayList<>();
        festiveCategory = new ArrayList<>();
        elaahiCategory = new ArrayList<>();



        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isConnected() && isOnline()) {

                    connectivity();

                    conn = true;
                    message= "Internet Connected";

                } else {
                    conn = false;
                    message = "Not Connected";
                }
            }
        }).start();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CategoryAdapter(categoryItems, this);
        recyclerView.setAdapter(adapter);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (conn) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setMessage("Please Check Your Internet Connection")
                    .setPositiveButton("Retry", null)
                    .show();

            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (isConnected() && isOnline()) {

                                connectivity();
                                conn = true;
                                message= "Internet Connected";

                            } else {
                                conn = false;
                                message = "Not Connected";
                            }
                        }
                    }).start();
//                    pppbar.animate();
                    if (conn) {
                        Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();

                        pppbar.setVisibility(View.INVISIBLE);
//                        pppbar.clearAnimation();
                        dialog.dismiss();
                    }else {
                        pppbar.setVisibility(View.INVISIBLE);
//                        pppbar.clearAnimation();
                        Toast.makeText(getApplicationContext(), "Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
//        if (isConnected() && isOnline()) {
//            Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
//            connectivity();
//            //Log.i("Array", mainMenuCategory.toString());
//        } else {
//            pppbar.setVisibility(View.INVISIBLE);
//            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
//            AlertDialog dialog = new AlertDialog.Builder(this)
//                    .setMessage("Please Check Your Internet Connection")
//                    .setPositiveButton("Retry", null)
//                    .show();
//
//            dialog.setCancelable(false);
//            dialog.setCanceledOnTouchOutside(false);
//            Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
//            positive.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
////                    pppbar.animate();
//                    if (isConnected() && isOnline()) {
//                        Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
//                        connectivity();
//                        pppbar.setVisibility(View.INVISIBLE);
////                        pppbar.clearAnimation();
//                        dialog.dismiss();
//                    }else {
//                        pppbar.setVisibility(View.INVISIBLE);
////                        pppbar.clearAnimation();
//                        Toast.makeText(getApplicationContext(), "Please Try Again", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//
//
//        }




        //adapter.setOnItemClickListener(MainActivity.this);



    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }

    public boolean isConnected() {
//        pppbar.setVisibility(View.VISIBLE);
        boolean connected = false;
        boolean isMobile = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            isMobile = nInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    public boolean isMobile() {
        boolean isMobile = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();

            isMobile = nInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            return isMobile;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return isMobile;
    }

    public boolean isOnline() {
//        pppbar.setVisibility(View.VISIBLE);
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 192.168.1.5");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException | InterruptedException e)          { e.printStackTrace(); }

        return false;
    }






//    public void viewFood (View view) {
//        Intent intent = new Intent(this, FoodActivity.class);
//        startActivity(intent);
//    }






    // @params - Menu Options created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                Log.i("Shopping","Selected");
                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
                return true;
            case R.id.subitem1:
                Toast.makeText(getApplicationContext(), "Sub Item 1 selected", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.subitem2:
                Toast.makeText(getApplicationContext(), "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }


    }

    @Override
    public void onCategoryClicked(int CategoryPosition) {


        String te = categoryItems.get(CategoryPosition).getIem_id();
        if (te.equals("1")) {
            String name = categoryItems.get(CategoryPosition).getmText();
            Intent intent = new Intent(this, OfferActivity.class);
            startActivity(intent);

        } else if (te.equals("2")){
            //Log.i("TEXT", te);
            String name = categoryItems.get(CategoryPosition).getmText();
            Intent intent = new Intent(this, MainCategoryMenu.class);
            startActivity(intent);

        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("LogOut!!")
                .setMessage("Are you sure want to Log Out?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //MainActivity.this.finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void connectivity() {
        mainCategoryName = new ArrayList<>();
        festiveCategory = new ArrayList<>();
        elaahiCategory = new ArrayList<>();
        offerCategoryName = new ArrayList<>();

        //Main Menu Category
        try {
            this.connection = createConnection();
//            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();


            Statement stmt = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();

            ResultSet mainMenuCategory = stmt.executeQuery("select IEM_ID,\n" +
                    "IEM_NAME,\n" +
                    "(SELECT FT_NAME FROM ELAAHI_FOOD_TAG WHERE FT_ID = ELAHI_ITEM_ECOM_MST_COPY.IEM_FOOD_TAG) AS FOOD_TAG,\n" +
                    "(select distinct EFT_NAME from ELAAHI_FOOD_TEST where EFT_ID = IEM_FOOD_TEST) AS FOOD_TEST,\n" +
                    "IEM_FOOD_FLAVOUR_NOTE as FOOD_NOTE\n" +
                    "from ELAHI_ITEM_ECOM_MST_COPY\n" +
                    "where IEM_TYPE = 1\n" +
                    "and iem_id not in (1,2,13,14)\n" +
                    "ORDER BY IEM_ID ASC");

            while (mainMenuCategory.next()) {
                stringBuffer.append(mainMenuCategory.getString(1) + "\n");
                stringBuffer1.append(mainMenuCategory.getString(2) + "\n");
                stringBuffer2.append(mainMenuCategory.getString(3) + "\n");
                stringBuffer3.append(mainMenuCategory.getString(4) + "\n");
                stringBuffer4.append(mainMenuCategory.getString(5) + "\n");

                mainCategoryName.add(new CategoryItem(mainMenuCategory.getString(1),mainMenuCategory.getString(2)));
            }

            System.out.println(stringBuffer);
            System.out.println(stringBuffer1);
            System.out.println(stringBuffer2);
            System.out.println(stringBuffer3);
            System.out.println(stringBuffer4);
            System.out.println(mainCategoryName);
            Log.i("Array", mainCategoryName.toString());

            connection.close();
        }
        catch (Exception e) {

//            Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_LONG).show();
            Log.i("ERRRRR", e.getLocalizedMessage());
            e.printStackTrace();
        }

        // Festival- Adult- Child
        try {
            this.connection = createConnection();
   //         Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();


            Statement stmt = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();


            ResultSet ss = stmt.executeQuery("SELECT EMMM_NAME, EMMM_RATE, EMMM_PERSON_TYPE, DECODE(EMMM_PERSON_TYPE,1,'ADULT','CHILD') AS EMMM_PERSON\n" +
                    "FROM ELAAHI_MEAL_MAKER_MST,ELAHI_ITEM_ECOM_MST_COPY\n" +
                    "WHERE ELAAHI_MEAL_MAKER_MST.EMMM_MENU_IEM_ID = ELAHI_ITEM_ECOM_MST_COPY.IEM_ID\n" +
                    "and ELAHI_ITEM_ECOM_MST_COPY.IEM_ID = 1\n" +
                    "order by EMMM_PERSON_TYPE asc");



            while (ss.next()) {
                stringBuffer.append(ss.getString(1)+ "\n");
                stringBuffer1.append(ss.getString(2)+ "\n");
                stringBuffer2.append(ss.getString(3)+ "\n");
                stringBuffer3.append(ss.getString(4)+ "\n");

                festiveCategory.add(new NormalFoodItem(ss.getString(4),ss.getString(3),"£"+ss.getString(2)));
            }
            System.out.println(stringBuffer);
            System.out.println(stringBuffer1);
            System.out.println(stringBuffer2);
            System.out.println(stringBuffer3);

            connection.close();
        }
        catch (Exception e) {

          //  Toast.makeText(MainActivity.this, ""+e,Toast.LENGTH_LONG).show();
            Log.i("ERRRRR", e.getLocalizedMessage());
            e.printStackTrace();
        }

        // Offer Menu Category
        try {
            this.connection = createConnection();
        //    Toast.makeText(MainActivity.this, "Connected",Toast.LENGTH_SHORT).show();


            Statement stmt = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();

            ResultSet rs=stmt.executeQuery("SELECT IEM_NAME, IEM_ID FROM ELAHI_ITEM_ECOM_MST_COPY WHERE IEM_ID IN (1,2) ORDER BY IEM_ID ASC");

            while(rs.next()) {
                stringBuffer.append(rs.getString(1)+ "\n");
                stringBuffer1.append( rs.getString(2)+"\n");

                offerCategoryName.add(new CategoryItem(rs.getString(2),rs.getString(1)));
            }
            System.out.println(stringBuffer);
            System.out.println(stringBuffer1);
            connection.close();
        }
        catch (Exception e) {

         //   Toast.makeText(MainActivity.this, ""+e,Toast.LENGTH_LONG).show();
            Log.i("ERRRRR", e.getLocalizedMessage());
            e.printStackTrace();
        }



        // Elaahi- Adult- Child
        try {
            this.connection = createConnection();
            //         Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();


            Statement stmt = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();


            ResultSet ss = stmt.executeQuery("SELECT EMMM_NAME, EMMM_RATE, EMMM_PERSON_TYPE, DECODE(EMMM_PERSON_TYPE,1,'ADULT','CHILD') AS EMMM_PERSON\n" +
                    "FROM ELAAHI_MEAL_MAKER_MST,ELAHI_ITEM_ECOM_MST_COPY\n" +
                    "WHERE ELAAHI_MEAL_MAKER_MST.EMMM_MENU_IEM_ID = ELAHI_ITEM_ECOM_MST_COPY.IEM_ID\n" +
                    "and ELAHI_ITEM_ECOM_MST_COPY.IEM_ID = 2\n" +
                    "order by EMMM_PERSON_TYPE asc");



            while (ss.next()) {
                stringBuffer.append(ss.getString(1)+ "\n");
                stringBuffer1.append(ss.getString(2)+ "\n");
                stringBuffer2.append(ss.getString(3)+ "\n");
                stringBuffer3.append(ss.getString(4)+ "\n");

                elaahiCategory.add(new NormalFoodItem(ss.getString(4),ss.getString(3),"£"+ss.getString(2)));
            }
            System.out.println(stringBuffer);
            System.out.println(stringBuffer1);
            System.out.println(stringBuffer2);
            System.out.println(stringBuffer3);

            connection.close();
        }
        catch (Exception e) {

            //  Toast.makeText(MainActivity.this, ""+e,Toast.LENGTH_LONG).show();
            Log.i("ERRRRR", e.getLocalizedMessage());
            e.printStackTrace();
        }


    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            color = Color.RED;
        }

//        Snackbar snackbar = Snackbar
//                .make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG);
//
//        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(color);
//        snackbar.show();
    }



}

