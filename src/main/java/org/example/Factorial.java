package org.example;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {

    private static Logger logger = LoggerFactory.getLogger(Factorial.class);

    public static void main(String[] args) {
        logger.info("FibonacciRecursive(9): {}", FibonacciRecursive.fibonacci(9));
        logger.info("FibonacciDP(9): {} ", FibonacciDP.fibonacci(9));
        logger.info("FibonacciIteration(9): {}",FibonacciIteration.fibonacci(9));
    }

    //    Recursive implementation of the Fibonacci method
    //    Time Complexity: O(2N)
    //    Auxiliary Space: O(n)
    public class FibonacciRecursive {
        public static long fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    //    Dynamic programming ( Fibonacci Series Using Memoization)
    //    Time Complexity: O(n)
    //    Auxiliary Space: O(n)
    public class FibonacciDP {
        private static Map<Integer, Long> memo = new HashMap<>();

        public static long fibonacci(int n) {
            if (n <= 1) {
                return n;
            }

            if (memo.containsKey(n)) {
                return memo.get(n);
            }

            long fib = fibonacci(n - 1) + fibonacci(n - 2);
            memo.put(n, fib);
            return fib;
        }

    }

    //    Fibonacci Series Using Iterative Approach
    //    Time Complexity: O(N)
    //    Auxiliary Space: O(1)
    public class FibonacciIteration{
        public static long fibonacci(int n) {
            int num1 = 0;
            int num2 = 1;
            int num3 = 0;

            for (int i = 2; i <= n; i++) {

                num3 = num2 + num1;
                num1 = num2;
                num2 = num3;
            }
            return num3;
        }

    }
}

