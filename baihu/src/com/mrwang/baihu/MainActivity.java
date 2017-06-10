package com.mrwang.baihu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends Activity {
	
    private RadioButton r_san;
    private RadioButton r_si;
    private EditText edit_liveA;
    private EditText edit_dragA;
    private EditText edit_huA;
    private EditText edit_liveB;
    private EditText edit_dragB;
    private EditText edit_huB;
    private EditText edit_liveD;
    private EditText edit_dragD;
    private EditText edit_huD;
    private EditText bs;
    private EditText edit_liveC;
    private EditText edit_dragC;
    private EditText edit_huC;
    private TextView text_D;
    private TextView settlementA;
    private TextView settlementB;
    private TextView settlementC;
    private TextView settlementD;
    private Button btn12;
    int[] L = new int[4];
    int[] J = new int[4];
    int[] W = new int[4];
    int[] js = new int[4];
    int[] SS = new int[4];
    int[] zong = new int[4];


    private  int check = 0;
    private double beishuzhi;


    private void qingling(){

    }


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//定义变量

        //radio
        r_san = (RadioButton) findViewById(R.id.r_san);
        r_si = (RadioButton) findViewById(R.id.r_si);

        //EditText
        edit_liveA = (EditText)findViewById(R.id.edit_liveA);
        edit_dragA = (EditText)findViewById(R.id.edit_dragA);
        edit_huA = (EditText)findViewById(R.id.edit_huA);
        edit_liveB = (EditText)findViewById(R.id.edit_liveB);
        edit_dragB = (EditText)findViewById(R.id.edit_dragB);
        edit_huB = (EditText)findViewById(R.id.edit_huB);
        edit_liveC = (EditText)findViewById(R.id.edit_liveC);
        edit_dragC = (EditText)findViewById(R.id.edit_dragC);
        edit_huC = (EditText)findViewById(R.id.edit_huC);
        edit_liveD = (EditText)findViewById(R.id.edit_liveD);
        edit_dragD = (EditText)findViewById(R.id.edit_dragD);
        edit_huD = (EditText)findViewById(R.id.edit_huD);
        bs = (EditText)findViewById(R.id.edit_bs);

        //TextView
        text_D = (TextView)findViewById(R.id.text_D);
        settlementA = (TextView)findViewById(R.id.text_settlementA);
        settlementB = (TextView)findViewById(R.id.text_settlementB);
        settlementC = (TextView)findViewById(R.id.text_settlementC);
        settlementD = (TextView)findViewById(R.id.text_settlementD);

        //button
        btn12 = (Button)findViewById(R.id.buttondy);



        //处理按钮点击事件
        r_san.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_D.setEnabled(false);
                edit_liveD.setEnabled(false);
                edit_dragD.setEnabled(false);
                edit_huD.setEnabled(false);
                settlementD.setEnabled(false);
                check = 1;

            }
        });

        r_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_D.setEnabled(true);
                edit_liveD.setEnabled(true);
                edit_dragD.setEnabled(true);
                edit_huD.setEnabled(true);
                settlementD.setEnabled(true);
                check = 0;
            }
        });



        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //强转为整形
                L[0] = Integer.parseInt(edit_liveA.getText().toString()) ;
                J[0] = Integer.parseInt(edit_dragA.getText().toString()) ;
                W[0] = Integer.parseInt(edit_huA.getText().toString()) ;
                L[1] = Integer.parseInt(edit_liveB.getText().toString()) ;
                J[1] = Integer.parseInt(edit_dragB.getText().toString()) ;
                W[1] = Integer.parseInt(edit_huB.getText().toString()) ;
                L[2] = Integer.parseInt(edit_liveC.getText().toString()) ;
                J[2] = Integer.parseInt(edit_dragC.getText().toString()) ;
                W[2] = Integer.parseInt(edit_huC.getText().toString()) ;
                beishuzhi = Double.parseDouble( bs.getText().toString());
                if(check !=1)
                {
                    L[3] = Integer.parseInt(edit_liveD.getText().toString());
                    J[3] = Integer.parseInt(edit_dragD.getText().toString());
                    W[3] = Integer.parseInt(edit_huD.getText().toString());
                    for(int s=0;s<4;s++)
                        if(W[s]%10 != 0){
                            if(W[s]%10>=5){
                                W[s]+=(10-W[s]%10);
                            }
                            else W[s]-=W[s]%10;
                        }
                    for(int i=0;i<4;i++)
                    {
                        for(int j=0;j<4;j++)
                        {
                            if(i!=j)
                            {
                                if(J[i]>J[j])
                                {
                                    js[i]+=J[i]+J[j];
                                }
                                else  if(J[i]<J[j])
                                {
                                    js[i]-=J[i]+J[j];
                                }
                                else js[i]=js[i];
                            }
                        }

                    }

                    for(int i=0;i<4;i++)
                    {
                        for(int j=0;j<4;j++)
                        {
                            if(i!=j)
                            {
                                if(W[i]>W[j])
                                {
                                    SS[i]+=(W[i]-W[j])*beishuzhi*(L[i]+1)*(L[j]+1);


                                }
                                else if(W[i]<W[j])
                                {
                                    SS[i]-=(W[j]-W[i])*beishuzhi*(L[i]+1)*(L[j]+1);
                                }
                                else SS[i]=SS[i];
                            }
                        }

                    }
                    for(int i=0;i<4;i++)
                    {
                        zong[i]=js[i]+SS[i];
                    }
                    settlementA.setText(zong[0]+"");
                    settlementB.setText(zong[1]+"");
                    settlementC.setText(zong[2]+"");
                    settlementD.setText(zong[3]+"");
                    for(int i=0;i<4;i++)
                    {
                        js[i]=0;
                        SS[i]=0;
                    }
                }
                else
                {
                    for(int s=0;s<4;s++)
                        if(W[s]%10 != 0){
                            if(W[s]%10>=5){
                                W[s]+=(10-W[s]%10);
                            }
                            else W[s]-=W[s]%10;
                        }
                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(i!=j)
                            {
                                if(J[i]>J[j])
                                {
                                    js[i]+=J[i]+J[j];

                                }
                                else  if(J[i]<J[j])
                                {
                                    js[i]-=J[i]+J[j];
                                }
                                else js[i]=js[i];
                            }
                        }

                    }

                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(i!=j)
                            {
                                if(W[i]>W[j])
                                {
                                    SS[i]+=(W[i]-W[j])*beishuzhi*(L[i]+1)*(L[j]+1);
                                }
                                else if(W[i]<W[j])
                                {
                                    SS[i]-=(W[j]-W[i])*beishuzhi*(L[i]+1)*(L[j]+1);
                                }
                                else SS[i]=SS[i];
                            }
                        }

                    }
                    for(int i=0;i<3;i++)
                    {
                        zong[i]=js[i]+SS[i];
                    }
                    settlementA.setText(zong[0]+"");
                    settlementB.setText(zong[1]+"");
                    settlementC.setText(zong[2]+"");
                    for(int i=0;i<3;i++)
                    {
                        js[i]=0;
                        SS[i]=0;
                    }
                }
            }
        });
	}
}