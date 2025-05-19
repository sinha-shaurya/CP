from typing import List
def largestNumber(nums: List[int]) -> str:
    def comp(s1: str, s2: str):
        x = s1 + s2
        y = s2 + s1
        if x > y:
            1
        elif x < y:
            return -1
        return 0

    n = [str(i) for i in nums]
    from functools import cmp_to_key

    ns = sorted(n, key=cmp_to_key(comp), reverse=True)
    print("Sorted array", ns)
    large = ""
    zeros = 0
    for i in ns:
        print(i)
        if i== "0":
            zeros += 1
        else:
            large = large + i

    print("large ", large)
    print(zeros)
    if large == "":
        return "0"
    large = large + "0" * zeros
    return large

print(largestNumber([0,0]))
