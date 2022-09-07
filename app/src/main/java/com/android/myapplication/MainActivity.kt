package com.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.citychoose.CityPickerActivity

class MainActivity : AppCompatActivity() {


    private val REQUEST_CODE_PICK_CITY = 0

    private var resultTV: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTV = findViewById(R.id.resultTV)
        resultTV?.setOnClickListener(View.OnClickListener {
            startActivityForResult(
                Intent(this@MainActivity, CityPickerActivity::class.java),
                REQUEST_CODE_PICK_CITY
            )
        })
    }

    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.resultTV);
        resultTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });
    }*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                val city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY)
                resultTV!!.text = "当前选择：$city"
            }
        }
    }

}