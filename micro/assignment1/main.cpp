#include "firstname.h"
#include "lastname.h"
#include <iostream>
#include <string>
#include <ctime>
int main()
{
	srand(time(0));
	std::cout << generate_firstname() << " " << generate_lastname() << std::endl;
	return 0;
}
