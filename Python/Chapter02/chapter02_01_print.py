import sys

"""
    # Chapter02-1
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

# Print 사용법
print('Python Strat!')      # 작은 따옴표를 많이 사용한다.
print("Python Strat!")      # 큰 따옴표
print('''Python Strat!''')
print("""Python Strat!""")

print()

# seperator 옵션
print('P', 'Y', 'T', 'H', 'O', 'N')         # P Y T H O N
print('P', 'Y', 'T', 'H', 'O', 'N', sep='') # PYTHON
print('010', '7777', '1234', sep='-')       # 010-7777-1234

print()

# end 옵션
# \n 옵션을 어떻게 처리하는지 선택하는 옵션
print('Welecom to', end=' ')
print('IT News', end='')
print('Web Site')


# file 옵션
# print에 작성한 내용을 특정 파일로 이동(?)하는 옵션
# sys.stdout은 콘솔에 출력해준다.
print('Learn Python', file=sys.stdout)

print()

# format 사용(d: 3, s: 'python'. f: 3.1445454)
print('%s %s' % ('one', 'two'))
print('{} {}'.format('one', 'two'))
print('{1} {0}'.format('one', 'two'))   # index 순서를 변경한다.

print()


# %s
print('오른쪽')
print('%10s' % ('nice')) # 총 10자리 (왼쪽부터 공백)
print('{:>10}'.format('nice'))

print('\n왼쪽')
print('%-10s' % ('nice')) # 총 10자리 (오른쪽부터 공백)
print('{:10}'.format('nice'))
print('{:<10}'.format('nice'))

print('\n공백')
print('{:_>10}'.format('nice')) # 공백에 언더바(_)가 출력
print('{:^10}'.format('nice')) # 10개 공간 중에 "중앙정렬"

print('\n문자 자르기')
print('%.5s' % ('pythonstudy')) # 5글자만 출력이 된다.
print('%-10.5s' % ('pythonstudy'))
print('{:>10.5}'.format('pythonstudy'))

print()

# %d
print('%d %d' % (1, 2))
print('{} {}'.format(1, 2))

print('%4d' % (42))
print('{:4d}'.format(42))

print('%-4d' % (42))
print('{:<4d}'.format(42))



# %f
print('%1.8f' % (3.1452512412343)) # 정수는 한 자리, 소수는 8자리까지 출력
print('%06.2f' % (3.145672341234))      # 정수 여섯 자리 / 소수 두 자리 / 나머지는 0으로
print('{:06.2f}'.format(3.123235234))