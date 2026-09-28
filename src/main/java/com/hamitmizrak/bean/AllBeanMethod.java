package com.hamitmizrak.bean;

abstract public class AllBeanMethod {

    // Bean oluşturuludğunda çalışacak metot
  abstract   public void onInit();

    // Bean yok edilmeden hemen önce çalışacak metot
  abstract  public void onDestory();
}
