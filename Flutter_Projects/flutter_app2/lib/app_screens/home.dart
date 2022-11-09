import 'dart:ui';
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
        child: Container(
            padding: EdgeInsets.only(left: 10, top: 40),
            alignment: Alignment.center,
            color: Colors.deepPurple,
            child: Column(children: <Widget>[
              Row(children: <Widget>[
                Expanded(
                  child: Text("Spice Jet",
                      textDirection: TextDirection.ltr,
                      style: TextStyle(
                        fontFamily: 'Exo2',
                        fontWeight: FontWeight.w500,
                        decoration: TextDecoration.none,
                        fontSize: 25.0,
                        color: Colors.white,
                      )),
                ),
                Expanded(
                  child: Text("Bangalore to Delhi via Mumbai",
                      textDirection: TextDirection.ltr,
                      style: TextStyle(
                        fontFamily: 'Exo2',
                        fontWeight: FontWeight.w500,
                        decoration: TextDecoration.none,
                        fontSize: 15.0,
                        color: Colors.white,
                      )),
                ),
              ]),
              Row(children: <Widget>[
                Expanded(
                  child: Text("Air India",
                      textDirection: TextDirection.ltr,
                      style: TextStyle(
                        fontFamily: 'Exo2',
                        fontWeight: FontWeight.w500,
                        decoration: TextDecoration.none,
                        fontSize: 25.0,
                        color: Colors.white,
                      )),
                ),
                Expanded(
                  child: Text("Mumbai to Goa",
                      textDirection: TextDirection.ltr,
                      style: TextStyle(
                        fontFamily: 'Exo2',
                        fontWeight: FontWeight.w500,
                        decoration: TextDecoration.none,
                        fontSize: 15.0,
                        color: Colors.white,
                      )),
                ),
              ]),
              FlightImageAsset(),
              FlightBookButton()
            ])));
  }
}

class FlightImageAsset extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    AssetImage assetImage = AssetImage('assets/images/flight.png');
    Image image = Image(image: assetImage);
    return Container(child: image,);
  }
}

class FlightBookButton extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: RaisedButton(
          color: Colors.deepOrange,
          child: Text('Book Your Flight',
            style: TextStyle(fontFamily: 'Exo2', fontWeight: FontWeight.bold),
          ),
          elevation: 10.0,
          onPressed: () {
            bookFlight(context);
          }),
    );
  }
}

void bookFlight(BuildContext context) {
  var alertDialog = AlertDialog(
      title: Text("Flight booked successfully."),
      content: Text(
        "Have a pleasant trip")
  );

  showDialog(
      context: context,
      builder: (BuildContext context){
    return alertDialog;
}
);
}

