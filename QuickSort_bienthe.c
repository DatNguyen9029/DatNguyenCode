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
	else printf("Loi mo file!\n");
	*n = i;
}
void Print_file(recordtype a[], int n) {
	int i;
	for(i = 0; i < n; i++) {
		printf("%3d%5d%8.2f\n", i+1, a[i].key, a[i].otherfields);
	}
}
//int FindPivot(recordtype a[], int i, int j) {
//	keytype firstkey;
//	firstkey = a[i].key;
//	int k = i+1;
//	while(k <= j && a[k].key == firstkey) k++;
//	if(k > j) return -1;
//	if(a[k].key > firstkey) return k;
//	return i;
//}
int PhanHach(recordtype a[], int i, int j) {
	int pivot = a[i].key;
	int L = i+1;
	int R = j;
	
	while(L <= R) {
		while(L <= R && a[L].key <= pivot) L++;
		while(L <= R && a[R].key >= pivot) R--;
		if(L < R) swap(&a[L], &a[R]);
	}
	swap(&a[R], &a[i]);
	return R;
}
void QuickSort(recordtype a[], int i, int j) {
	if(i < j) {
		int p = PhanHach(a, i, j);
		QuickSort(a, i, p-1);
		QuickSort(a, p+1, j);
	}
	
}

int main() {
	recordtype a[100];
	int n;
	Read_file(a, &n);
	printf("Thuat toan Quick Sort bien the\n\n");
	Print_file(a, n);
	printf("\n\n");
	QuickSort(a, 0, n-1);
	Print_file(a, n);
	
	
	return 0;
}

