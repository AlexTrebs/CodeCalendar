#!/usr/bin/env python3
import sys
from subprocess import check_output
def process_string(s):
    return s.replace("[","").replace("]","").replace("\'","").replace("\\n","").replace("\n","").replace("\r","")

def get_first_and_last_number(line):
    full_length_number = ''.join(filter(str.isdigit, process_string(line)))
    if(len(full_length_number) == 1):
        return int(full_length_number*2)
    elif(len(full_length_number) >= 2):
        return int(full_length_number[0]+full_length_number[-1])
    
count = sum(list(map(
    get_first_and_last_number ,
    check_output([sys.executable, "../getInputFile.py"]).decode(sys.stdout.encoding).strip('][').split(', ')
)))

print("The answer is: ", count)