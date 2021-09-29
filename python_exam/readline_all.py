f=open("C:\poly-class\python_exam\새파일.txt", 'r')

while True:
    line = f.readline()
    print(line)
    if not line: break
f.close()