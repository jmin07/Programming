
"""
    # Chapter02-2
    # 파이썬 완전 기초

    # 매개변수 (parameter)
        def add (a, b) {
            return a + b;
        }
        a와 b 는 파라미터

    # 전달인자 (argument)
        add(3, 4)
        3과 4는 전달인자
    
    # 이스케이프

        \n : 개행
        \t : 탭
        \\ : 문자
        \' : 문자
        \" : 문자
        \000 : 널 문자

    -------------------------------

    # print 함수
    (function) def print(
        *values: object,
        sep: str | None = " ",
        end: str | None = "\n",
        file: SupportsWrite[str] | None = None,
        flush: Literal[False] = False
    ) -> None


"""


### 3가지 Format Practices

x = 50
y = 100
text = 3082767
n = 'Lee'


# 출력 1
# %는 사용은 잘 안 하지만 알고는 있자!
ex1 = 'n = %s, s = %s, sum=%d' % (n, text, (x + y))

print(ex1)


# 출력 2
ex2 = 'n = {n}, s = {s}, sum={sum}'.format(n=n, s=text, sum=x+y)

print(ex2)


# 출력 3
# ★★ 새로 생긴 표현 방식 ★★
ex3 = f'n = {n}, s = {text}, sum={x + y}'

print(ex3)
print(f'n = {n}, s = {text}, sum={x + y}')



m = 1000000
print(f'm : {m:,}')


# 정렬
# ^ : 가운데, < : 왼쪽, > : 오른쪽

t = 20
print(f't : {t:10}')
print(f't cetner : {t:^10}')
print(f't left : {t:<10}')
print(f't right : {t:>10}')


print()
print(f't cetner : {t:-^10}')   # 빈 칸은 '-' 로 채워진다.
print(f't cetner : {t:#^10}')   # 빈 칸은 '#' 로 채워진다.
