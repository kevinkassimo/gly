all:

tests: tests_basic

tests_basic:
	java Gly compile tests/example.gly
	java Gly execute tests/example.gly