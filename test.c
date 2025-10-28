#include <stdio.h>

int main() {
	printf("Hello world!!\n");
	int arr[6] = {2,3,5,7,6,8};
	for(int i = 0; i < 6; i++) {
		if(arr[i] % 2 == 0) {
			printf("%d ", arr[i]);
		}
	}
}