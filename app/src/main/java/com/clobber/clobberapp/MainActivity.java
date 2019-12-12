package com.clobber.clobberapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;


public class MainActivity extends AppCompatActivity {
    EditText productType, description, colour, size, quantity, address1, address2;
    Button btnRequest,btnRefresh,btnPayNow;
    TextView verify;
    DatabaseReference reff;
    Request member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Connected To Firebase",Toast.LENGTH_LONG).show();

        productType=(EditText)findViewById(R.id.productType);
        description=(EditText)findViewById(R.id.description);
        colour=(EditText)findViewById(R.id.colour);
        size=(EditText)findViewById(R.id.size);
        quantity=(EditText)findViewById(R.id.quantity);
        address1=(EditText)findViewById(R.id.address1);
        address2=(EditText)findViewById(R.id.address2);
        btnRequest=(Button)findViewById(R.id.btnRequest);
        btnRefresh=(Button)findViewById(R.id.btnRefresh);
        btnPayNow=(Button)findViewById(R.id.btnPayNow);
        verify=(TextView)findViewById(R.id.verify);
        member=new Request();
        reff= FirebaseDatabase.getInstance().getReference().child("Request");


        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantit=Integer.parseInt(quantity.getText().toString().trim());

                member.setProductType(productType.getText().toString().trim());
                member.setDescription(description.getText().toString().trim());
                member.setColour(colour.getText().toString().trim());
                member.setSize(size.getText().toString().trim());
                member.setQuantity(quantit);
                member.setAddress1(address1.getText().toString().trim());
                member.setAddress2(address2.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
            }
        });


        }


    }

