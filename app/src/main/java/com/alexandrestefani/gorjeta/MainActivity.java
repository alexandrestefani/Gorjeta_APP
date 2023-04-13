package com.alexandrestefani.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValue;
    private TextView tipTextValue;
    private TextView totalValue;
    private SeekBar seekbar;
    private TextView textSeekbar;

    private double percentage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.value_initial);
        tipTextValue = findViewById(R.id.text_tip_value);
        totalValue = findViewById(R.id.total_value);
        seekbar = findViewById(R.id.seekBar);
        textSeekbar = findViewById(R.id.text_seek_view);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentage = progress;
                textSeekbar.setText(Math.round(percentage) + "%");
                upDateValuesinView();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void upDateValuesinView(){
        String valueTyped = editValue.getText().toString();
        if(valueTyped == null || valueTyped.equals("")){
            Toast.makeText(getApplicationContext(),"Informe o valor",Toast.LENGTH_LONG).show();
        }else{

            //instanciar os calculos
            Engine engine = new Engine();

            //View referente a Gorjeta
            double valueTip = engine.tipValue(valueTyped,percentage);
            double valueTipRound = Math.round(valueTip);
            String valueTipRoundText = String.valueOf(valueTipRound);
            System.out.println("iupi "+valueTipRound);
            tipTextValue.setText("R$ " +valueTipRoundText);


            //View do total
            double valueTotal = engine.totalValue(valueTyped,valueTipRound);
            String valueTotalText = String.valueOf(valueTotal);
            totalValue.setText("R$ " + valueTotalText);
        }
    }


}