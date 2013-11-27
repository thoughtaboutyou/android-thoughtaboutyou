package net.thoughtaboutyou.app.android;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.inject.Inject;

public class MainActivity extends RoboActivity {
	@Inject
	Context context;

	@Inject
	PhoneCallService phoneCallService;

	@InjectView(R.id.thinkAboutSomeoneButton)
	Button thinkAboutSomeoneButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		thinkAboutSomeoneButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Boolean success = phoneCallService.call();

				if (success) {
					// TODO: make sure TAY is activated after the call has
					// ended, and display success screen.
				} else {
					Toast.makeText(
							context,
							R.string.could_not_find_any_suitable_phone_numbers_to_call,
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_about:
			showAboutDialog();

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showAboutDialog() {
		// TODO: should this view be injected?
		View contentView = getLayoutInflater().inflate(R.layout.about, null,
				false);

		AlertDialog alertDialog = new AlertDialog.Builder(this)
				.setCustomTitle(null)
				.setPositiveButton(android.R.string.ok, null)
				.setView(contentView).create();

		alertDialog.show();
	}
}
