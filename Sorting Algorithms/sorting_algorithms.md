# Sorting Algorithms — Complete Study Notes

> Covers: Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, Quick Sort, Counting Sort  
> Depth: University-level algorithm course (complexity proofs, stability, tradeoffs, edge cases)

---

## Table of Contents

1. [Bubble Sort](#1-bubble-sort)
2. [Selection Sort](#2-selection-sort)
3. [Insertion Sort](#3-insertion-sort)
4. [Merge Sort](#4-merge-sort)
5. [Quick Sort](#5-quick-sort)
6. [Counting Sort](#6-counting-sort)
7. [Comparison Table](#7-comparison-table)
8. [Algorithm Selection Guide](#8-algorithm-selection-guide)

---

## 1. Bubble Sort

### Core Idea
Repeatedly compare adjacent elements and swap if out of order. After each full pass, the largest unsorted element "bubbles up" to its correct position at the end.

### How It Works
- Pass 1: Compare index 0–1, 1–2, …, (n-2)–(n-1). Largest element is now at index n-1.
- Pass 2: Repeat for indices 0 to n-2. Second largest is now at n-2.
- Repeat n-1 passes total.

**Optimization:** If no swap occurs during a full pass, the array is already sorted — terminate early.

```
Before: [5, 3, 8, 1]
Pass 1: [3, 5, 1, 8]   → 8 is in place
Pass 2: [3, 1, 5, 8]   → 5 is in place
Pass 3: [1, 3, 5, 8]   → done
```

### Time Complexity

| Case    | Complexity | Why                                                             |
|---------|------------|-----------------------------------------------------------------|
| Best    | O(n)       | Already sorted; early-exit optimization detects this in pass 1 |
| Average | O(n²)      | ~n²/4 comparisons and ~n²/4 swaps on average                   |
| Worst   | O(n²)      | Reverse-sorted; every comparison results in a swap              |

**Derivation:** In the worst case, pass i does (n - i) comparisons. Total = (n-1) + (n-2) + … + 1 = n(n-1)/2 = O(n²).

### Space Complexity
- **O(1)** auxiliary — in-place, only a temp variable for swaps.

### Stability
**Stable.** Equal elements are never swapped (condition is strictly `>`, not `>=`), so their relative order is preserved.

### Key Properties
- Simple but inefficient; rarely used in practice.
- The early-exit optimization makes it O(n) on nearly sorted data.
- Generates at most O(n²) writes — but Selection Sort does fewer swaps in practice.

### Advantages
- Simple to understand and implement.
- Stable — safe to use when relative order of equal elements matters.
- Adaptive — early-exit optimization gives O(n) on already-sorted input.
- Detects a sorted array in a single pass (with optimization).

### Disadvantages
- O(n²) average and worst case — impractical for large n.
- High number of swaps (up to O(n²)) — expensive if writes are costly.
- No advantage over Insertion Sort: Insertion Sort is strictly better in almost every practical scenario.

### When to Use
- Array is nearly sorted and n is small.
- Teaching/demonstration purposes.

---

## 2. Selection Sort

### Core Idea
Divide the array into a sorted region (left) and unsorted region (right). Each pass, find the minimum element in the unsorted region and swap it into the first position of that region.

### How It Works
- Pass i: Find minimum in subarray [i, n-1]. Swap it with element at index i.
- After pass i, elements [0, i] are sorted.
- Repeat for i = 0 to n-2.

```
Before:  [5, 3, 8, 1]
Pass 0:  min=1 at idx 3 → swap → [1, 3, 8, 5]
Pass 1:  min=3 at idx 1 → no swap → [1, 3, 8, 5]
Pass 2:  min=5 at idx 3 → swap → [1, 3, 5, 8]
```

### Time Complexity

| Case    | Complexity | Why                                                              |
|---------|------------|------------------------------------------------------------------|
| Best    | O(n²)      | Still scans the full unsorted region every pass — no early exit  |
| Average | O(n²)      | n(n-1)/2 comparisons always                                      |
| Worst   | O(n²)      | Same as best — the scan must complete regardless of order        |

**No best-case improvement:** unlike Bubble Sort, Selection Sort has no early exit. Even a sorted array costs O(n²).

### Space Complexity
- **O(1)** auxiliary — in-place.

### Stability
**Unstable.** The swap can move a later-occurring element ahead of an earlier equal one.

Example: `[3a, 3b, 1]` → swap 1 with 3a → `[1, 3b, 3a]` — relative order of 3a/3b is reversed.

### Key Properties
- Makes at most **O(n) swaps** — useful when write cost is high (e.g., flash memory).
- Always O(n²) comparisons regardless of input — no adaptive behavior.
- More swaps than Insertion Sort on nearly sorted data; fewer swaps than Bubble Sort in the worst case.

### Advantages
- Minimum number of swaps — at most n-1 swaps regardless of input. Ideal when write cost is high.
- Simple to implement.
- O(1) space — truly in-place.
- Performance is input-independent — predictable runtime (no surprise worst cases based on data shape, beyond the fixed O(n²)).

### Disadvantages
- Always O(n²) — no early exit, no adaptive behavior. Sorted input is no faster than random input.
- Unstable — cannot be used when equal elements must preserve relative order.
- Inferior to Insertion Sort for nearly sorted data (more comparisons, same number of swaps or more).

### When to Use
- When the cost of writing/swapping is very high and reads are cheap.
- Small arrays where simplicity matters.

---

## 3. Insertion Sort

### Core Idea
Maintain a sorted prefix. For each new element, shift it left into its correct position within the sorted prefix — like inserting a card into a sorted hand.

### How It Works
- Start with a sorted region of size 1 (just index 0).
- For each element at index i, compare it backward against the sorted prefix.
- Shift elements right until you find the correct insertion point. Insert.

```
Before:  [5, 3, 8, 1]
i=1:     key=3 → shift 5 right → [3, 5, 8, 1]
i=2:     key=8 → already in place → [3, 5, 8, 1]
i=3:     key=1 → shift 8, 5, 3 right → [1, 3, 5, 8]
```

### Time Complexity

| Case    | Complexity | Why                                                                   |
|---------|------------|-----------------------------------------------------------------------|
| Best    | O(n)       | Already sorted; each element needs 0 shifts, just 1 comparison each  |
| Average | O(n²)      | On random data, each element shifts ~i/2 positions on average         |
| Worst   | O(n²)      | Reverse-sorted; element at index i shifts i positions every time      |

**Inversion-based analysis:** The number of shifts equals the number of inversions in the array. A sorted array has 0 inversions (O(n)). A reverse-sorted array has n(n-1)/2 inversions (O(n²)).

### Space Complexity
- **O(1)** auxiliary — in-place.

### Stability
**Stable.** The inner loop stops when it finds an element ≤ key, so equal elements are never moved past each other.

### Key Properties
- **Adaptive:** performance degrades gracefully from O(n) toward O(n²) as disorder increases.
- **Online algorithm:** can sort a list as elements arrive one by one.
- Low overhead — very fast in practice for small n (no recursive overhead, good cache behavior). Used inside Timsort and Introsort for small subarrays.
- Binary Insertion Sort variant: use binary search to find insertion point → reduces comparisons to O(n log n) but shifts are still O(n²).

### Advantages
- Adaptive — O(n) on nearly sorted input; performance scales with actual disorder.
- Stable — preserves relative order of equal elements.
- Online — can sort a stream of incoming data without knowing the full input first.
- O(1) space — in-place with no auxiliary array needed.
- Low constant factors — fastest of the three O(n²) sorts in practice for small n due to simple inner loop and good cache behavior.
- Used as the base case in Timsort and Introsort for small subarrays.

### Disadvantages
- O(n²) worst case — reverse-sorted input is the worst case.
- Slow for large, randomly ordered data — outclassed by Merge Sort and Quick Sort.
- Binary Insertion Sort reduces comparisons but not shifts — still O(n²) moves.

### When to Use
- Array is nearly sorted (few inversions).
- Small n (typically n ≤ 20–30 as a subroutine in hybrid sorts).
- Online sorting (streaming elements).

---

## 4. Merge Sort

### Core Idea
Divide-and-conquer. Recursively split the array in half until subarrays have size 1 (trivially sorted), then merge pairs of sorted subarrays back into a single sorted array.

### How It Works
1. **Divide:** Split array into left half and right half.
2. **Conquer:** Recursively sort each half.
3. **Merge:** Merge two sorted halves using a two-pointer scan into a temp array, then copy back.

```
[5, 3, 8, 1]
    ↙       ↘
[5, 3]    [8, 1]
 ↙  ↘      ↙  ↘
[5] [3]  [8] [1]
 ↘  ↙      ↘  ↙
[3, 5]    [1, 8]
    ↘       ↙
[1, 3, 5, 8]
```

**Merge step:** Two pointers scan left and right halves. At each step, copy the smaller element into the temp array. Append remaining elements when one half is exhausted.

### Time Complexity

| Case    | Complexity  | Why                                                          |
|---------|-------------|--------------------------------------------------------------|
| Best    | O(n log n)  | Always divides into equal halves; merge is always O(n)       |
| Average | O(n log n)  | Same recurrence regardless of input order                    |
| Worst   | O(n log n)  | Guaranteed — input order doesn't affect the divide structure |

**Recurrence:** T(n) = 2T(n/2) + O(n). By Master Theorem (case 2): T(n) = O(n log n).

**Proof sketch:** There are log n levels of recursion. At each level, total merge work across all subproblems sums to O(n). So total = O(n) × O(log n) = O(n log n).

### Space Complexity
- **O(n)** auxiliary — temp array of size n needed for merging.
- **O(log n)** stack space for recursion.

### Stability
**Stable.** During the merge, when elements from left and right halves are equal, always take from the left half first — this preserves relative order.

### Key Properties
- Only comparison-based sort with guaranteed O(n log n) worst case.
- Not in-place (O(n) space is a hard cost in standard implementation).
- **Preferred for linked lists** — no random access needed; merging linked lists is O(1) space.
- **External sort:** when data doesn't fit in memory, Merge Sort generalizes naturally to disk-based sorting.
- Used in Timsort (Python, Java Collections, Android, Swift) — modified for real-world nearly-sorted data.
- Parallelizable: subarrays can be sorted independently.
- Can count inversions in O(n log n) — a classic application.

### Applications
- Sorting linked lists (preferred over Quick Sort here).
- External sorting (large datasets on disk).
- Inversion counting.
- Merge operation used in: union/intersection of sorted arrays, k-way merge problems.

### Advantages
- Guaranteed O(n log n) in all cases — no degenerate input can make it worse.
- Stable — safe for sorting records with multiple keys (e.g., sort by name, then by age).
- Ideal for linked lists — merging linked lists requires no extra space; only pointer changes needed.
- Naturally parallelizable — subarrays can be sorted independently on separate threads/machines.
- Well-suited for external sorting — can merge sorted chunks from disk without loading all data into memory.

### Disadvantages
- O(n) auxiliary space — requires a temporary array for merging; cannot sort truly in-place without significant complexity.
- Slower than Quick Sort in practice — larger constant factors; more memory accesses, worse cache behavior.
- Not adaptive — takes the same O(n log n) time on already-sorted input (no benefit from prior order).
- Recursive overhead — function call stack adds overhead for small arrays (hybrid sorts like Timsort use Insertion Sort for small subarrays to compensate).

### When to Use
- Need guaranteed O(n log n) worst case.
- Sorting linked lists.
- Stable sort required on large data.
- External/disk-based sorting.

---

## 5. Quick Sort

### Core Idea
Divide-and-conquer. Choose a pivot element. Partition the array so all elements ≤ pivot are on the left, all elements > pivot are on the right. Recursively sort each side.

### How It Works (Lomuto Partition Scheme)
1. Choose pivot (e.g., last element).
2. Partition: maintain pointer i starting before the array. For each element j, if arr[j] ≤ pivot, increment i and swap arr[i] with arr[j].
3. Swap pivot into position i+1. Pivot is now in its final sorted position.
4. Recurse on [lo, pivot-1] and [pivot+1, hi].

```
Array: [3, 6, 8, 10, 1, 2, 1], pivot = 1 (last)
After partition: [1, 1, 8, 10, 6, 2, 3] → pivot at index 1 (example varies by scheme)
```

**Hoare Partition Scheme** (two pointers moving inward) is faster in practice — fewer swaps — but trickier to implement correctly.

### Time Complexity

| Case    | Complexity  | Why                                                                        |
|---------|-------------|----------------------------------------------------------------------------|
| Best    | O(n log n)  | Pivot always splits array into two equal halves                            |
| Average | O(n log n)  | Expected with random pivot; recurrence T(n) = T(k) + T(n-k-1) + O(n)     |
| Worst   | O(n²)       | Pivot is always the min or max — one partition has 0 elements, other n-1  |

**Worst case trigger:** already sorted or reverse-sorted array with naive pivot (first or last element). Each partition puts 0 elements on one side.

**Average case derivation:** With random pivot, expected split is roughly equal. Expected T(n) = O(n log n) by recurrence analysis (harmonic number argument).

### Space Complexity
- **O(log n)** average stack space (recursion depth).
- **O(n)** worst case stack space (unbalanced partitions — degenerate case).
- In-place partitioning — O(1) auxiliary data.

### Stability
**Unstable.** Elements equal to the pivot can get reordered during partitioning.

### Key Properties
- **Fastest in practice** for in-memory sorting of arrays — excellent cache performance (in-place, sequential access).
- Much faster than Merge Sort in practice due to smaller constant factors and cache friendliness, even though both are O(n log n) average.
- **Randomized Quick Sort:** choose pivot randomly → reduces probability of worst case to negligible. Expected O(n log n) regardless of input.
- **3-way Quick Sort (Dutch National Flag):** partition into < pivot, = pivot, > pivot. Handles many duplicates in O(n) for all-equal input. Standard Quick Sort degrades to O(n²) on all-equal input.
- `Arrays.sort()` in Java uses Dual-Pivot Quick Sort for primitives.
- **Introsort:** Quick Sort + heap sort fallback when recursion depth exceeds 2 log n → guarantees O(n log n) worst case. Used in C++ STL `std::sort`.

### Pivot Selection Strategies

| Strategy          | Description                                      | Risk                           |
|-------------------|--------------------------------------------------|--------------------------------|
| Last element      | Simple to implement                              | O(n²) on sorted input          |
| First element     | Simple                                           | O(n²) on sorted input          |
| Random element    | Pick random index                                | Expected O(n log n)            |
| Median-of-three   | Median of first, middle, last elements           | Good heuristic for real data   |
| Median-of-medians | True O(n) median selection                       | Guarantees O(n log n) worst case but large constant |

### Advantages
- Fastest in practice for in-memory array sorting — in-place, small constant factors, excellent cache locality.
- O(log n) average space — far better than Merge Sort's O(n).
- Highly optimizable — pivot strategies, 3-way partitioning, dual-pivot variants (used in Java's `Arrays.sort`).
- Average O(n log n) with random pivot — pathological inputs become statistically negligible.

### Disadvantages
- O(n²) worst case — naive implementation on sorted/reverse-sorted input. Must use randomization or median-of-three to mitigate.
- Unstable — cannot be used when sort stability is required.
- O(n) worst-case stack space — deep recursion on degenerate inputs can cause stack overflow.
- Poor on linked lists — no O(1) random access; partitioning requires traversal.
- All-equal input degrades to O(n²) without 3-way partitioning.

### When to Use
- General-purpose in-memory sorting of arrays.
- When average-case performance matters more than worst-case guarantee.
- When cache performance is critical.
- Do not use on linked lists (no O(1) random access for partitioning).

---

## 6. Counting Sort

### Core Idea
Non-comparison-based sort. Count the frequency of each distinct value, compute cumulative counts (prefix sums), then place each element directly into its correct output position. Works only for integer keys in a known, bounded range.

### How It Works
1. Find range: min value `min`, max value `max`. Let `k = max - min + 1`.
2. Create count array of size k, initialize to 0.
3. For each element x in input, increment `count[x - min]`.
4. Compute prefix sums: `count[i] += count[i-1]` for i = 1 to k-1. Now `count[i]` holds the number of elements ≤ (i + min).
5. Iterate input from right to left: place element x at output index `--count[x - min]`. (Right-to-left preserves stability.)

```
Input:  [4, 2, 2, 8, 3, 3, 1],  range = [1, 8], k = 8
Count:  [1, 2, 2, 1, 0, 0, 0, 1]  (after counting)
Prefix: [1, 3, 5, 6, 6, 6, 6, 7]  (after prefix sum)
Output: [1, 2, 2, 3, 3, 4, 8]
```

### Time Complexity

| Case    | Complexity | Why                                                               |
|---------|------------|-------------------------------------------------------------------|
| Best    | O(n + k)   | k = range of values; counting pass O(n), output pass O(n + k)    |
| Average | O(n + k)   | Same — no branching on element values                             |
| Worst   | O(n + k)   | Fully determined by n and k                                       |

**When is it O(n)?** When k = O(n), i.e., the range is proportional to the number of elements. If k >> n (sparse range), the O(k) dominates and it becomes inefficient.

### Space Complexity
- **O(n + k)** — count array of size k, output array of size n.

### Stability
**Stable** when implemented correctly (right-to-left output placement). This is what makes Counting Sort useful as a subroutine in Radix Sort.

### Key Properties
- **Not a comparison sort** — breaks the O(n log n) lower bound for comparison-based sorting.
- **Only for integers (or keys mappable to integers) with a known bounded range.**
- Impractical when k is very large (e.g., sorting 32-bit integers would need a 4-billion-element array).
- Used as a subroutine in Radix Sort (sort digit by digit, each pass uses Counting Sort).

### Advantages
- Breaks the O(n log n) comparison-sort lower bound — O(n + k) is linear when k = O(n).
- Stable — relative order of equal elements preserved (critical for its role in Radix Sort).
- Simple to implement once the idea is understood.
- No comparisons at all — performance is entirely independent of the order of the input.

### Disadvantages
- Only works for integer (or integer-mappable) keys with a known, bounded range.
- O(n + k) space — if k >> n, memory usage is prohibitive (e.g., k = 10⁹ is not feasible).
- Not in-place — requires auxiliary count array and output array.
- Cannot sort floating-point numbers, strings, or complex objects directly.
- Useless when the key range is unknown or unbounded.

### When to Use
- Keys are integers in a known, small range.
- n and k are of similar magnitude (k = O(n)).
- Examples: sort exam scores 0–100, sort characters in a string (k = 256 for ASCII).

### When NOT to Use
- Large or floating-point key ranges.
- Keys aren't integers or can't be mapped to a small integer range.

---

## 7. Comparison Table

| Algorithm      | Best       | Average    | Worst      | Space    | Stable | In-Place | Adaptive |
|----------------|------------|------------|------------|----------|--------|----------|----------|
| Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    | Yes      | Yes      |
| Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     | No     | Yes      | No       |
| Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    | Yes      | Yes      |
| Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes    | No       | No       |
| Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) | No     | Yes      | No       |
| Counting Sort  | O(n + k)   | O(n + k)   | O(n + k)   | O(n + k) | Yes    | No       | No       |

**Adaptive** = performs better on nearly sorted input.  
**Stable** = equal elements maintain their original relative order.  
**In-Place** = O(1) auxiliary space (not counting recursion stack).

---

## 8. Algorithm Selection Guide

### Decision Framework

**Is k (key range) small and keys are integers?**  
→ **Counting Sort** — O(n + k), beats every comparison sort.

**Is worst-case guarantee required AND stability required?**  
→ **Merge Sort** — only comparison sort with both.

**Is worst-case guarantee required, stability not needed?**  
→ **Merge Sort** (or Introsort/Heapsort — not covered here).

**General purpose, arrays, average case matters?**  
→ **Quick Sort** — fastest in practice with random pivot or median-of-three.

**Is the input nearly sorted?**  
→ **Insertion Sort** (small n) or **Timsort/Merge Sort** (large n).

**Is the data a linked list?**  
→ **Merge Sort** — no random access needed, O(1) extra space for lists.

**Minimizing writes/swaps is the priority?**  
→ **Selection Sort** — at most n-1 swaps guaranteed.

**Streaming / online input?**  
→ **Insertion Sort** — maintains sorted prefix as elements arrive.

### Classic Exam Scenario Mapping

| Scenario                                               | Best Algorithm   | Reason                                                               |
|--------------------------------------------------------|------------------|----------------------------------------------------------------------|
| Nearly sorted, one element out of place                | Insertion Sort   | O(n) — only 1 element needs shifting; nearly 0 inversions            |
| Range is [0, 3^N], small n                            | Counting Sort    | Integer range, bounded; k = 3^N + 1 (watch if k >> n then reconsider)|
| Array is exactly [1000, 1001, …, 999+N] (consecutive) | Counting Sort    | n integers, range = N, so k = n; perfect for Counting Sort           |
| Strictly descending, needs ascending                   | Merge Sort       | Worst case for Quick Sort (already ordered); Merge Sort is safe      |
| Two adjacent elements swapped, rest sorted             | Insertion Sort   | Exactly 1 inversion — O(n) adaptive behavior                         |
| Guaranteed worst-case + stable + large data            | Merge Sort       | Only comparison sort satisfying all three                            |

### Lower Bound Note
Any comparison-based sorting algorithm requires **Ω(n log n)** comparisons in the worst case. This is proven via decision tree argument: a decision tree for n elements has n! leaves; a binary tree of height h has at most 2^h leaves, so h ≥ log₂(n!) = Θ(n log n) by Stirling's approximation.

Counting Sort, Radix Sort, and Bucket Sort escape this bound by not using comparisons — they exploit structure in the keys.

---

## Key Definitions for Exam

**Stable sort:** A sort is stable if elements with equal keys appear in the output in the same relative order as in the input.

**In-place sort:** A sort is in-place if it uses O(1) auxiliary space beyond the input array (recursion stack not counted by some definitions — clarify if needed).

**Adaptive sort:** A sort is adaptive if its complexity improves when the input is partially sorted (measured by number of inversions, runs, etc.).

**Inversion:** A pair (i, j) where i < j but arr[i] > arr[j]. The number of inversions measures how "unsorted" an array is. A fully sorted array has 0 inversions; a reverse-sorted array has n(n-1)/2 inversions.

**Comparison sort lower bound:** Ω(n log n) comparisons required in the worst case for any comparison-based sorting algorithm.
