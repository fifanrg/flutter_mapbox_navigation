import '../helpers.dart';

class MapBoxLocation {
  double? latitude;
  double? longitude;
  double? speed;
  double? bearing;
  double? accuracy;

  MapBoxLocation(
    this.latitude,
    this.longitude,
    this.speed,
    this.bearing,
    this.accuracy,
  );

  MapBoxLocation.fromJson(Map<String, dynamic> json) {
    latitude = json['latitude'];
    longitude = json['longitude'];
    speed = json['speed'];
    bearing = json['bearing'];
    accuracy = json['accuracy'];
  }
}
