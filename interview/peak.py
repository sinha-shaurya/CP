# Find peak element in array
# Leetcode: https://leetcode.com/problems/find-peak-element/description/
from typing import List

def findPeakElement(a:List[int]):
    if len(a) == 1:
        return a[0]
    
    lo=0
    hi=len(a)-1

    while lo<=hi:
        mid = lo+(hi-lo)//2
        if mid>0 and a[mid-1]>a[mid]:
            hi=mid-1
        elif mid<len(a)-1 and a[mid+1] > a[mid]:
            lo=mid+1
        else:
            return a[mid]
    
    return -1

a=[5, 6, 7,8, 17, 100, 11, 9, 7 , 6, 5, 4]
print(findPeakElement(a))