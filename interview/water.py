# Container with most water
# Leetcode: https://leetcode.com/problems/container-with-most-water/description/
heights= [2,1,2]

def water_area(heights):
    res=0
    l=0
    r=len(heights)-1

    while l<=r:
        area = (r-l) * min(heights[l],heights[r])
        res= max(area,res)

        if heights[l]<heights[r]:
            l=l+1
        elif heights[r]<heights[l]:
            r=r-1
        else:
            r=r-1
    return res

print(water_area(heights=heights))