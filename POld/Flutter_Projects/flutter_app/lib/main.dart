import 'package:flutter/foundation.dart';
import "package:flutter/material.dart";
import './app_screens/first_screen.dart';

void main() =>  runApp( MyFlutterApp());

class MyFlutterApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: "Flutter App",
        home: Scaffold(
          appBar: AppBar(title: Text("First App Screen", style: TextStyle(color: Colors.black54, fontSize: 20.0)),),
          body: FirstScreen()
        )
    );
  }
}


