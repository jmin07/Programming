
"""
    # Chapter05-01
    # 파이썬 완전 기초
    # 함수란?


    # 함수
    # 프로그래머가 이름을 통해서 정의 후 필요할 때 마다 호출
    # 반복 되는 코드를 한 번 구현 후 재사용 가능한 코드의 집합
    # 함수 구현 -> 재사용, 루틴(프로시저, 서브루틴)

    # 종류
    # 1. 매개변수가 필요한 함수
    # 2. 매개변수가 필요하지 않은 함수
    # 3. 결과 값을 반환하는 함수(return)
    # 4. 결과 값을 반환하지 않는 함수

"""  



# 예제 1: 매개변수 필요 X, 리턴 X
def function_frist():
    print('예제1 호출')


# 예제 2: 매개변수 필요 O, 리턴 X
def function_second(a, b):
    print(f'{a}, {b}')


# 예제 3: 결과값 반환 X
def function_third(x, y):
    print(f'{x}, {y}')

# 예제 4: 결과값 반환 O
def function_fourth(x, y):
    return x + y


# 실행
function_frist()
function_second(1, 2)
function_third(10, 20)
a = function_fourth(100, 200)
print('예제 4번 호출 : ', a)

