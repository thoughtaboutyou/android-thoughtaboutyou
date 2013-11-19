package net.thoughtaboutyou.app.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.google.inject.Inject;

public class PhoneCallService implements CallService {

	private static final String PHONE_CALL_INTENT_URI_PREFIX = "tel:"; //$NON-NLS-1$
	private final PhoneNumberService phoneNumberService;
	private final Context context;

	@Inject
	public PhoneCallService(PhoneNumberService phoneNumberService,
			Context context) {
		this.phoneNumberService = phoneNumberService;
		this.context = context;
	}

	public boolean call() {
		boolean success = false;

		if (this.phoneNumberService.canGetPhoneNumber()) {
			String number = this.phoneNumberService.getPhoneNumber();
			Uri uri = buildPhoneNumberIntentUri(number);

			Intent intent = new Intent(Intent.ACTION_CALL, uri);
			this.context.startActivity(intent);

			success = true;
		}

		return success;
	}

	private Uri buildPhoneNumberIntentUri(String number) {
		String url = PHONE_CALL_INTENT_URI_PREFIX + number;
		Uri uri = Uri.parse(url);
		return uri;
	}
}
