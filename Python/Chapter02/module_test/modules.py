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


# __main__ 사용 (내 자신을 실행할 때)
# 해당 모듈을 직접 실행할 때, 실행이 된다.
# 다른 곳에서 import 해서 사용 될 때는 실행이 안 된다.
# 다른 사람이 모듈을 테스트(참고) 할 수 있는 코드 등을 작성할 수 있다.
if __name__ == '__main__':
    print('-' * 15)
    print('called! inner!')
    print(add(5, 5))
    print(subtract(15, 5))
    print(multiply(5, 5))
    print(divide(10, 2))
    print(power(5, 2))

