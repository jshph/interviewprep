import math
def insertionSort(array):
  for i in range(1, len(array) - 1):
    x = array[i]
    j = i - 1
    while j > 0 and array[j] > x:
      array[j + 1] = array[j]
      j -= 1
    array[j + 1] = x
  return array
# print(insertionSort([1,4,6,2,3,9]))

def mergeSort(ar):
  if len(ar) > 1:

    mid = math.floor(len(ar) / 2)
    left = ar[0:mid]
    right = ar[mid:]

    mergeSort(left)
    mergeSort(right)

    l, r = 0, 0
    for i in range(len(ar)):
      lval = left[l] if l < len(left) else None
      rval = right[r] if r < len(right) else None

      if (lval is not None and rval is not None and lval < rval) or rval is None:
        ar[i] = lval
        l += 1
      elif (lval is not None and rval is not None and lval >= rval) or lval is None:
        ar[i] = rval
        r += 1

ar = [1,4,5,2,9,20,100,2,300,4,300,2,9,7,5,3,5,2]
mergeSort(ar)
print(ar)
