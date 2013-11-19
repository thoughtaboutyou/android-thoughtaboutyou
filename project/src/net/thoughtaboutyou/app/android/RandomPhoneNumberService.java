package net.thoughtaboutyou.app.android;

import java.util.Random;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.inject.Inject;

public class RandomPhoneNumberService implements PhoneNumberService {

	private final ContentResolver contentResolver;
	private final Random random;

	@Inject
	public RandomPhoneNumberService(ContentResolver contentResolver,
			Random random) {
		this.contentResolver = contentResolver;
		this.random = random;
	}

	public boolean canGetPhoneNumber() {
		Cursor phones = getAllPhoneNumbersCursor();

		boolean foundPhoneNumbers = phones.moveToFirst();

		phones.close();

		return foundPhoneNumbers;
	}

	private Cursor getAllPhoneNumbersCursor() {
		// TODO: use something like "Contacts Order BY RANDOM() LIMIT 1" instead
		// of looping through phone numbers.
		Cursor phones = this.contentResolver.query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
				null, null);
		return phones;
	}

	public String getPhoneNumber() {
		String randomPhoneNumber = null;
		Cursor phones = getAllPhoneNumbersCursor();

		if (phones.moveToFirst()) {
			int count = phones.getCount();
			int randomPhoneNumberIndex = this.random.nextInt(count);

			for (int i = 0; i <= randomPhoneNumberIndex; i++) {
				// String name = phones
				// .getString(phones
				// .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
				randomPhoneNumber = phones
						.getString(phones
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

				if (!phones.moveToNext()) {
					break;
				}
			}
		}
		phones.close();

		return randomPhoneNumber;
	}
}
