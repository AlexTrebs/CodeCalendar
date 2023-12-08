#!/usr/bin/env python
import sys

def get_input_file(*args):
    file_name = "input_file.txt"
    if(len(args[0]) == 1):
        with open(args[0][0],'r') as i:
            lines = i.readlines()
    else:
        with open(file_name,'r') as i:
                lines = i.readlines()
    print(lines)


if __name__ == "__main__":
    get_input_file(sys.argv[1:])