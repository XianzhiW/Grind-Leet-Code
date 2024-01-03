// Name: Xianzhi Wang 
// CSCI 201 Homework 1

public class CircleCountry {
    /**
     * 
     * @param x first coordinate for a point (x,y)
     * @param y second coordinate for a point (x,y)
     * @param cx first coordinate for center of a circle (cx, cy)
     * @param cy second coordinate for center of a circle (cx, cy)
     * @param r radius of a circle
     * @return return a boolean indicating whether point (x,y) is inside the circle or not
     */

    // Returns true if point (x,y) is inside circle determined by cx, cy, and r
    // and returns false otherwise
    public boolean isInside(int x, int y, int cx, int cy, int r) {
        // return the result of testing whether the square of the distance
        // from (cx,cy) to (x,y) is less than the square of the radius
        int distanceSquared = (x-cx)*(x-cx) + (y-cy)*(y-cy);
        int radiusSquared = r * r;
        return distanceSquared < radiusSquared;
    }

    public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
        int crosses = 0;
        // loop through all circles
        for (int k=0; k < x.length; k+= 1) {
            // if exactly one of (x1,y1) and (x2,y2) is inside circle k 
            // (specified by x[k], y[k], and r[k]), then increment crosses
            if (isInside(x1, y1, x[k], y[k], r[k]) ^ isInside(x2, y2, x[k], y[k], r[k])  ) {
                crosses++;
            }


        }
        return crosses;
    }

    public static void main(String[] args) {
        CircleCountry obj = new CircleCountry();
        int x1;
        int y1;
        int x2;
        int y2;
        // Example 1
        int[] example1_x = {0};
        int[] example1_y = {0};
        int[] example1_r = {2};
        x1 = -5; y1 = 1; x2 = 5; y2 = 1;
        System.out.println(obj.leastBorders(example1_x, example1_y, example1_r, x1, y1, x2, y2));
        // Example 2
        int[] example2_x = {0,-6,6};
        int[] example2_y = {0,1,2};
        int[] example2_r = {2,2,2};
        x1 = -5; y1 = 1; x2 = 5; y2 = 1;
        System.out.println(obj.leastBorders(example2_x, example2_y, example2_r, x1, y1, x2, y2));
    }
   
}
