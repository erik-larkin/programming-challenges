/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-tower-breakers-1/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

public class TowerBreakers 
{
    public static int towerBreakers(int n, int m) {
        if (m == 1)
            return 2;
        else
            return n % 2 == 0 ? 2 : 1;
    }
}
