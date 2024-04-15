#!/bin/bash

# Your client java class
CLIENT_CLASS="edu.bhcc.WeatherClient"
SERVER_CLASS="edu.bhcc.WeatherServer"
# Change this to the directory your pom.xml file is in
PROJECT_DIRECTORY="/Users/matthewdobler/Library/CloudStorage/OneDrive-Personal/Documents/CSC-285/HW5_Networking_and_Databases"

# Start date
DATE="2012-01-01"

# The number of client instances to create
CLIENT_COUNT=100

# Convert start date to seconds from Epoch
DATE_SECONDS=$(date -j -f "%Y-%m-%d" $DATE "+%s")

# Navigate to your project directory
cd $PROJECT_DIRECTORY

java -cp target/classes $SERVER_CLASS &
sleep 5
# Create client instances with date incremented by one day for each
for ((i=0; i<CLIENT_COUNT; i++)); do
  # Format the seconds back to a date string in YYYY-MM-DD format
  CLIENT_DATE=$(date -j -f "%s" $DATE_SECONDS "+%Y-%m-%d")

  echo "Starting client instance $((i+1)) with date $CLIENT_DATE"
  java -cp target/classes $CLIENT_CLASS $CLIENT_DATE &

  # Increment the date by one day in seconds (24*60*60)
  DATE_SECONDS=$((DATE_SECONDS+86400))
done