/*
 *  https://www.hackerrank.com/challenges/grading/problem
 *  August 26th 2023
 *  By Erik Larkin
 */

import java.util.ArrayList;
import java.util.List;

public class GradingStudents 
{
	public static List<Integer> gradingStudents(List<Integer> grades) 
    {
		ArrayList<Integer> result = new ArrayList<Integer>(grades);

		for (int i = 0; i < result.size(); i++)
		{
			int grade = result.get(i);
			if (grade >= 38)
			{
				int modFive = grade % 5;
				int newGrade = grade;

				if (modFive >= 3)
					newGrade += (5 - modFive);
				
				result.set(i, newGrade);
			}
		}

		return result;
    }
}
