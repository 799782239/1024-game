package com.example.android_game2048;

import android.R.color;
import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

	public Card(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		label = new TextView(getContext());
		label.setTextSize(22);
		label.setGravity(Gravity.CENTER);
		label.setBackgroundColor(0x33ffffff);
		LayoutParams lp = new LayoutParams(-1, -1);
		lp.setMargins(10, 10, 10, 10);
		addView(label, lp);
		setNumber(0);
	}

	private int number = 0;
	private TextView label;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		if (number == 0) {
			label.setText("");
		} else {
			label.setText(number + "");
		}
	}

	public boolean equals(Card card) {
		return getNumber() == card.getNumber();
	}

}
