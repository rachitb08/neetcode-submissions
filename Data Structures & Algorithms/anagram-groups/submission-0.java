class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            // Sort the character array to create a unique key for anagrams
            Arrays.sort(ch);

            String sortedStr = new String(ch);
            // Add the original string to the corresponding anagram group
            // If key doesn't exist, create a new ArrayList for this group
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        // Return all anagram groups as a list of lists
        return new ArrayList<>(map.values());
    }
}
