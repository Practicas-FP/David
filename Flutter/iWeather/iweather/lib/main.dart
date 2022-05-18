
import 'package:flutter/material.dart';
import 'package:iweather/ui/get_started.dart';

void main(){
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'iWeather',
      home: GetStarted(),
      debugShowCheckedModeBanner: false,
      
    );
  }
}