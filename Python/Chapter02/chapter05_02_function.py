
"""
    # Chapter05-01
    # 파이썬 완전 기초
    # 파이썬 함수 및 중요성
    # 파이썬 함수식 및 람다(Lambda)


    # 함수 정의 방법
    # def function_name(parameter):
    #   code
"""  


# 예제 1
def first_function(w):
    print('Hello,', w)


word = 'Goodboy'

first_function(word)


# 예제 2
def return_function(w1):
    return "Hello, " + str(w1)



# 예제 3(다중 반환)
def function_mul(x):
    y1 = x * 10
    y2 = x * 20
    y3 = x * 30

    return y1, y2, y3

x, y, z = function_mul(10)
print(x, y, z)


# 예제 4(튜플 리턴)
def function_mul(x):
    y1 = x * 10
    y2 = x * 20
    y3 = x * 30

    return (y1, y2, y3)

t = function_mul(20)
print(type(t), t)




# 예제 4(리스트 리턴)
def function_mul(x):
    y1 = x * 10
    y2 = x * 20
    y3 = x * 30

    return [y1, y2, y3]


l = function_mul(20)
print(type(l), l)


# 예제 4(딕셔너리 리턴)
def function_mul(x):
    y1 = x * 10
    y2 = x * 20
    y3 = x * 30

    return {'v1': y1, 'v2' : y2, 'v3' : y3}


d = function_mul(20)
print(type(d), d, d.get('v2'), d.items(), d.keys(), '\n')


# ★ 중요 
# *args, **kwargs
# 다른 언어에 없는 개념으로 헷갈릴 수 있다.


# *args(언팩킹)
# "튜플 형태"가 넘어올 때 많이 사용 된다.
def args_func(*args): # 매개변수 명은 자유
    for i, v in enumerate(args):
        print('Result : {}'.format(i), v)
    print('------------')



args_func('Lee')
args_func('Lee', 'Park')
args_func('Lee', 'Park', 'Kim')

print()


# **kwargs(언패킹)
# "딕셔너리 형태"
def kwargs_func(**kwargs): # 매개변수 명은 자유
    for v in kwargs.keys():
        print('{}'.format(v), kwargs[v])
    print('------------')


kwargs_func(name1='Lee')
kwargs_func(name1='Lee', name2='Park', name3='Kim')

print()

# 전체 혼합
def example(args_1, args_2, *args, **kwargs):
    print(args_1, args_2, args, kwargs)


example(10, 20, 'Lee', 'Kim', 'Park', age1=10, age2=20, age3=30)

# 중첩 함수
def nested_function(num):
    def func_in_func(num):
        print(num)
    print('In func')
    func_in_func(num + 100)


nested_function(100)


# 람다식 예제
# 장점: 메모리 절약, 가독성 향상, 코드 간결화
# 함수는 객체 생성 -> 리소스(메모리) 할당
# 람다는 즉시 실행 함수(Heap 초기화) -> 메모리 초기화
# 공통적 의견: 남발 시 가독성 오히려 감소

# 일반적 함수
def mul_func(x, y):
    return x * y

q = mul_func(10, 5)
print(q)

# 람다 함수
a = lambda x, y: x * y
print(a(5, 6))

print()

def func_final(x, y, func) -> int:
    print(x * y , func(100, 200))


func_final(100, 200, lambda x, y: x * y)
func_final(100, 200, mul_func)