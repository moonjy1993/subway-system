This is a program which shows the fastest path(or route) of stations when you give the input of depart and arrival station, and is written in Java during my gap semester in Korea in November, 2014.
Implemented with Dijkstra's Algorithm with the Korean Subway Data System from Seoul University Research Lab website.
*Since the datas were in Korean, only the inputs of Korean can be received and the outputs will show in Korean as well.

This contains 5 files 
-SubwayMain.java
      main function
      reads the data from "data.txt"file
-ListGraph.java
      receives data from main and creates the list graph
      weighted direction graph designed with the adjacent linked-list
-Dijkstra.java
       Dijkstra function which traces the vertices that will cost the minumum time
-StationNode.java
      defines the node of the list
-data.txt
      Korean Subway System Data
