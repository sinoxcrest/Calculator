package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText type;
    private TextView result;
    private Button btnC,btnbracket,btnpercentage,btndivide
            ,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0
            ,btnmultiply,btnsubtract,btnadd,btnplusminus,btndot,btnequalsto;
    private double val1=Double.NaN;
    private double val2;
    private final char ADD='+',SUBTRACT='-',DIVISION='/',MULTIPLY='*',EQUALSTO='0';
    private char ACTION;
    private int counterdot=0,counteradd=0,countersubtract=0,countermultiply=0,counterdivide=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      SettingViews();
      btnpercentage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(Double.isNaN(val1))
              {val1=Double.parseDouble(type.getText().toString());
              val1=val1/100;
              result.setText(String.valueOf(val1));}
              else{
                  val1=val1/100;
                  result.setText(String.valueOf(val1));
              }

          }
      });
      btnplusminus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(Double.isNaN(val1)){val1=Double.parseDouble(type.getText().toString());
              val1=-val1;

              result.setText(String.valueOf(val1));}
              else{
                  val1=-val1;
                  type.setText(String.valueOf(val1));
                  result.setText(String.valueOf(val1));
              }
          }
      });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
counterdot++;
if(counterdot>1){}
else {
    type.setText(type.getText().toString() + ".");
}

            }
        });
      btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type.setText(type.getText().toString()+"9");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().length()>0){
                    CharSequence name=type.getText().toString();
                    type.setText(name.subSequence(0,name.length()-1));
                    val1=Double.parseDouble(type.getText().toString());

                }

                else {
                val1=Double.NaN;
                 val2=Double.NaN;
                 type.setText(null);
                 result.setText(null);
                }
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counteradd++;
                if(counteradd>1){}else {
                    Algorithm();
                    ACTION = ADD;
                    result.setText(String.valueOf(val1) + "+");
                    type.setText(null);
                }
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countermultiply++;
                if (countermultiply > 1) {
                }else {
                    Algorithm();
                    ACTION = MULTIPLY;
                    result.setText(String.valueOf(val1) + "*");
                    type.setText(null);
                }}
        });
        btnsubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countersubtract++;
                if(countersubtract>1){}else {
                    Algorithm();
                    ACTION = SUBTRACT;
                    result.setText(String.valueOf(val1) + "-");
                    type.setText(null);
                }
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterdivide++;
                if(counterdivide>1){}else {
                    Algorithm();
                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + "/");
                    type.setText(null);
                }
            }
        });
btnequalsto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counteradd=counterdivide=counterdot=countermultiply=countersubtract=0;
        Algorithm();
        ACTION=EQUALSTO;
        result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
        CharSequence name=String.valueOf(val1);
        type.setText(name.subSequence(0,name.length()-2));
    }
});
    }
    private void SettingViews(){
        type=findViewById(R.id.type);
        result=findViewById(R.id.result);
        btnC=findViewById(R.id.btnC);
        btnbracket=findViewById(R.id.btnbracket);
        btnpercentage=findViewById(R.id.btnpercentage);
        btndivide=findViewById(R.id.btndivide);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);
        btnmultiply=findViewById(R.id.btnmultiply);
        btnsubtract=findViewById(R.id.btnsubtract);
        btnadd=findViewById(R.id.btnadd);
        btnplusminus=findViewById(R.id.btnplusminus);
        btndot=findViewById(R.id.btndot);
        btnequalsto=findViewById(R.id.btnequalsto);

    }
    private void Algorithm(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(type.getText().toString());
            switch(ACTION){
                case ADD:
                    val1=val1+val2;
                    break;
                case SUBTRACT:
                    val1=val1-val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case MULTIPLY:
                    val1=val1*val2;
                    break;
                case EQUALSTO:
                    break;
            }

        }
        else{
            val1=Double.parseDouble(type.getText().toString());
        }
    }
}
