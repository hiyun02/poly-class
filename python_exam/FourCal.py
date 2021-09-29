class FourCal:

    def WhatisSelf(self):
        print(self)

    def setdata(self, first, second):
        self.first = first
        self.second = second

    def sum(self):
        result = self.first + self.second
        return result
    def sub(self):
        result = self.first - self.second
        return result
    def mul(self):
        result = self.first * self.second
        return result
    def div(self):
        result = self.first / self.second
        return result

#클래스 FourCal의 인스턴스인 객체 a
a=FourCal()
#파이썬 클래스에서 사용하는 인수 self란 무엇일까
a.WhatisSelf()
#클래스의 인스턴스인 a에 self를 이용하여 값을 저장
a.setdata(4,2)

b=FourCal()
b.WhatisSelf()
b.setdata(3,7)

print(a.sum())
print(a.sub())
print(a.mul())
print(a.div())

print(b.sum())
print(b.sub())
print(b.mul())
print(b.div())
