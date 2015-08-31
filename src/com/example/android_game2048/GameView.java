package com.example.android_game2048;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class GameView extends GridLayout {

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initView();
	}

	public GameView(Context context) {
		super(context);
		initView();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	private void initView() {
		setColumnCount(4);
		setBackgroundColor(0xffbbadc0);
		// TODO Auto-generated method stub
		setOnTouchListener(new OnTouchListener() {
			private float startX, startY, offsetX, offsetY;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:
					offsetX = event.getX() - startX;
					offsetY = event.getY() - startY;
					if (Math.abs(offsetX) > Math.abs(offsetY)) {
						if (offsetX < -5) {
							left();

						} else if (offsetX > 5)
							right();
					} else {
						if (offsetY < -5) {
							up();

						} else if (offsetY > 5) {
							down();
						}
					}

					break;
				}

				return true;
			}
		});

	}

	protected void down() {
		// TODO Auto-generated method stub
		boolean flag = false;

		for (int x = 0; x < 4; x++) {
			for (int y = 3; y >= 0; y--) {
				for (int y1 = y - 1; y1 >= 0; y1--) {
					if (cardLocation[x][y1].getNumber() > 0) {
						if (cardLocation[x][y].getNumber() == 0) {
							cardLocation[x][y].setNumber(cardLocation[x][y1]
									.getNumber());
							cardLocation[x][y1].setNumber(0);
							y++;
							flag = true;

						} else if (cardLocation[x][y]
								.equals(cardLocation[x][y1])) {
							cardLocation[x][y].setNumber(cardLocation[x][y]
									.getNumber() * 2);
							cardLocation[x][y1].setNumber(0);
							flag = true;

						}
						break;
					}
				}
			}
		}
		if (flag) {
			addRandom();
			flag = check();
			if (flag == false) {
				AlertDialog.Builder builder = new Builder(getContext());
				builder.setTitle("hello");
				builder.setMessage("game Over");
				builder.setPositiveButton("again",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								startGame();

							}
						});
				Toast.makeText(getContext(), "Ê§°Ü", Toast.LENGTH_LONG).show();
				startGame();
			}
		}
	}

	protected void up() {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int y1 = y + 1; y1 < 4; y1++) {
					if (cardLocation[x][y1].getNumber() > 0) {
						if (cardLocation[x][y].getNumber() == 0) {
							cardLocation[x][y].setNumber(cardLocation[x][y1]
									.getNumber());
							cardLocation[x][y1].setNumber(0);
							y--;
							flag = true;

						} else if (cardLocation[x][y]
								.equals(cardLocation[x][y1])) {
							cardLocation[x][y].setNumber(cardLocation[x][y]
									.getNumber() * 2);
							cardLocation[x][y1].setNumber(0);
							flag = true;

						}
						break;
					}
				}
			}
		}
		if (flag) {
			addRandom();
			flag = check();
			if (flag == false) {
				AlertDialog.Builder builder = new Builder(getContext());
				builder.setTitle("hello");
				builder.setMessage("game Over");
				builder.setPositiveButton("again",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								startGame();

							}
						});
				Toast.makeText(getContext(), "Ê§°Ü", Toast.LENGTH_LONG).show();
				startGame();
			}
		}

	}

	protected void right() {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 3; x >= 0; x--) {
				for (int x1 = x - 1; x1 >= 0; x1--) {
					if (cardLocation[x1][y].getNumber() > 0) {
						if (cardLocation[x][y].getNumber() == 0) {
							cardLocation[x][y].setNumber(cardLocation[x1][y]
									.getNumber());
							cardLocation[x1][y].setNumber(0);
							x++;
							flag = true;

						} else if (cardLocation[x][y]
								.equals(cardLocation[x1][y])) {
							cardLocation[x][y].setNumber(cardLocation[x][y]
									.getNumber() * 2);
							cardLocation[x1][y].setNumber(0);
							flag = true;

						}
						break;
					}
				}
			}
		}
		if (flag) {
			addRandom();
			flag = check();
			if (flag == false) {
				AlertDialog.Builder builder = new Builder(getContext());
				builder.setTitle("hello");
				builder.setMessage("game Over");
				builder.setPositiveButton("again",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								startGame();

							}
						});
				Toast.makeText(getContext(), "Ê§°Ü", Toast.LENGTH_LONG).show();
				startGame();
			}
		}
	}

	private void left() {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				for (int x1 = x + 1; x1 < 4; x1++) {
					if (cardLocation[x1][y].getNumber() > 0) {
						if (cardLocation[x][y].getNumber() == 0) {
							cardLocation[x][y].setNumber(cardLocation[x1][y]
									.getNumber());
							cardLocation[x1][y].setNumber(0);
							x--;
							flag = true;

						} else if (cardLocation[x][y]
								.equals(cardLocation[x1][y])) {
							cardLocation[x][y].setNumber(cardLocation[x][y]
									.getNumber() * 2);
							cardLocation[x1][y].setNumber(0);
							flag = true;

						}
						break;
					}
				}
			}
		}
		if (flag) {
			addRandom();
			flag = check();
			if (flag == false) {
				AlertDialog.Builder builder = new Builder(getContext());
				builder.setTitle("hello");
				builder.setMessage("game Over");
				builder.setPositiveButton("again",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								startGame();

							}
						});
				Toast.makeText(getContext(), "Ê§°Ü", Toast.LENGTH_LONG).show();
				startGame();
			}
		}

	}

	private boolean check() {
		// TODO Auto-generated method stub
		boolean result = false;
		ALL: for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (cardLocation[x][y].getNumber() == 0
						|| cardLocation[x + 1][y].getNumber() == 0
						|| cardLocation[x][y + 1].getNumber() == 0
						|| cardLocation[3][3].getNumber() == 0
						|| cardLocation[x][y].getNumber() == cardLocation[x + 1][y]
								.getNumber()
						|| cardLocation[x][y].getNumber() == cardLocation[x][y + 1]
								.getNumber()
						|| cardLocation[3][3].getNumber() == cardLocation[2][3]
								.getNumber()
						|| cardLocation[3][2].getNumber() == cardLocation[3][3]
								.getNumber()) {
					result = true;
					break ALL;
				}
			}
		}
		return result;

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		int cardWidth = (Math.min(h, w) - 10) / 4;
		addCard(cardWidth, cardWidth);
		startGame();
	}

	private void addCard(int cardWidth, int cardHeight) {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				Card c = new Card(getContext());
				c.setNumber(0);
				addView(c, cardWidth, cardHeight);
				cardLocation[x][y] = c;
			}
		}
	}

	private void addRandom() {
		point.clear();
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (cardLocation[x][y].getNumber() == 0) {
					point.add(new Point(x, y));
				}
			}
		}

		Point p = point.remove((int) (Math.random() * point.size()));
		cardLocation[p.x][p.y].setNumber(Math.random() > 0.1 ? 2 : 4);
	}

	private void startGame() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				cardLocation[x][y].setNumber(0);
			}
		}
		addRandom();
		addRandom();
	}

	private Card[][] cardLocation = new Card[4][4];
	private List<Point> point = new ArrayList<Point>();

}
