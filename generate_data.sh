#!/bin/bash
# Generating a large dataset
generate_data() {
  for ((i=1; i<=10000000; i++)); do
    name=$(shuf -n 1 names.txt)
    score=$((RANDOM%1000+1))
    echo "$name|$score" >> data.txt
  done
}
# Call the function to generate data
generate_data