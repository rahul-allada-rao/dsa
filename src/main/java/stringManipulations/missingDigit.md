🎤 Follow-up Questions (Matthew-style)
Q1: "What if the array had two missing numbers instead of one? Does your formula still work? How would you solve it?"
Q2: "What if numbers weren't 1 to N but instead any arbitrary range — say 20 to 50? How would you adapt?"

I would do the arithmetic progression till 20 and another arithmetic progression till 50. Difference would give me the expectedSum for 20 - 50; then repeat what we have done in the current program, is this correct?

## Code Review First

**Perfect.** All fixes applied correctly — this is now a clean, optimal solution. ✅

---

## Q2 — Your Answer

**Correct thinking!** But let me sharpen the formula:

Sum of arbitrary range `a` to `b`:
```
expectedSum = (b - a + 1) * (a + b) / 2
```

Example for 20 to 50:
```
expectedSum = (50 - 20 + 1) * (20 + 50) / 2
            = 31 * 70 / 2
            = 1085
```

Your instinct was right — two progressions subtracted gives the same result. This formula is just cleaner. ✅

---

## Q1 — Two Missing Numbers

Honest answer: **this is a Medium-Hard problem.** Don't worry if you didn't know it. Let me teach it because Matthew *could* ask it as a follow-up.

**Why the sum formula breaks:**
One equation, two unknowns — you can't solve it.

```
x + y = knownValue  // one equation, not enough
```

**Solution — use sum AND sum of squares:**

```java
private static int[] twoMissingNumbers(int[] nums, int n) {
    // Two equations, two unknowns:
    // x + y = sumDiff
    // x² + y² = sumSqDiff

    long expectedSum = (long) n * (n + 1) / 2;
    long expectedSumSq = (long) n * (n + 1) * (2 * n + 1) / 6;

    long actualSum = 0, actualSumSq = 0;
    for (int num : nums) {
        actualSum += num;
        actualSumSq += (long) num * num;
    }

    long sumDiff = expectedSum - actualSum;       // x + y
    long sumSqDiff = expectedSumSq - actualSumSq; // x² + y²

    // x² + y² = (x+y)² - 2xy
    // so: xy = ((x+y)² - (x²+y²)) / 2
    long product = (sumDiff * sumDiff - sumSqDiff) / 2; // x * y

    // Now solve: x + y = sumDiff, x * y = product
    // Quadratic: t² - sumDiff*t + product = 0
    long discriminant = sumDiff * sumDiff - 4 * product;
    long sqrtDisc = (long) Math.sqrt(discriminant);

    long x = (sumDiff + sqrtDisc) / 2;
    long y = (sumDiff - sqrtDisc) / 2;

    return new int[]{(int) x, (int) y};
}
```

---

## 🧠 The Math Behind It (Simplified)

Think of it like high school algebra:
```
You know: x + y = 7
You know: x² + y² = 25

From these two equations → solve for x and y
x = 4, y = 3
```

That's exactly what the code does. Two equations, two unknowns. ✅

---

## 🎤 What To Say If Matthew Asks This

Don't panic. Say:

> *"The single sum formula breaks down with two unknowns — one equation can't solve two variables. I'd introduce a second equation using sum of squares, giving me two equations and two unknowns which I can solve algebraically. It's O(n) time, O(1) space."*

That answer alone — even without coding it — shows **Sr Staff mathematical thinking**. 🎯

---

## ✅ Problem 5 — Complete

Key takeaways:
1. `n = nums.length + 1` — always remember array is size N-1
2. Arithmetic progression formula: `n*(n+1)/2`
3. Arbitrary range formula: `(b-a+1)*(a+b)/2`
4. Two missing numbers → sum + sum of squares approach

---

Ready for **Problem 6 — Find the middle node of a linked list?** 💪