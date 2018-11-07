#include "lastname_array.h"
std::string generate_lastname()
{
	return lastname[rand() % (lastname.size() - 1)];
}
