package com.example.rustem.quadraticequation;

import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * The program was developed for calculating root(s) of a quadratic
 * equation based on the values of a, b, c where the equation is y = ax^2 + bx + c
 * @author  Rustem Azimov
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The method was invoked automatically when the application is launched
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleButtonAction();
    }
    /*Method for doing some operations on input then inform users about the results*/
    public void handleButtonAction(){
        Button calcButton = (Button) findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override //The method works when the button is clicked
            public void onClick(View v) {
                TextView resultView = (TextView) findViewById(R.id.resultView);//Text for displaying output
                EditText aTxt = (EditText) findViewById(R.id.aTxt);//Text field for entering a
                EditText bTxt = (EditText) findViewById(R.id.bTxt);//Text field for entering b
                EditText cTxt = (EditText) findViewById(R.id.cTxt);//Text field for entering c
                try
                {
                    resultView.setText(prepareResult(Double.parseDouble(aTxt.getText().toString()),
                            Double.parseDouble(bTxt.getText().toString()),
                            Double.parseDouble(cTxt.getText().toString())
                    ));
                }catch(NumberFormatException e){
                    //If one of the parseDouble methods throws NumberFormatException because of not number using
                    Toast.makeText(MainActivity.this, "One of the input field wasn't filled with number", Toast.LENGTH_LONG);

                }

            }
        });

    }

    /**
     *
     * @param a
     *      a in the quadratic equation
     * @param b
     *      b in the quadratic equation
     * @param c
     *      c in the quadratic equation
     * @return
     */
    private String prepareResult(double a, double b, double c){
        QuadraticEquationSolver qES;
        try{
            qES = new QuadraticEquationSolver(a, b, c);
        }catch(RootNotFoundException e){
            return "Root wasn't found";
        }
        //Find roots of the function
        double x1 = qES.getX1(), x2 = qES.getX2();
        //Specifies that whether the function has 2 roots actually ?
        return (x1 == x2 ? ("The function has a root : " + x1) : ("Roots are : " + x1 + " | " + x2));
    }

}
