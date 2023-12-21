# Game of Worlds 

# |	Environment	    | Health Point (HP)	| Armor	|
# |	Air	            |+3	                | +2    |
# |	Deep-Sea        |-20                |-20    |	
# |	Monster Valley  |-50                |-30    |
# |	Water           |-10	            |-7		|
# |	WasteLand       |-30				|-80	|
# |	Space			|-15				|-12    |	
# |	Volcano	        |-50	            |+8	    |
# |	Fire			|-15				|+10	|
# -----------------------------------------------
# Starting Armour 50, HP 5
# Find max days to survive such that no days consecutively have the same environment

from typing import Dict,List,Tuple
def solve(envs:Dict[str,Tuple[int]],prev_env:str,hp:int,armour:int) ->int:
    if hp<0 or armour<0 :
        return 0
    maxDays=0
    for env in envs.keys():
        if env != prev_env:
            env_hp,env_armour=envs[env]
            maxDays=max(maxDays,1+solve(envs,env,hp+env_hp,armour+env_armour))
    return maxDays

envs = {'air':(3,2),'deep-sea':(-20,-20),'monster-valley':(-50,-30),'water':(-10,-7),'wasteland':(-30,-80),'space':(-15,-12),'volcano':(-50,8),'fire':(-15,10)}
hp=50
armour=5
print(solve(envs,"",hp,armour))
