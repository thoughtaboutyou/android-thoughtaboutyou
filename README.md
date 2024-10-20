# [android-thoughtaboutyou](https://github.com/thoughtaboutyou/android-thoughtaboutyou)

[Thought About You][TAY] Android application



## Builds


### Android

```bash
sdkmanager --install 'platforms;android-30' 'build-tools;30.0.3'
```


### Maven

[Maven](https://maven.apache.org/) 3.1.1 or higher is required.

```bash
$ mvn clean install android:deploy android:run
```


### Eclipse without Maven

Currently only tested for debug builds. Just launch TAY as an android application.


### Eclipse with Maven

Install [Maven Integration for Eclipse (M2E)](https://eclipse.org/m2e/) and use Maven 3.1.1 or higher. M2E 1.4 is built against Maven 3.0.4, so it's recommended to [download M2E 1.5](https://eclipse.org/m2e/download/) or higher.


### Dependency and plugin updates

```bash
mvn versions:use-latest-versions
```

```bash
mvn versions:display-plugin-updates
```

## Releases

Releases of [Thought About You](https://play.google.com/store/apps/details?id=net.thoughtaboutyou.app.android) to the Google Play Store are done by the maintainers.


### Version numbers

Follow the [Semantic Versioning specification](https://semver.org/).


### Release build

```bash
$ mvn -P release,tay-android-release clean install android:deploy android:run
```


### Signing

The signing certificate for `net.thoughtaboutyou.app.android` is secret. It is to be kept in your personal `~/.m2/settings.xml`, under the profile `tay-android-release`.

Android API level 30 APK files should have v1 signatures for backward compatibility and [requires v2 signatures](https://developer.android.com/about/versions/11/behavior-changes-11#minimum-signature-scheme) to run on Android 11. The same keystore file can be used to sign v1, v2, v3. These steps have not yet been automated in the current setup. Instead using a separate, manual signing step with [`uber-apk-signer`](https://github.com/patrickfav/uber-apk-signer).

```bash
# NOTE: use secret keystore values, same as ~/.m2/settings.xml.
# NOTE: check the output to verify that the APK verifications pass.
java -jar 'uber-apk-signer-1.2.1.jar' --verbose --allowResign --apks './target/tay-android-signed-aligned.apk' --ks ".../tay-android-release.keystore" --ksAlias "..." --ksPass "..." --ksKeyPass "..." --out './target/apksigner-v1-v2-v3/'

mv './target/apksigner-v1-v2-v3/tay-android-signed-aligned-aligned-signed.apk' './target/tay-android-release.apk'
```

The final release output is `./target/tay-android-release.apk`.



## License

Copyright (C) 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024 The Thought About You Project. All rights reserved.

Released to the public under the [GNU Affero General Public License v3](https://www.gnu.org/licenses/agpl-3.0.html) - see `LICENSE`. Contact The Thought About You Project for additional licensing options.



[TAY]: https://thoughtaboutyou.net/
