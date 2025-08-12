#!/bin/bash 
make 
#Wator without graphical output neither generating data to gnuplot
time ./Wa-tor -ni 100

#Wator with graphical output (10 iterations) and without generating data to gnuplot
#Uncomment next line to run on console. 
#time ./Wa-tor -o -ni 100

#Wator without graphical output but generating data to plot
#Uncomment next line to run on console.
#time ./Wa-tor -d -ni 100

#Wator with graphical output (10 itrations) and generating data to gnuplot
#Uncomment next line to run on console.
#time ./Wa-tor -o -d -ni 100


