GithubCompose
==

Jepack Compose sample.

Currently(2019/07/20), Jepack Compose is pre-alpha. Please don't use this sample for production code.

## Setup

- Download Jetpack source code. See [this](https://android.googlesource.com/platform/frameworks/support/+/refs/heads/androidx-master-dev/README.md).

- Run below commands.

```
$ cd <repo_root>/frameworks/support
$ git checkout a86211d5b4
$ cd ui
$ git clone https://github.com/STAR-ZERO/GithubCompose.git githubcompose
```

- Add below to `<repo_root>/frameworks/support/ui/settings.gradle`.

```
include ':githubcompose'
```

- Open Android Studio

```
$ cd <repo_root>/frameworks/support/ui
$ ./studiow
```

