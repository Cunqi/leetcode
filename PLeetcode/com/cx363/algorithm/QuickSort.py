'''
QuickSort Demo

Created on Oct 20, 2014

@author: xiaocunqi
'''
import random
class QuickSort:
    DESCENT = 1
    ASCENT  = 0
    def sort(self, data, order = 0):
        rand = random.Random()
        low = 0
        high = len(data)
        
        self.__quickSort(data, order, low, high - 1, rand)
        
        return data
    
    def __quickSort(self, data, order, low, high, rand):
        if high - 1 <= low:
            pass
        else:
            sentry_index = rand.randrange(low, high)
            
            sentry = data[sentry_index]
            
            self.__swipe(data, sentry_index, high)
            
            index = low
            for i in range(low, high):
                
                if order == QuickSort.ASCENT:
                    if data[i] <= sentry:
                        self.__swipe(data, i, index)
                        index += 1
                else:
                    if data[i] >= sentry:
                        self.__swipe(data, i, index)
                        index += 1
                
                
            self.__swipe(data, index, high)
            sentry_index = index
                
            self.__quickSort(data, order, low, sentry_index - 1, rand)
            self.__quickSort(data, order, sentry_index + 1, high, rand)
    
    def __swipe(self, data, source, target):
        tmp = data[source]
        data[source] = data[target]
        data[target] = tmp
        
            
quickSort = QuickSort()
numbers = [1, 5, 3, 77, 9, 2, 10, 7, 8]

print(quickSort.sort(numbers))
            
                    
            