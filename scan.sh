#!/bin/bash



DIR_REPO=$1

result_scan=$(find $1 -name "commons-text-1*.jar")
re=$(ls $1| grep "comm" )
echo $re
for item in result_scan
do

echo $item


done 
