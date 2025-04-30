'''
    # Chapter06-01
    # 파이썬 완전 기초

    # OOP(객체 지향 프로그래밍)
    # 클래스, 인스턴스
    # self 개념
    # 인스턴스 메소드
    # 클래스, 인스턴스 변수

'''


# 클래스 and 인스턴스 차이 이해
# 네임스페이스 : 객체를 인스턴스화 할 때 저장된 공간
# 클래스 변수 : 직접 접근 가능
# 인스턴스 변수 : 객체마다 별도 존재


# 예제 1
class Dog: # object 삭속
    # 클래스 속성(변수)
    species = 'firstdog'

    # 초기화 / 인스턴스 속성(생성자)
    # 인스턴스 변수
    def __init__(self, name: str, age: int) -> None:
        self.name = name
        self.age = age

# 클래스 정보
print(Dog)

# 인스턴스화
a = Dog('mikky', 2)
b = Dog('baby', 3)

# 비교
print(a == b, id(a), id(b))

# 네임스페이스
print('dog1', a.__dict__)
print('dog2', b.__dict__)

# 인스턴스 속성 확인
print('{} is {} and {} is {}'.format(a.name, a.age, b.name, b.age))

if a.species == 'firstdog':
    print('{} is a {}'.format(a.name, a.species))


print(Dog.species)
print(a.species)
print(b.species)



# 예제 2
# self 의 이해
# 기본 생성자를 자동으로 생성해준다.
class SelfTest:
    def func1(): # self가 없으면 클래스 메소드
        print('Func1 called')
    def func2(self): # 인스턴스 메소드
        print('Func2 called')

f = SelfTest()

print(dir(f))
print(id(f))
# f.func1() # 예외가 발생한다.
f.func2()
SelfTest.func1()
# SelfTest.func2() # 예외가 발생한다.
SelfTest.func2(f)



# 예제 3
# 클래스 변수, 인스턴스 변수
class Warehouse:
    # 클래스 변수
    stock_num = 0 # 재고

    def __init__(self, name:str) -> None:
        # 인스턴스 변수
        self.name = name
        Warehouse.stock_num += 1 # 초기화 할 때, 1을 더 해준다.

    def __del__(self):
        Warehouse.stock_num -= 1

user1 = Warehouse('Lee')
user2 = Warehouse('Cho')

print(Warehouse.stock_num)
print(user1.name)
print(user2.name)
print(user1.__dict__) # stock_num 에는 출력 되지 않는다.(공통은 다 출력해주지 않는다(?))
print(user2.__dict__)

print()

print('before', Warehouse.__dict__)
print('>>>', Warehouse.stock_num)


del user1
print('after', Warehouse.__dict__)
print('>>>', Warehouse.stock_num)


print()

# 예제 4
class Dog2: # object 삭속
    # 클래스 속성(변수)
    species = 'firstdog'

    # 인스턴스 변수
    def __init__(self, name: str, age: int) -> None:
        self.name = name
        self.age = age
    
    def info(self):
        return '{} is {} year old'.format(self.name, self.age)
    
    def speak(self, sound:str):
        return '{} says {}!'.format(self.name, sound)
    

# 인스턴스 생성
c = Dog2('july', 4)
d = Dog2('Marry', 10)

# 메소드 호출
print(c.info()) # 문자열로 return 된다.
print(c.speak('Wal Wal'))
print(d.speak('Mung Mung'))
