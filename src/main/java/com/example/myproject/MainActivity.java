package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout lc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("DASHBOARD");
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        lc=findViewById(R.id.lv);
        int id = item.getItemId();
        switch (id){
            case R.id.bt:
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.disable();
                    Toast.makeText(getApplicationContext(),item.getTitle()+" off", Toast.LENGTH_SHORT).show();
                }else {
                    mBluetoothAdapter.enable();
                    Toast.makeText(getApplicationContext(),item.getTitle()+" on",Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.auto:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                Intent i6= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i6);
                return true;
            case R.id.gallery:
//                Toast.makeText(getApplicationContext(),"opening:"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                Intent i1= new Intent(getApplicationContext(),fragmentmain.class);
//                startActivity(i1);
                return true;
            case R.id.call_action:
                lc.setBackgroundColor(Color.LTGRAY);
                Toast.makeText(this, "Calling Customer Care", Toast.LENGTH_SHORT).show();
                Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("tel:8929944156"));
                startActivity(i);
                return true;
            case R.id.SMS_action:
//                Intent i2= new Intent(getApplicationContext(),sms_to_another.class);
//                startActivity(i2);
                return true;
            case R.id.contact:
                Toast.makeText(this, "contact Selected", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent();
                i3.setAction(Intent.ACTION_VIEW);
                i3.setData(Uri.parse("content://contacts/people/"));
                startActivity(i3);
                return true;
            case R.id.gal:
                Toast.makeText(getApplicationContext(),"opening:"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                Intent i0= new Intent(getApplicationContext(),fragmentmain.class);
//                startActivity(i0);
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                lc.setBackgroundColor(Color.RED);
//                data.setText("COVID19 Helpline Number\t1950\n" +
//                        "Police Control Room\t0124-2316100\n" +
//                        "SMS to Police Control Room\t0124100\n" +
//                        "Cyber Crime Cell\t0124-2211033\n" +
//                        "Traffic Helpline Numbers\t9213020404");
//                Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_SHORT).show();
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }
}