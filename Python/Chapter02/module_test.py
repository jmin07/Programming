# 모듈 사용 실습

# 모듈이 모이면 패키지가 된다.

import sys

print(sys) # <module 'sys' (built-in)>
print(sys.path)

# 모듈 경로 삽입
# 해당 방법으로 직접 가져오는 것은 자제하는 것이 좋다(?)
# sys.path.append('C:\\workspace\\06.Education\\파이썬\\Chapter02\\module_test')

# print(sys.path)
# import modules

# print(modules.add(1, 2))