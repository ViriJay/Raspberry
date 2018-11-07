all: generate

firstname_array.h: firstname.txt
	echo "#include <vector>" > firstname_array.h
	echo "#include <string>" >> firstname_array.h
	echo "std::vector<std::string> firstname = {" >> firstname_array.h
	sed 's/.*/"&",/' firstname.txt >> firstname_array.h
	echo "};" >> firstname_array.h

lastname_array.h: lastname.txt
	echo "#include <vector>" > lastname_array.h
	echo "#include <string>" >> lastname_array.h
	echo "std::vector<std::string> lastname = {" >> lastname_array.h
	sed 's/.*/"&",/' lastname.txt >> lastname_array.h
	echo "};" >> lastname_array.h

firstname.o: firstname.cpp firstname.h firstname_array.h
	g++ -std=c++11 -Wall -o firstname.o firstname.cpp -c

lastname.o: lastname.cpp lastname.h lastname_array.h
	g++ -std=c++11 -Wall -o lastname.o lastname.cpp -c

generate: main.cpp firstname.o lastname.o
	g++ -std=c++11 -Wall -o generate firstname.o lastname.o main.cpp

clean:
	rm *.o *_array.h
