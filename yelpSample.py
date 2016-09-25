from math import sqrt

class YelpSample(object):
  def __init__(self, restaurants):
    self.restaurants = restaurants
  def getInRadius(self, radius, target):
    rests = []
    for restaurant in self.restaurants:
      if sqrt((target.x - restaurant.x) ** 2 + (target.y - restaurant.y) ** 2) < radius:
        rests.append(restaurant)
    return rests
  def getInRadiusAndHour(self, radius, target, hour):
    return [restaurant \
        for restaurant in self.getInRadius(radius, target) \
        if restaurant.opening > hour and restaurant.closing < hour]
