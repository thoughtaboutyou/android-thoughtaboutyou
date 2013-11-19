package net.thoughtaboutyou.app.android;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends RoboActivity {
	@InjectView(R.id.thinkAboutSomeoneButton)
	Button thinkAboutSomeoneButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		thinkAboutSomeoneButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO: call someone
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
