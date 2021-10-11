package net.thoughtaboutyou.app.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class SquareButton extends Button {
	public SquareButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SquareButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SquareButton(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// https://stackoverflow.com/questions/4656986/how-do-i-keep-the-aspect-ratio-on-image-buttons-in-android
		// https://stackoverflow.com/a/7979110/
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
}
