
def countWays(rem, idx):
	if rem == 0 and idx < 0:
		return 0
	elif rem == 0:
		return 1

	return countWays(rem, idx) + countWays(rem - denoms[idx], idx - 1)