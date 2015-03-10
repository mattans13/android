package huji.ac.il.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calcTip(View view){
        EditText editText = (EditText)findViewById(R.id.edtBillAmount);
        double sum = Double.parseDouble(editText.getText().toString())*12/100;
        TextView textView = (TextView)findViewById((R.id.txtTipResult));
        CheckBox checkBox = (CheckBox)findViewById(R.id.chkRound);
        if(checkBox.isChecked() || (int)sum == sum) {
            sum = Math.floor(sum + 0.5);
            textView.setText(Integer.toString((int)sum));
        }
        else
            textView.setText(Double.toString(sum));
    }
}
