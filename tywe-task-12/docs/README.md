If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


## Written Answers(Task 12)

### Exercise 1
Size/Complexity | log n | n | n log n | n^2 | n^3 | 2^n | n! |   
--- | --- | --- | --- | --- | --- | --- | ---
1 | 0 | 1 | 0 | 1 | 1 | 2 | 1 
10 | 3.321 | 10 | 33.21 | 100 | 1000 | 1024 | 3628800
100 | 6.643 | 100 | 664.3 | 10000 | 1000000 | 1.3e30 | 9.3e157
1000 | 9.966 | 1000 | 9966 | 1e6 | 1e9 | 1e301 | 4e2567
10000 | 13.288 | 10000 | 132880 | 100000000 | 1e12 | 2e3010 | 3e35659
100000 | 16.61 | 100000 | 1661000 | 1e10 | 1e15 | 9.99e30102 | 3e456573
1000000 | 19.931 | 1000000 | 19931000 | 1e12 | 1e18 | 9.9e301029 | 8e5565708 

### Exercise 2


T(n) | 1 second | 1 minute | 1 hour | 1 day | 1 year | 
--- | --- | --- | --- | --- | --- |
log n | 3.3e9 | 2e11 | inf | 3e14 | inf | 
n | 1e9 | 6e10 | 3.6e12 | 8.6e13 | 3.2e16 | 
n log n | 3.96e7 | 1.94e9 | 9.8e10 | 2.11e12 | 6.4e14 |
n^2 | 31623 | 244949 | 1.8e6 | 9.2e6 | 1.8e8 |
n^3 | 1000 | 3915 | 15326 | 44208 | 315938 |
2^n | 30 | 36 | 41 | 46 | 54.8 |
n! | 12.29 | 13.86 | 15.37 | 16.5 | 18.54 | 

### Exercise 3

Functions in ascending order

f4(n) = n + 100

f3(n) = n log n

f1(n) = n^1.5

f5(n) = 2^n

f2(n) = 10^n

The following statements are true:

n (n + 1) / 2 = O(n^3), (c = 1, n0 > 1).
The statement n^3 > n (n + 1)/2 is true for n0 > 1. c = 1 is the 
coefficient of the functin n^3. In other words the function n^3
has a faster growth rate after n0 > 1. Hence it is the upper bound.

n (n + 1) / 2 = O(n^2), (c = 1, n0 > 1)
The statement n^2 > n (n + 1)/2 is true for n0 > 1. c = 1 is the coefficient
of the function n^2. In other words the function n^2 has a faster growth rate
when n0 > 1. Hence it is the upper bound. 

n (n + 1) / 2 = Ω(n), (c = 1, n0 > 1)
The statement n < n (n + 1)/2 is true for n0 > 1. c = 1 is the coefficient of
the function n. In other words the function n has a slower growth rate when
n0 > 1. Hence it is the lower bound. 

The following statement is not true: 
n (n + 1) / 2 = Θ(n^3)
Because the function n^3 has a much higher growth rate than n (n + 1)/2 it is 
impossible to find two coefficients for n^3, so that C1n^3 <= n (n + 1)/2 <= C2n^3 would
be true. Therefore n^3 cannot be an upper and lower bound for n (n + 1)/2.


### Exercise 4

Loop 1: (n - 1 + 1) = n, O(n)

Loop 2: (4n - 1 + 1) = 4n, O(n)

Loop 3: (n^2 - 1 + 1) = n^2, O(n^2)

Loop 4: 3n*3n = 9n^2, O(n^2)

Loop 5: (n^2*n^2) = n^4, O(n^4)


### Exercise 5

(n+1)^3 <= 2n^3, n0>(~4)
Inorder for n^3 to be an upper bound for (n+1)^3 it must have a coefficient of
2 . The statement (n+1)^3 <= 2n^3 is true only when n0 > 4 (approximate value). Use
this link to see the comparison: https://www.wolframalpha.com/input/?i=plot++%28n+%2B+1%29%5E3%2C+2n%5E3++from+n+%3D+0+to+5

### Exercise 6

The inner loop is the basic operation of the algorithm. It switches the index positions 
of succeeding numbers for each iteration. The time complexity of the algorithm is O(n^2).
 
 ### Exercise 7
 Average Case:
 Both Selection sort and insertion sort do n^2 comparisons.
 
 Best case:
 Insertion sort does n comparisons while selection sort does n^2
 comparisons. 
 
 While it doesnt matter which algoirthm one has to use with average 
 cases, it is best to use insertion sort with best case scenarios. 

 







