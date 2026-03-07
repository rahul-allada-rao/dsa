Good approach Rahul — correct thinking, but there are **two bugs** and **some optimizations** to discuss. Let's go:

---

## 🚨 Bug 1 — Off-by-one error (Critical)

Look at your loop condition:

```
for (int i=0; i < str1.length() - 1; i++)
```

`i < str1.length() - 1` means you're **skipping the last character** of both strings!

For `str1 = "listen"`, you're only processing `l,i,s,t,e` — missing `n`.

**Fix:**
```
for (int i=0; i < str1.length(); i++)
```

Same bug exists in your second loop. Both need fixing.

---

## 🚨 Bug 2 — NullPointerException risk

In your final comparison loop:

```
if (!firstCharMap.get(character).equals(secondCharMap.get(character)))
```

If a character exists in `firstCharMap` but **not** in `secondCharMap`, then `secondCharMap.get(character)` returns **null** — and calling `.equals()` on null throws a NullPointerException.

**Fix:**
```
if (!firstCharMap.get(character).equals(secondCharMap.getOrDefault(character, 0)))
```

---

## 💡 Optimization 1 — Use single HashMap instead of two

You don't need two HashMaps. Use one:
- **Increment** for chars in str1
- **Decrement** for chars in str2
- If all values are 0 at the end → anagram ✅

```java
private static boolean areAnagrams(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    if (str1.length() != str2.length()) return false;

    // convert to lowercase for case-insensitive comparison
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    HashMap<Character, Integer> charMap = new HashMap<>();

    // increment for str1
    for (char c : str1.toCharArray()) {
        charMap.put(c, charMap.getOrDefault(c, 0) + 1);
    }

    // decrement for str2
    for (char c : str2.toCharArray()) {
        charMap.put(c, charMap.getOrDefault(c, 0) - 1);
    }

    // if any value != 0, not an anagram
    for (int count : charMap.values()) {
        if (count != 0) return false;
    }
    return true;
}
```

**Why better?**
- Half the memory — one map instead of two
- Cleaner code
- No NullPointerException risk

---

## 💡 Optimization 2 — Use merge/replace with cleaner Java

Also notice `getOrDefault` replaces your entire `containsKey` if/else block:

```
// Your version — verbose
if (!firstCharMap.containsKey(str1.charAt(i))){
    firstCharMap.put(str1.charAt(i), 1);
} else {
    firstCharMap.put(str1.charAt(i), firstCharMap.get(str1.charAt(i)) + 1);
}

// Cleaner version
charMap.put(c, charMap.getOrDefault(c, 0) + 1);
```

Same result, one line. Matthew will notice this. ✅

---

## 💡 Optimization 3 — int array instead of HashMap

If you want to impress further, use an **int array of size 26** instead of HashMap — faster and O(1) space:

```
private static boolean areAnagramsOptimal(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    if (str1.length() != str2.length()) return false;

    int[] counts = new int[26]; // a-z

    for (int i = 0; i < str1.length(); i++) {
        counts[str1.toLowerCase().charAt(i) - 'a']++;
        counts[str2.toLowerCase().charAt(i) - 'a']--;
    }

    for (int count : counts) {
        if (count != 0) return false;
    }
    return true;
}
```

**Why optimal?**
- Time: O(n) ✅
- Space: O(1) — fixed array of 26, regardless of input size ✅
- Single loop instead of two ✅

---

## 📊 Scorecard

| Aspect | Rating |
|---|---|
| Correct approach/thinking | ✅ |
| Off-by-one bug | 🚨 Critical fix needed |
| NullPointerException risk | 🚨 Fix needed |
| Case sensitivity handling | ❌ Missing |
| Code cleanliness | ⭐⭐⭐ |
| Optimized single map approach | 💡 Learn this |
| Optimal int array approach | 💡 Bonus level |

---

## 🎤 Follow-up Question (Matthew-style)

> *"Your HashMap approach works for Unicode characters like emojis or accented letters. But my int array approach only works for lowercase a-z. When would you choose HashMap over the int array approach, and why?"*

Answer that, then we move to **Problem 3 — Find duplicate characters in a string.** 💪