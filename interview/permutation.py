# string - abc
# Find all permutations of this string


def perm(i,j,ans):
    print(i,j)
    if i==j:
        print(''.join(ans))
        return
    else:
        for index in (i,j):
            # print(index,i)
            ans[index],ans[i]=ans[i],ans[index]
            perm(i+1,j,ans)
            ans[index],ans[i]=ans[i],ans[index]
    
# s=input()
s='abc'
ans=list(s)
print(perm(0,len(ans),ans))



# dabc
#d
#(abc)
# a, (bc)
# abc  acb  
#  bc   cb


# b , ac
# bac bca

# a   c
# ac  ca 

# c , ab
# cab , cba
# ab ba


# a 
# dbc (adbc, adcb)
# d bc ->(dbc,dcb)
# b c ->(bc,cb)

# b dc ->

# a, (bcd)
# b, (acd) -> (a, cd) (c,ad), (d,ca)
# c , bad,

