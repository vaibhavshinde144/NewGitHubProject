# Atrangi Document Workspace

All-in-one scanner, passport/ID photo studio, OCR, PDF tools, universal file workspace, viewers/editors, conversions, security and versioning.

## Website
The GitHub Pages workflow reconstructs the v7.1 standalone web app from `app-payload/` and publishes it.

## Android
The `android/` project is a basic installable WebView wrapper of the same v7.1 workspace. It supports Android camera/gallery/file selection and bundles the app into the APK during CI.

## Build APK
GitHub Actions runs the Android build and uploads `app-release.apk` as an artifact.

## Branch
This project is isolated on the `atrangi-document-workspace` branch so the existing `main` branch code is not replaced.