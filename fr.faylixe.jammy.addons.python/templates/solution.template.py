import sys
# Insert your import here.

def solve(stream):
	# Implement your solving method here.
	return

# Script entry point, read the file
# given in the parameter and execute
# solve method for each test case.
# DO NOT MODIFY THIS PART UNLESS YOU KNOW WHAT YOU ARE DOING !
if __name__ == "__main__":
	input = sys.argv[1]
	file = open(input, "r")
	T = int(file.readline().strip())
	for t in xrange(T):
		result = solve(file)
		print("Case #%d: %s") % (t + 1, result)
	file.close()