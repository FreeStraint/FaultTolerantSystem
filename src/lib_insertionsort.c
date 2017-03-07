#include <jni.h>
#include <stdio.h>
#include "InsertionSort.h"

//Implementaion of native method insertsort
JNIEXPORT jintArray JNICALL Java_InsertionSort_insertsort
  (JNIEnv *env, jobject thisObj, jintArray jarr){
    int memAccess = 0;
    int i;
    jsize len = (*env)->GetArrayLength(env, jarr);
    memAccess += 1;
    jint *body = (*env)->GetIntArrayElements(env, jarr, 0);
    memAccess += 1;

    for(i = 1; i<len; i++){
      memAccess += 2;
      int j = i;
      memAccess += 2;

      while(j > 0 && body[j-1] > body[j]){
        memAccess += 3;
        int temp = body[j];
        memAccess += 2;
        body[j] = body[j-1];
        memAccess += 2;
        body[j-1] = temp;
        memAccess += 2;
        j = j-1;
        memAccess += 1;
      }
    }

    int rArray[len+1];
    memAccess ++;
    for(i = 0; i<len; i++){
      rArray[i] = body[i];
      memAccess += 2;
    }
    rArray[len] = memAccess;

    jintArray returnArray = (*env)->NewIntArray(env, len+1);
    (*env)->SetIntArrayRegion(env, returnArray,0,len+1,rArray);

    memAccess += len;

  return returnArray;
}
