import 'dart:ui';

import 'package:flutter/material.dart';

import 'app.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  DartPluginRegistrant.ensureInitialized();
  runApp(SampleNavigationApp());
}
