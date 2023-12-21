#Input = 'a2b3cd2' #=> 'aabbbcdcd'

def decompress(s:str):
    result=[]
    i=0

    while i < len(s):
        curr = ''
        while i < len(s) and s[i].isalpha():
            curr=curr+s[i]
            i=i+1
        #print(curr)
        #i=i+1

        count = 0
        while i<len(s) and s[i].isdigit() :
            count= count*10 + int(s[i])
            i=i+1
        result.append(curr*count)
    return ''.join(result)

s = 'leet2code3'
print(decompress(s))
