n = list(map(int, input().split()))
t = list(map(int, input().split()))
s = {}
for i in range(len(t)):
	s[t[i]] = i
for j in range(n[1]):
	x = list(map(int, input().split()))
	print(s[x[1]] - s[x[0]] + 1)