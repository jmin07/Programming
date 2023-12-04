
"""
    # Chapter02-3
    # 파이썬 완전 기초
    # 파이썬 변수
"""

# 기본 선언
# 변수 할당한다
# 메모리에 n이 있는 저장 장소에 가서 확인하는 것이다.
n = 700

# 출력
print(n)
print(type(n))
print('')


# 동시 선언
x = y = z = 700
print(x, y, z)


# 선언
var = 75

# 재선언
var = 'Change Value'

# 출력
print(var)
print(type(var))


# Object References
# 변수 값 할당 상태
## 1. 타입에 맞는 오브젝트 생성
## 2. 값 생성
## 3. 콘솔 출력

# 예 1)
print(300)
print(int(300))


# 예 2)
# n -> 777
n = 777
print(n, type(n))

m = n 

print(m, n)


n = 300
print(m, n)


# id(identity) 확인: 객체의 고유값 확인
m = 800
n = 655

print(id(m))
print(id(n))

print()

m = n 

print(id(m) == print(n))


m = 800
n = 800
i = 800
z = 800



# 똑같은 값이 다른 변수에 할당 되어 있어
# 같은 오브젝트 참조
print(id(m) == id(n) == id(z) == id(i)) 


# 다양한 변수 선언
# 암묵적으로 사용한다.
# Camel Case : numberOfCollegeGraduates => Method
# Pascal Case : NumberOfCollegeGraduates => class
# Snake Case : number_of_college_graduates => python 변수 선언에서 많이 사용됨


# 예약어는 사용 불가능
# reserved words
