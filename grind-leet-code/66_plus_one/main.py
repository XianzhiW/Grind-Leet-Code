
class Solution:
    def plusOne(self, digits: list[int]) -> list[int]:
        digits = digits[::-1]
        i = 0
        carry = 1
        while carry:
            if i < len(digits):
                if digits[i] == 9:
                    digits[i] = 0
                else:
                    digits[i] = digits[i] + 1
                    carry = 0
            else:
                digits.append(1)
                carry = 0
            i += 1
        return digits[::-1]



mylist = [1,2,3]
print(mylist[::-1])
yourlist = [9,9,9,9]

soln = Solution()
print(soln.plusOne(mylist))
print(soln.plusOne(yourlist))









