Create database Weather;

CREATE TABLE weather_data (
    date DATE PRIMARY KEY,
    precipitation DOUBLE,
    temp_max DOUBLE,
    temp_min DOUBLE,
    wind DOUBLE,
    weather VARCHAR(50)
);

