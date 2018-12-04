package com.example.vaibh.smartparking;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;


public class SlotActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button b, b1, b2, b3;
    private TextView tvStatusOne;
    private TextView tvStatusTwo;
    private TextView tvStatusThree;
    private TextView tvStatusFour;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);
        b = (Button) findViewById(R.id.button3);
        b1 = (Button) findViewById(R.id.button8);
        b2 = (Button) findViewById(R.id.button9);
        b3 = (Button) findViewById(R.id.button10);
        tvStatusOne = findViewById(R.id.avail1);
        tvStatusTwo = findViewById(R.id.avail2);
        tvStatusThree = findViewById(R.id.avail3);
        tvStatusFour = findViewById(R.id.avail4);
        btnRefresh = findViewById(R.id.btn_refresh);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        DatabaseReference devicechild = myRef.child("Blocks");
        DatabaseReference devicechildTwo = myRef.child("Blocks_two");
        DatabaseReference devicechildThree = myRef.child("Blocks_three");
        DatabaseReference devicechildFour = myRef.child("Blocks_four");
        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.getKey().equals("Blocks")) {
                        if (ds.getValue().toString().equals("0")) {
                            b.setBackgroundColor(Color.GREEN);
                            tvStatusOne.setText("Available");
                        } else {
                            b.setBackgroundColor(Color.RED);
                            tvStatusOne.setText("Unavailable");
                        }

                    } else if (ds.getKey().equals("Blocks_two")) {
                        if (ds.getValue().toString().equals("0")) {
                            b1.setBackgroundColor(Color.GREEN);
                            tvStatusTwo.setText("Available");
                        } else {
                            b1.setBackgroundColor(Color.RED);
                            tvStatusTwo.setText("Unavailable");
                        }
                    } else if (ds.getKey().equals("Blocks_three")) {
                        if (ds.getValue().toString().equals("0")) {
                            b2.setBackgroundColor(Color.GREEN);
                            tvStatusThree.setText("Available");
                        } else {
                            b2.setBackgroundColor(Color.RED);
                            tvStatusThree.setText("Unavailable");
                        }
                    } else if (ds.getKey().equals("Blocks_four")) {
                        if (ds.getValue().toString().equals("0")) {
                            b3.setBackgroundColor(Color.GREEN);
                            tvStatusFour.setText("Available");
                        } else {
                            b3.setBackgroundColor(Color.RED);
                            tvStatusFour.setText("Unavailable");
                        }
                    }




                    *//*if (ds.getValue().toString().equals("0")) {
                        b.setBackgroundColor(Color.GREEN);
                        b1.setBackgroundColor(Color.GREEN);
                        tvStatusOne.setText("Available");
                    } else {
                        b.setBackgroundColor(Color.RED);
                        b1.setBackgroundColor(Color.RED);
                        tvStatusOne.setText("Unavailable");
                    }*//*
                }
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("abc", "Failed to read value.", error.toException());
            }
        });*/

        btnRefresh.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btn_refresh) {


            RequestQueue requestQueue = Volley.newRequestQueue(this);

            StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, "https://api.thingspeak.com/channels/564368/feeds.json?results=2", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (response != null) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);


                            JSONArray feedObject = jsonObject.getJSONArray("feeds");

                            JSONObject firstObject = feedObject.getJSONObject(0);

                            try {
                                if (firstObject.getString("field1").equals("0") ||  firstObject.getString("field1").equals("null")) {
                                    b.setBackgroundColor(Color.GREEN);
                                    tvStatusOne.setText("Available");
                                } else {
                                    b.setBackgroundColor(Color.RED);
                                    tvStatusOne.setText("Unavailable");
                                }

                            } catch (Exception e) {
                                b.setBackgroundColor(Color.GREEN);
                                tvStatusOne.setText("Available");
                            }

                            try {
                                if (firstObject.getString("field2").equals("0") ||  firstObject.getString("field2").equals("null")) {
                                    b1.setBackgroundColor(Color.GREEN);
                                    tvStatusTwo.setText("Available");
                                } else {
                                    b1.setBackgroundColor(Color.RED);
                                    tvStatusTwo.setText("Unavailable");
                                }
                            } catch (Exception e) {
                                b1.setBackgroundColor(Color.GREEN);
                                tvStatusTwo.setText("Available");
                            }

                            try {
                                if (firstObject.getString("field3").equals("0") ||  firstObject.getString("field3").equals("null")) {
                                    b2.setBackgroundColor(Color.GREEN);
                                    tvStatusThree.setText("Available");
                                } else {
                                    b2.setBackgroundColor(Color.RED);
                                    tvStatusThree.setText("Unavailable");
                                }

                            } catch (Exception e) {
                                b2.setBackgroundColor(Color.GREEN);
                                tvStatusThree.setText("Available");
                            }

                            try {

                                if (firstObject.getString("field4").equals("0") ||  firstObject.getString("field4").equals("null")) {
                                    b3.setBackgroundColor(Color.GREEN);
                                    tvStatusFour.setText("Available");
                                } else {
                                    b3.setBackgroundColor(Color.RED);
                                    tvStatusFour.setText("Unavailable");
                                }

                            } catch (Exception e) {
                                b3.setBackgroundColor(Color.GREEN);
                                tvStatusFour.setText("Available");
                            }


                            Log.d("response", String.valueOf(firstObject));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(SlotActivity.this, "Sorry! Something went wrong", Toast.LENGTH_LONG).show();
                    }

                    Log.d("response", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("response", error.toString());
                }
            });

            requestQueue.add(stringRequest);
        }
    }
}
