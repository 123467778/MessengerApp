package com.example.Messenger.Model;

public enum Status {
    Active(1),
    InActive(-1);


   private int val;

   Status (int val){
     this.val=val;
   }

   public int getVal(){
       return val;
   }

   public static Status fromValue(int val){
       return val ==1? Active :InActive;
   }

}
