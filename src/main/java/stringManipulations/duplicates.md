Clean solution Rahul — correct logic, good structure. Let's review:

---

## ✅ What's Working Well

- Null/empty check ✅
- `getOrDefault` — learned from last problem ✅
- Correct duplicate logic (`count > 1`) ✅
- Clean separation of concerns ✅

---

## 🚨 Bug — Case Sensitivity Missing

You mentioned requirements include case insensitive handling, but your code treats `'P'` and `'p'` as different characters.

**Fix:** Add one line at the start:
```java
str = str.toLowerCase();
```

---

## 💡 Optimization 1 — Eliminate the intermediate `List`

You're using three separate loops and a `List` just to build the result array. You can simplify significantly:

```java
private static char[] duplicateCharacters(String str) {
    if (str == null || str.isEmpty()) return new char[]{};
    
    str = str.toLowerCase();
    
    HashMap<Character, Integer> charCount = new HashMap<>();
    for (char c : str.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }

    return charCount.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(e -> e.getKey())
            .collect(StringBuilder::new, 
                    (sb, c) -> sb.append(c), 
                    StringBuilder::append)
            .toString()
            .toCharArray();
}
```

Actually — that stream version gets complex. Your three-loop approach is **more readable** and perfectly acceptable in interviews. Don't over-engineer it.

---

## 💡 Optimization 2 — int array instead of HashMap

Same pattern as anagram problem — if input is a-z only:

```java
private static char[] duplicateCharactersOptimal(String str) {
    if (str == null || str.isEmpty()) return new char[]{};
    
    str = str.toLowerCase();
    int[] counts = new int[26];
    
    for (char c : str.toCharArray()) {
        counts[c - 'a']++;
    }
    
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 26; i++) {
        if (counts[i] > 1) {
            result.append((char) ('a' + i));
        }
    }
    
    return result.toString().toCharArray();
}
```

**Benefits:**
- O(1) space — fixed array of 26 ✅
- Single pass to count, single pass to collect ✅
- Naturally returns duplicates in **alphabetical order** ✅

---

## 📊 Scorecard

| Aspect | Rating |
|---|---|
| Correct logic | ✅ |
| Null/empty handling | ✅ |
| Case sensitivity | 🚨 Missing |
| `getOrDefault` usage | ✅ Learned and applied |
| Code readability | ⭐⭐⭐⭐ |
| Space optimization | 💡 int array is better |

---

## 🎤 Follow-up Question (Matthew-style)

> *"Your current solution returns duplicates in **random order** because HashMap doesn't preserve insertion order. If I asked you to return duplicates in the **order they first appear** in the string, how would you modify your approach?"*

Think about it — which data structure preserves insertion order in Java?

Answer that, then we move to **Problem 4 — Reverse words in a sentence.** 💪