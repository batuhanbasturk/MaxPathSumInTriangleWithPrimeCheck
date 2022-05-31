# MaxPathSumInTriangleWithPrimeCheck
You will have an orthogonal triangle input from a file and you need to find the maximum sum of the numbers according to given rules below; <br />

1. You will start from the top and move downwards to an adjacent number as in below. <br />
2. You are only allowed to walk downwards and diagonally. <br />
3. You can only walk over NON PRIME NUMBERS. <br />
4. You have to reach at the end of the pyramid as much as possible. <br />
5. You have to treat your input as pyramid. <br />

According to above rules the maximum sum of the numbers from top to bottom in below example is 24. <br />

1 <br />
8 4 <br />
2 6 9 <br />
8 5 9 3 <br />

As you can see this has several paths that fits the rule of NOT PRIME NUMBERS; 1>8>6>9, 1>4>6>9, 1>4>9>9 <br />
1 + 8 + 6 + 9 = 24.  As you see 1, 8, 6, 9 are all NOT PRIME NUMBERS and walking over these yields the maximum sum.
