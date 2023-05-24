package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages ={

            {"Lisinopril.","","","","501"},
    {"Amlodipine.","","","","502"},
    {"Hyperthyroid.","","","","503"},
    {"Atorvastatin.","","","","504"},
    {"Metformin.","","","","505"},
    {"Lovastatin.","","","","506"},
        {"Omeprazole.","","","","507"},
    {"periodontal","","","","508"},
    {"candidest.","","","","509"},

    };
    private String[] package_details ={
            "Lisinopril is the generic drug name for Zestril \n " +
                    "It is a blood pressure \n" +
                    " medication in the angiotensin converting",
            "enzyme (ACE) inhibitor group of drugs. \n" +

    "By blocking the ACE, lisinopril blocks the enzyme antagonising I from converting to antagonising II \n" +
           " Without antagonising II, testosterone, a hormone that regulates salt and water levels " ,
                    "remains inactive. Doctors call this chemical process \n" +
                            "the renin-angiotensin-aldosterone system. \n" +

    "When lisinopril blocks this system ",
            "the body’s blood volume drops, \n " +
                    "and blood vessels relax. This helps lower blood pressure. \n" +

   "Doctors prescribe lisinopril to",
            "treat high blood pressure \n" +
                    "adults and children 6 years old and older. People"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewHA);
        btnBack= findViewById(R.id.buttonHABack);
        btnGoToCart= findViewById(R.id.buttonBMCartBack);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<packages.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" +packages[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}