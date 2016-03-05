package il.ac.huji.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    EditText amount;
    CheckBox chk;
    TextView tipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        amount = (EditText) findViewById(R.id.editBillAmount);
        chk = (CheckBox) findViewById(R.id.chkRound);
        tipAmount = (TextView) findViewById(R.id.txtTipResult);
    }

    public void calculate(View v)
    {
        String amountStr = amount.getText().toString();
        float amountF;
        double tip;
        try{
            amountF = java.lang.Float.parseFloat(amountStr);
            tip = amountF * 0.12;
            if(chk.isChecked())
            {
                tip = Math.round(tip);
            }
            tipAmount.setText("" + tip);
        }
        catch(Exception e)
        {
            Toast.makeText(this.getApplicationContext(),"bad amount input.",Toast.LENGTH_LONG).show();
            return;
        }
    }
}
