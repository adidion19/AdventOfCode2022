def signum(x):
    return 0 if not x else ( -1 if x < 0 else 1)

def moveTail(last, i):

    yd = last[i-1][0] - last[i][0]
    xd = last[i-1][1] - last[i][1]
    if yd ** 2 + xd ** 2 > 2: 
        last[i] = (last[i][0] + signum(yd), last[i][1] + signum(xd))
    return last[i]

if __name__ == '__main__':

    with open('input.txt','r') as fileobj:
        ret = 0
        dict = {'L':(0, -1), 'R':(0, 1), 'U':(-1, 0), 'D':(1, 0)}
        history = set()
        last = [(0, 0) for _ in range(10)]
        while (1):  
  
            line = fileobj.readline()
            if not line:
                break
            d, num = line.split()
            num = int(num)
            for _ in range(num):
                last[0] = (last[0][0] + dict[d][0], last[0][1] + dict[d][1])
                for i in range(1, 10):
                    last[i] = moveTail(last, i)
                    if i == 9:
                        history.add(last[i])
        ret = 0
        for i in history:
            ret += 1
        print(ret)