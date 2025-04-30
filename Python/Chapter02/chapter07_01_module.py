'''
    # Chapter06-01
    # 파이썬 완전 기초

    # Module: 함수, 변수, 클래스 등 파이썬 구성 요소 등을 모아놓은 파일

'''


def add (x: int, y: int) -> int:
    return x + y


def subtract(x:int, y:int) -> int:
    return x - y


def multiply(x:int, y:int) -> int:
    return x * y


def divide(x:int, y:int) -> float:
    return x / y


def power(x:int, y:int) -> float:
    return x ** y



print('-' * 15)
print('called! inner!')
print(add(5, 5))
print(subtract(15, 5))
print(multiply(5, 5))
print(divide(10, 2))
print(power(5, 2))
