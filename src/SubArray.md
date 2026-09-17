# `SubArray`

`SubArray.java` demonstrates fixed-size and variable-size sliding-window techniques. All methods print their results to standard output rather than returning a value.

## Methods

### `maxSum(int[] numArray, int size)`

- **What it does:** Checks each candidate window and prints the largest sum.
- **Input:** An integer array and the requested window size.
- **Output:** Intermediate window sums and the maximum sum.
- **Time complexity:** `O(n)` in the current code because each window always sums exactly three elements. A general implementation that recalculates all `k` elements would be `O(n * k)`.
- **Note:** The calculation is hard-coded for a window size of `3`; `size` is used only to control the loop.

### `maxSumOptimal(int[] numArray, int size)`

- **What it does:** Finds the maximum fixed-window sum by subtracting the outgoing element and adding the incoming element.
- **Input:** An integer array and the window size.
- **Output:** Intermediate window sums and the maximum sum.
- **Time complexity:** `O(n)`.
- **Note:** Initialization is hard-coded to three elements, so the method is correct only when `size` is `3`.

### `getTargetSum(int[] numArray, int size, int target)`

- **What it does:** Counts fixed-size subarrays whose sum equals `target`.
- **Input:** An integer array, window size, and target sum.
- **Output:** The number of matching subarrays.
- **Time complexity:** `O(n)`.
- **Note:** The initial window is hard-coded to three elements, so the method is correct only when `size` is `3`.

### `hasSubstringAnagram(String word, String anagram)`

- **What it does:** Checks whether `word` contains a window with the same distinct characters as `anagram`.
- **Input:** The text to search and the candidate anagram.
- **Output:** A message stating whether a match was found.
- **Time complexity:** `O(n * k)` expected, where `k` is the anagram length, because set equality may inspect up to `k` characters for each window. With the current fixed length of three, this is effectively `O(n)`.
- **Note:** The setup is hard-coded to three characters. Using sets also loses character counts, so repeated characters are not handled as true anagrams.

### `countSubstringAnagram(String word, String anagram)`

- **What it does:** Uses character-frequency maps to count windows in `word` that are anagrams of `anagram`.
- **Input:** The text to search and the candidate anagram.
- **Output:** Debug information and the total number of matching windows.
- **Time complexity:** `O(n)` in the current code because both maps contain at most three entries. A generalized version that compares maps containing up to `k` characters is `O(n * k)`.
- **Note:** The initial frequency maps are hard-coded to the first three characters, so the method currently supports anagrams of length `3` only.

### `findSubArraySum(int[] numArray, int targetSum)`

- **What it does:** Uses a variable-size window to locate contiguous subarrays whose sum equals `targetSum`.
- **Input:** An integer array and a target sum.
- **Output:** The start and end indexes of each matching subarray.
- **Time complexity:** `O(n)` because both window pointers move forward at most `n` times.
- **Note:** The shrinking-window logic assumes non-negative array values.
