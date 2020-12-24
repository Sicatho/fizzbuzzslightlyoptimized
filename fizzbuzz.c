#include <stdio.h>

int main() {
  char a;
  const char fizzbuzz[3][5] = {
    "",
    "Buzz",
    "Fizz"
  };
  for (int i = 1; i <= 100; i++) {
    a = (!(i%3)<<1) | !(i%5);
    if (!a) {
      printf("%d\n", i);
    } else {
      printf("%s%s\n", fizzbuzz[a&0x2], fizzbuzz[a&1]);
    }
  }
  return 0;
}
