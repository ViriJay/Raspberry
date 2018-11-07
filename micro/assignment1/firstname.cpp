#include "firstname_array.h"
std::string generate_firstname()
{
	return firstname[rand() % (firstname.size() - 1)];
}
