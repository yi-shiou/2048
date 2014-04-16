package com.example.android_2048;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private static TextView[][] tv = new TextView[4][4];
	static int  x, y;
	int count=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById();
	/*	for(int i=0;i<4;i++)
			for(int j=0;j<4;j++) 
				tv[i][j].setText("1");*/
		newGame();
	}

	
	private void  newGame() {
		x=((int)(Math.random()*100))%4;
		y=((int)(Math.random()*100))%4;
		tv[x][y].setText("2");
		x=((int)(Math.random()*100))%4;
		y=((int)(Math.random()*100))%4;
		while(tv[x][y].getText().toString().equals("2")) {
			x=((int)(Math.random()*100))%4;
			y=((int)(Math.random()*100))%4;
		}
		tv[x][y].setText("2");
	}
	
	private Button.OnClickListener left = new Button.OnClickListener() {
		@Override
		public void onClick(View V) {
				for(int i=0;i<4;i++) 
					for(int j=0;j<4;j++) {
						count=4-j;
						if(tv[i][j].getText().toString().equals("")) {
							for(int k=1;k<count;k++)
								if(!tv[i][j+k].getText().toString().equals("")) {
									count = k;
									break;
								}
							tv[i][j].setText(tv[i][j+count].getText().toString());
							tv[i][j+count].setText("");
						}
				/*		else if(tv[i][j-1].getText().toString().equals(tv[i][j].getText().toString())) {
						tv[i][j-1].setText(Integer.parseInt(tv[i][j-1].getText().toString())*2);
						tv[i][j].setText("");
						}
						else {
						
						}*/
				}
		}
	};
	
	private Button.OnClickListener newG = new Button.OnClickListener() {
		@Override
		public void onClick(View V) {
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++) 
					tv[i][j].setText("");
			newGame();
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void findViewById() {
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		btn3 = (Button)findViewById(R.id.button3);
		btn4 = (Button)findViewById(R.id.button4);
		btn5 = (Button)findViewById(R.id.button5);
		btn1.setOnClickListener(left);
		btn5.setOnClickListener(newG);
		tv[0][0] = (TextView)findViewById(R.id.textView2);
		tv[0][1] = (TextView)findViewById(R.id.textView3);
		tv[0][2] = (TextView)findViewById(R.id.textView4);
		tv[0][3] = (TextView)findViewById(R.id.textView5);
		tv[1][0] = (TextView)findViewById(R.id.textView6);
		tv[1][1] = (TextView)findViewById(R.id.textView7);
		tv[1][2] = (TextView)findViewById(R.id.textView8);
		tv[1][3] = (TextView)findViewById(R.id.textView9);
		tv[2][0] = (TextView)findViewById(R.id.textView10);
		tv[2][1] = (TextView)findViewById(R.id.textView11);
		tv[2][2] = (TextView)findViewById(R.id.textView12);
		tv[2][3] = (TextView)findViewById(R.id.textView13);
		tv[3][0] = (TextView)findViewById(R.id.textView14);
		tv[3][1] = (TextView)findViewById(R.id.textView15);
		tv[3][2] = (TextView)findViewById(R.id.textView16);
		tv[3][3] = (TextView)findViewById(R.id.textView17);
	}

}


