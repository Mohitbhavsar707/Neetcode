# Problem: Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
# Example:
# Input: nums = [1, 2, 3, 3]
# Output: true



class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hashset = set()
        for n in nums:
            if n in hashset:
                return True
            hashset.add(n)
        return False
         