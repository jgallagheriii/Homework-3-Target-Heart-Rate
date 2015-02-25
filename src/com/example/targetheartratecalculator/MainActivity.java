package com.example.targetheartratecalculator;

import java.text.NumberFormat;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private static final NumberFormat ageFormat = NumberFormat.getIntegerInstance();
	
	private int ageAmount = 0;
	private TextView ageDisplayTextView;
	private TextView maxHRDisplayTextView;
	private TextView lowHRDisplayTextView;
	private TextView highHRDisplayTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ageDisplayTextView = (TextView) findViewById(R.id.ageDisplayTextView);
		maxHRDisplayTextView = (TextView) findViewById(R.id.maxHRDisplayTextView);
		lowHRDisplayTextView = (TextView) findViewById(R.id.lowHRDisplayTextView);
		highHRDisplayTextView = (TextView) findViewById(R.id.highHRDisplayTextView);
		ageDisplayTextView.setText(ageFormat.format(ageAmount));
		updateStandard();
		
		EditText ageEditText = (EditText) findViewById(R.id.ageEditText);
		ageEditText.addTextChangedListener(ageEditTextWatcher);	
	}
	private void updateStandard()
	{
		int maxHR = 220 - ageAmount;
		double lowHR = maxHR/2;
		double highHR = maxHR * 0.85;
		
		maxHRDisplayTextView.setText(ageFormat.format(maxHR));
		lowHRDisplayTextView.setText(ageFormat.format(lowHR));
		highHRDisplayTextView.setText(ageFormat.format(highHR));
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private TextWatcher ageEditTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int befor, int count)
		{
			try
			{
				ageAmount = Integer.parseInt(s.toString());
			}
			catch (NumberFormatException e)
			{
				ageAmount = 0;
			}
			ageDisplayTextView.setText(ageFormat.format(ageAmount));
			updateStandard();
		}
		@Override
		public void afterTextChanged(Editable s)
		{
		}
		@Override
		public void beforeTextChanged(CharSequence s, int star, int count, int after)
		{
		}
	};
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
