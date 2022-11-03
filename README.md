# Locus Backend Assignment

* [How to run the code](#run-the-code)
* [Sample request and response](#sample-request-and-response)
* [Design Principles](#design-principle)

# Run the code
1. Run mvn install in root directory
2. Open LocusApplication.java and run the main method


# Sample request and response
## request 
    Enter Lat for starting point:12.93175
    Enter Long for starting point:77.62872
    Enter Lat for ending point:12.92662
    Enter Long for ending point:77.63696
    Enter the distance you want between two equidistant points:50

## response
    
    50m distant points are:
    12.93175,77.62872,red,square
    12.93140692720155,77.62864056463076,red,square
    12.930950830265502,77.62884500141593,red,square
    12.930498157824653,77.62905487618985,red,square
    12.930034336864933,77.62924087367566,red,square
    12.929901190889627,77.62971135062797,red,square
    12.929786415345575,77.63019799893475,red,square
    12.929671604145126,77.63068462093243,red,square
    12.92956538932296,77.6311732091144,red,square
    12.92947921355733,77.6316655050987,red,square
    12.929467077882531,77.63215977258886,red,square
    12.92963602637591,77.63263006593976,red,square
    12.929854440246697,77.63307444024669,red,square
    12.929842599005918,77.6335635024852,red,square
    12.92961579192688,77.63400545030812,red,square
    12.929383182724159,77.63444469545973,red,square
    12.929176021681528,77.63489767247134,red,square
    12.928945863099301,77.63534154973706,red,square
    12.928716965455028,77.63578606908995,red,square
    12.928485340185704,77.63622882219823,red,square
    12.928280830986049,77.63668292253487,red,square
    12.927983231486001,77.6370787233073,red,square
    12.927627443519585,77.63742964922714,red,square
    12.9272808684303,77.63723217294026,red,square
    12.926802816202605,77.6371942794158,red,square
    12.92658,77.63716,red,square

Note on response: I was testing the response points using 
https://mobisoftinfotech.com/tools/plot-multiple-points-on-map/ which requires color and shape
along with lat and long

# Design Principle
    You can find seperation of concern design principle. 



