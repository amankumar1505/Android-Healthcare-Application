package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String [][] doctor_details1 =
            {
                    { "Doctor Name : Aman1", "Hospital Address : Sak","Exp : 5yrs","Mobile No:9128053575","600"},
                    { "Doctor Name : Amar1", "Hospital Address : ra","Exp : 15yrs","Mobile No:9128053572","300"},
                    { "Doctor Name : Amit1", "Hospital Address : Sa","Exp : 8yrs","Mobile No:9128053570","900"},
                    { "Doctor Name : rishi1", "Hospital Address : Sak","Exp : 3yrs","Mobile No:9128053571","500"},
                    { "Doctor Name : mohan1", "Hospital Address : Sak","Exp : 2yrs","Mobile No:9128053573","400"},
            };
    private String [][] doctor_details2 =
            {
                    { "Doctor Name : Aman2", "Hospital Address : Sak","Exp : 5yrs","Mobile No:9128053575","600"},
                    { "Doctor Name : Amar2", "Hospital Address : ra","Exp : 15yrs","Mobile No:9128053572","300"},
                    { "Doctor Name : Amit2", "Hospital Address : Sa","Exp : 8yrs","Mobile No:9128053570","900"},
                    { "Doctor Name : rishi2", "Hospital Address : Sak","Exp : 3yrs","Mobile No:9128053571","500"},
                    { "Doctor Name : mohan2", "Hospital Address : Sak","Exp : 2yrs","Mobile No:9128053573","400"},
            };
    private String [][] doctor_details3 =
            {
                    { "Doctor Name : Aman3", "Hospital Address : Sak","Exp : 5yrs","Mobile No:9128053575","600"},
                    { "Doctor Name : Amar3", "Hospital Address : ra","Exp : 15yrs","Mobile No:9128053572","300"},
                    { "Doctor Name : Amit3", "Hospital Address : Sa","Exp : 8yrs","Mobile No:9128053570","900"},
                    { "Doctor Name : rishi3", "Hospital Address : Sak","Exp : 3yrs","Mobile No:9128053571","500"},
                    { "Doctor Name : mohan3", "Hospital Address : Sak","Exp : 2yrs","Mobile No:9128053573","400"},
            };
    private String [][] doctor_details4 =
            {
                    { "Doctor Name : Aman4", "Hospital Address : Sak","Exp : 5yrs","Mobile No:9128053575","600"},
                    { "Doctor Name : Amar4", "Hospital Address : ra","Exp : 15yrs","Mobile No:9128053572","300"},
                    { "Doctor Name : Amit4", "Hospital Address : Sa","Exp : 8yrs","Mobile No:9128053570","900"},
                    { "Doctor Name : rishi4", "Hospital Address : Sak","Exp : 3yrs","Mobile No:9128053571","500"},
                    { "Doctor Name : mohan4", "Hospital Address : Sak","Exp : 2yrs","Mobile No:9128053573","400"},
            };
    private String [][] doctor_details5 =
            {
                    { "Doctor Name : Aman5", "Hospital Address : Sak","Exp : 5yrs","Mobile No:9128053575","600"},
                    { "Doctor Name : Amar5", "Hospital Address : ra","Exp : 15yrs","Mobile No:9128053572","300"},
                    { "Doctor Name : Amit5", "Hospital Address : Sa","Exp : 8yrs","Mobile No:9128053570","900"},
                    { "Doctor Name : rishi5", "Hospital Address : Sak","Exp : 3yrs","Mobile No:9128053571","500"},
                    { "Doctor Name : mohan5", "Hospital Address : Sak","Exp : 2yrs","Mobile No:9128053573","400"},
            };



    TextView tv;
    Button btn;
    String [][] doctor_details ={};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewHATitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
         else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
      list = new ArrayList();
      for(int i=0;i<doctor_details.length;i++){
          item = new HashMap<String,String>();
          item.put("line1",doctor_details[i][0]);
          item.put("line2",doctor_details[i][1]);
          item.put("line3",doctor_details[i][2]);
          item.put("line4",doctor_details[i][3]);
          item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
          list.add(item);
      }
     sa = new SimpleAdapter(this,list,
             R.layout.multi_lines,
             new String[]{"line1","line2","line3","line4","line5"},
             new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
     );
        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);

            }
        });
    }
}