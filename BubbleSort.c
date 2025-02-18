#include <stdio.h>

typedef int keytype;
typedef float othertype;

typedef struct {
	keytype key;
	othertype otherfields;
} recordtype;

void swap(recordtype *a, recordtype *b) {
	recordtype temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

void Read_file(recordtype a[], int *n) {
	FILE *f;
	f = fopen("data.txt", "r");
	int i = 0;
	if(f!=NULL)
	while(!feof(f)) {
		fscanf(f, "%d%f", &a[i].key, &a[i].otherfields);
		i++;
	}
	else printf("Loi mo file!");
	*n = i;
}
void Print_file(recordtype a[], int n) {
	int i;
	for(i = 0; i < n; i++) {
		printf("%3d%5d%8.2f\n", i+1, a[i].key, a[i].otherfields);
	}
}
void Bubble_sort(recordtype a[], int n) {
	int i,j;
	for(i = 0; i < n-1; i++) {
		for(j = n-1; j >= i+1; j--) {
			if(a[j].key < a[j-1].key) {
				swap(&a[j], &a[j-1]);
			}
		}
	}
}



int main() {
	recordtype a[200];
	int n;
	Read_file(a, &n);
	
	printf("Thuat toan Bubble sort\n\n");
	
	Print_file(a, n);
	Bubble_sort(a, n);
	printf("\n\n");
	Print_file(a, n);
	

	return 0;
}
