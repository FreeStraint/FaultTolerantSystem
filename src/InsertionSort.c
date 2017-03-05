#include "jni.h"
#include <stdio.h>
#include "InsertionSort.h"

//Implementaion of native method insertsort
JNIEXPORT jintArray JNICALL Java_InsertionSort_insertsort
  (JNIEnv *env, jobject thisObj, jintArray jarr){
  	int memAccess = 0;
  	int i;
  	jsize len = (*env)->GetArrayLength(env, jarr);
  	jint *body = (*env)->GetIntArrayElements(env, jarr, 0);
  	for(i = 1; i<len; i++){
  		int j = i;
  		while(j > 0 && body[j-1] > body[j]){
  			//jint temp = (*env)->GetIntArrayElements(env, jarr, j);
  			int temp = body[j];
  			body[j] = body[j-1];
  			body[j-1] = temp;
  			j = j-1;
  		}
  	}

  	jintArray returnArray = (*env)->NewIntArray(env, len);

  	(*env)->SetIntArrayRegion(env, returnArray,0,len,body);
  	//(*env)->SetObjectArrayElements(env, returnArray,len,memAccess);

 //  	int array[sizeof(jarr)/sizeof(jarr[0])];
 //  	int i;
 //  	for(i = 0; i<sizeof(jarr); i++){
 //  		printf(jarr[i]);
 //  		array[i] = jarr[i];
 //  	}
 //  	printf("\n");
	// printf("Hello World\n");
	//return returnArray;
	return returnArray;
}