package sg.edu.rp.c346.id22000765.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name,mobile,pax;
    DatePicker dp;
    TimePicker tp;
    RadioButton smoking;
    RadioButton nonSmoking;
    Button confirm,reset;
    TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.iptName);
        mobile=findViewById(R.id.iptMobile);
        pax=findViewById(R.id.iptNumOfPax);
        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        confirm=findViewById(R.id.btnConfirm);
        reset=findViewById(R.id.btnReset);
        display=findViewById(R.id.tvDisplay);
        smoking=findViewById(R.id.rbSmoking);
        nonSmoking=findViewById(R.id.rbNonSmoking);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setIs24HourView(true);
                String nameOutput=name.getText().toString();
                String mobileOutput=mobile.getText().toString();
                String paxOutput=pax.getText().toString();
                int Hour = tp.getCurrentHour();
                int Minute = tp.getCurrentMinute();
                int Month = dp.getMonth()+1;
                int DayOfMonth = dp.getDayOfMonth();
                int Year = dp.getYear();
                String area = smoking.isChecked()?"Smoking":"Non-Smoking";


                display.setText("Name: "+nameOutput+"\nMobile Number:"+ mobileOutput + "\nGroup Size: "
                        + paxOutput + "\nDate: " + DayOfMonth + "/" + Month + "/" + Year + "\nTime: "
                        + Hour + ":" + Minute + "\nArea: " + area);

                Toast.makeText(MainActivity.this,"Loading...",Toast.LENGTH_SHORT).show();


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setIs24HourView(true);

                name.setText("");
                mobile.setText("");
                pax.setText("");
                tp.setCurrentMinute(30);
                tp.setCurrentHour(19);
                dp.updateDate(2020, Calendar.JUNE,1);


            }
        });

        }
    }

