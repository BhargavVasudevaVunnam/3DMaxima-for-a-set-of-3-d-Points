# 3DMaxima-for-a-set-of-3-d-Points
# source https://en.wikipedia.org/wiki/Maxima_of_a_point_set

a point p in a finite set of points S is said to be maximal or non-dominated if there is no other point q in S whose coordinates are all greater than or equal to the corresponding
coordinates of p. The maxima of a point set S are all the maximal points of S. The problem of finding all maximal points, sometimes called the problem of the maxima or maxima set problem

# Approach Followed Or implemented
# https://en.wikipedia.org/wiki/Maxima_of_a_point_set#Three_dimensions
For points in three dimensions, it is again possible to find the maximal points in time O(n log n) using an algorithm similar to the two-dimensional one that performs the following steps:

-Sort the points in one of the coordinate dimensions (the x-coordinate, say)
-For each point, in decreasing order by x-coordinate, test whether its projection onto the yz plane is maximal among the set of projections of the set of points processed so far. If it is, 
 output the point as one of the maximal points, and remember its y-coordinate as the greatest seen so far.

The problems source is wikipedia. Need to provide the arguments as file names or the exact paths. arument 1 is for input file.
argument 2 is output file. A sample input file is provided. You can create a blank output file
