import sys

n=1
args = sys.argv[1:]
for i in args:
    print(str(n)+' 번째로 받아온 인수 :'+i)
    n=n+1