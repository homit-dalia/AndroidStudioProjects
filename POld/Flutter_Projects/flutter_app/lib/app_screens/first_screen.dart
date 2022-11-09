import 'dart:math';

import "package:flutter/material.dart";
import 'package:flutter_app/main.dart';

class FirstScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.lightBlueAccent,
      child: Center(
        child: Text(
          generateRandomNumber(),
          textDirection: TextDirection.ltr,
          style: TextStyle(color: Colors.black87, fontSize: 20.0, fontWeight: FontWeight.bold,),
        ),
      ),
    );
  }
}

String generateRandomNumber(){

  var random = Random();
  int luckyNumber= random.nextInt(100);
  return "Your lucky number is $luckyNumber";
}