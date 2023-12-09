#!/usr/bin/env python3
import re
import sys
from subprocess import check_output

def process_string(s):
    return s.replace("[","").replace("]","").replace("\'","").replace("\\n","").replace("\n","").replace("\r","")

def process_dict_entry(e):
    return process_string(e).split(" ")

def find_alpha_numbers_in_string(s,dict):
    for key in possible_numbers:
        for i in [m.start() for m in re.finditer(possible_numbers[key], s.lower())]:
            dict[i] = key
    
    return dict

def find_numeric_numbers_in_string(s, dict):
    for idx, c in enumerate(process_string(s)):
        if(c.isnumeric()):
            dict[idx] = c

    return dict

def replace_numbers_in_string(s):
    number_dictionary = {}
    number_dictionary = find_numeric_numbers_in_string(s,number_dictionary)
    number_dictionary = find_alpha_numbers_in_string(s,number_dictionary)
    
    return ''.join(v for v in dict(sorted(number_dictionary.items())).values())

def get_first_and_last_number(line):
    full_length_number = replace_numbers_in_string(line)
    if(len(full_length_number) == 1):
        return int(full_length_number*2)
    elif(len(full_length_number) >= 2):
        return int(full_length_number[0]+full_length_number[-1])
    
possible_numbers = dict(map(
    process_dict_entry,
    check_output([sys.executable, "../getInputFile.py", "possibleNumbers.txt"]).decode(sys.stdout.encoding).strip('][').split(', ')
))

count = sum(list(map(
    get_first_and_last_number, 
    check_output([sys.executable, "../getInputFile.py"]).decode(sys.stdout.encoding).strip('][').split(', ')
)))
    
print("The answer is: ", count)