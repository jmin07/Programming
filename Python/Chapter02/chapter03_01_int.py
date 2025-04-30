

"""
    # Chapter03-01
    # 파이썬 완전 기초
    # 숫자형

    '''
    파이썬 지원 자료형
        int: 정수
        float: 실수
        complex : 복소수
        bool : true, false
        str: 문자열(시퀀스)
        list: 리스트(시퀀스)
        tupe: 튜플(시퀀스)
        set: 집합
        dict: 사전
    '''
    

"""


# 데이터 타입
str1 = 'Python'
bool = True
str2 = 'Anaconda'
float = 10.0    # 10(정수) == 10.0(실수) 은 컴퓨터는 다르게 판단. 
int = 7
list = [str1, str2]  # 대괄호
dict = {
    "name" : "Machine Learning",
    "version" : 2.0
}
tuple = (7, 8, 9)   # 소괄호
set = {7, 8, 9}     # 중괄호

# 데이터 타입 출력
print(type(str1))
print(type(bool))
print(type(str2))
print(type(float))
print(type(list))
print(type(dict))
print(type(tuple))
print(type(set))

print()


# 숫자형 연산자
"""
 +
 -
 *
 / 
 // : 몫
 % : 나머지
 abs(x): 절대값
 pow(x, y), x ** y: 제곱
"""

# 정수 선언
i = 77
i2 = -14
big_int = 777777777777777777777777777999999999999999

# 정수 출력
print(i)
print(i2)
print(big_int)

print()

# 실수 출력
f = 0.9999
f2 = 3.141592
f3 = -3.9
f4 = 3 / 9

print(f)
print(f2)
print(f3)
print(f4)

# 연산 실습
i1 = 39
i2 = 3939
big_int1 = 77777777777777777777999999999934343
big_int2 = 34785237418024701279017411111111111
f1 = 1.234
f2 = 3.939