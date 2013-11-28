package net.thoughtaboutyou.app.android;

import com.google.inject.Binder;
import com.google.inject.Module;

public class GuiceModule implements Module {

	public void configure(Binder binder) {
		binder.bind(CallService.class).to(PhoneCallService.class);
		binder.bind(PhoneNumberService.class)
				.to(RandomPhoneNumberService.class);
	}
}
