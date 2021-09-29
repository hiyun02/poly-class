class HousePark:
    lastname="박"
    def __init__(self, name):
        self.fullname=self.lastname+name
    def travel(self, where):
        print("%s,%s 여행을 가다." %(self.fullname, where))

class HouseKim(HousePark):
    lastname = "김"
