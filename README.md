# [android-thoughtaboutyou](https://github.com/thoughtaboutyou/android-thoughtaboutyou)

[Thought About You][TAY] Android application



## Builds

## Android

```bash
sdkmanager --install 'platforms;android-19' 'build-tools;19.1.0'
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



## Releases

Releases of [Thought About You](https://play.google.com/store/apps/details?id=net.thoughtaboutyou.app.android) to the Google Play Store are done by the maintainers.


### Version numbers

Follow the [Semantic Versioning specification](https://semver.org/).


### Signing

The signing certificate for `net.thoughtaboutyou.app.android` is secret. It is to be kept in your personal `~/.m2/settings.xml`, under the profile `tay-android-release`.


### Release build

```bash
$ mvn -P release,tay-android-release clean install android:deploy android:run
```

To manually verify that the APK has been signed properly

```bash
$ jarsigner -verify -verbose -certs target/tay-android.apk
```



## License

Copyright (C) 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021 The Thought About You Project. All rights reserved.

Released to the public under the [GNU Affero General Public License v3](https://www.gnu.org/licenses/agpl-3.0.html) - see ```LICENSE```. Contact The Thought About You Project for additional licensing options.



[TAY]: https://thoughtaboutyou.net/
