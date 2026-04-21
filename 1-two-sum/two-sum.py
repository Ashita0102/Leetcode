class Solution:
    def twoSum(self, nums, target):
        index_of = {}  # value -> index

        for i, x in enumerate(nums):
            need = target - x
            if need in index_of:
                return [index_of[need], i]
            index_of[x] = i

        # Problem guarantees exactly one solution, so we usually don't reach here
        return []